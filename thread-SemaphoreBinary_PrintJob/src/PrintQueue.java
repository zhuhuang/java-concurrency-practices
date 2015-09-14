/**
 *  File: PrintQueue.java
 *  Package: 
 *  Project: thread-PrintJobSemaphore
 *  Created on: Feb 28, 2013
 * 
 *  Description: control concurrent access to a resource
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.concurrent.Semaphore;

public class PrintQueue {
	private final Semaphore semaphore;
	
	public PrintQueue() {
		//binary semaphore, non-fair
		semaphore = new Semaphore(1, false);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", 
					Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
