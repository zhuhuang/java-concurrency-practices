/**
 *  File: Job.java
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

public class Job implements Runnable {
	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Going to print a job\n", 
				Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", 
				Thread.currentThread().getName());
	}

}
