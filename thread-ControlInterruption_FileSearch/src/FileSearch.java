/**
 *  File: FileSearch.java
 *  Package: 
 *  Project: thread-FileSearch
 *  Created on: Feb 23, 2013
 * 
 *  Description: Control the Interruption of a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.io.File;

public class FileSearch implements Runnable {
	private String initPath;
	private String fileName;
	
	public FileSearch (String init, String file) {
		this.initPath = init;
		this.fileName = file;
	}
	
	@Override
	public void run() {
		File file = new File(initPath);
		if (file.isDirectory()) {
			try{
				directoryProcess(file);
			} catch (InterruptedException e) {
				System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
			}
		}
	}
	
	private void directoryProcess(File file) throws InterruptedException {
		System.out.println("Visiting Directory: " + file.getName());
		File list[] = file.listFiles();
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory()) {
					directoryProcess(list[i]);
				} else {
					fileProcess(list[i]);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
	
	private void fileProcess(File file) throws InterruptedException {
		System.out.println("        visiting File: " + file.getName());
		if (file.getName().equals(fileName)) {
			System.out.printf("\n%s : %s\n\n", Thread.currentThread().getName(), file.getAbsoluteFile());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}
}
