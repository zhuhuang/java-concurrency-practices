/**
 *  File: TestFileSearchPhaser.java
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

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class TestFileSearchPhaser {

	public static void main(String[] args) {
		//there will be three threads joining this phased task
		Phaser phaser = new Phaser(3);
		
		FileSearchPhaser searchUsr = new FileSearchPhaser("/usr", 
				"log", phaser);
		FileSearchPhaser searchHome = new FileSearchPhaser("/home/zhuhuang", 
				"log", phaser);
		FileSearchPhaser searchWorkspace = new FileSearchPhaser("/home/zhuhuang/Workspace", 
				"log", phaser);
		
		long startTime = System.currentTimeMillis();
		
		Thread threadUsr = new Thread(searchUsr, "searchRoot");
		threadUsr.start();
		Thread threadHome = new Thread(searchHome, "searchHome");
		threadHome.start();	
		Thread threadWorkspace = new Thread(searchWorkspace, "searchWorkspace");
		threadWorkspace.start();
		
		try {
			threadUsr.join();
			threadHome.join();
			threadWorkspace.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Terminated: " + phaser.isTerminated());
		
		long endTime = System.currentTimeMillis();
		
		long difference = endTime - startTime;
		long duration = TimeUnit.SECONDS.convert(difference, TimeUnit.MILLISECONDS);
		System.out.println("Program Execution Time: " + duration + " seconds!");
		//get 57 seconds using the desktop at home
		//get 1 second using ThinkCentre M92p SFF
	}

}
