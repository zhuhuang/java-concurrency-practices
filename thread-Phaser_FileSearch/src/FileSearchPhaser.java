/**
 *  File: FileSearchPhaser.java
 *  Package: 
 *  Project: thread-FileSearchPhaser
 *  Created on: Mar 1, 2013
 * 
 *  Description: running concurrent phased tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.io.File;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class FileSearchPhaser implements Runnable {
	private String initPath; //initial path
	private String end; //file extension
	private List<String> results;
	private Phaser phaser;
	
	public FileSearchPhaser(String init, String ext, Phaser phaser) {
		this.initPath = init;
		this.end = ext;
		this.phaser = phaser;
		results = new ArrayList<String>();
	}
	
	private void directoryProcess(File file) {
		File[] files = file.listFiles(); //files under current directory
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					directoryProcess(files[i]);
				} else {
					fileProcess(files[i]);
				}
			}
		}
	}
	
	//first, get files with extension "log"
	private void fileProcess(File file) {
		//compare file extensions
		if (file.getName().endsWith(end)) {
			results.add(file.getAbsolutePath());
		}
	}
	
	//filter those log files and find those satisfying the requirement
	private void filterResults() {
		List<String> newResults = new ArrayList<String>();
		//getTime return number of milliseconds since January 1, 1970, 00:00:00 GMT 
		long actualDate = (new Date()).getTime();
		
		for (int i = 0; i < results.size(); i++) {
			//create a File object in order to get necessary information
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			
			//is the file modified more than 24 hours ago
			if ((actualDate - fileDate) < 
					TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}
		//update the result after filtering
		results  = newResults;
	}
	
	//check whether any result is produced
	private boolean checkResults() {
		if (results.isEmpty()) {
			System.out.printf("%s: Phase %d: 0 results.\n", 
					Thread.currentThread().getName(), phaser.getPhase());
			System.out.printf("%s: Phase %d: End.\n", 
					Thread.currentThread().getName(), phaser.getPhase());
			

			//finish the work of current phase.
            //leave the phased task. thread will exit.
			//after deregister, internal counter of phaser will be reduced by 1
			phaser.arriveAndDeregister();
			return false;
		} else {
			System.out.printf("%s: Phase %d: %d results.\n", 
					Thread.currentThread().getName(), phaser.getPhase(), results.size());
			
			//finish the work of current phase
			//wait to move to next phase
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	private void showInfo() {
		System.out.printf("%s: Phase %d: print results.\n", 
				Thread.currentThread().getName(), phaser.getPhase());
		for (int i = 0; i < results.size(); i++) {
			File file = new File(results.get(i));
			System.out.printf("%s: %s\n", 
					Thread.currentThread().getName(), file.getAbsolutePath());
		}
		
		//finish the last phase and wait to move forward
		phaser.arriveAndAwaitAdvance();
	}
	
	@Override
	public void run() {
		//Phase 0
		System.out.printf("%s: Phase %d: starting.\n", 
				Thread.currentThread().getName(), phaser.getPhase());
		
		//wait for all threads to be created and started
		phaser.arriveAndAwaitAdvance();
		System.out.printf("%s: Starting.\n", 
				Thread.currentThread().getName());
		
		File file = new File(initPath);
		if (file.isDirectory()) {
			directoryProcess(file);
		}
		
		//Phase 1
		//need all threads to finish this checking before continue
		//phaser.arriveAndAwaitAdvance();
		if (!checkResults()) {
			return;
		}
		
		filterResults();
		
		//Phase 2
		//need all threads to finish this checking before continue
		//phaser.arriveAndAwaitAdvance();
		if (!checkResults()) {
			return;
		}
		
		//Phase 3
		//need all threads to print results before continue
		//phaser.arriveAndAwaitAdvance();
		showInfo();
		
		//all works are done. you can go home and find mommy now
		phaser.arriveAndDeregister();
		System.out.printf("%s: Work completed.\n", 
				Thread.currentThread().getName());
	}
}
