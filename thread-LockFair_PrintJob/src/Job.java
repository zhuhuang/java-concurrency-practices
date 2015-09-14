/**
 *  File: Job.java
 *  Package: 
 *  Project: thread-FairPrintJob
 *  Created on: Feb 27, 2013
 * 
 *  Description: modify lock fairness
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class Job implements Runnable {
	private PrintQueue queue;

	public Job(PrintQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Going to print a document\n", 
				Thread.currentThread().getName());
		queue.printJob(new Object());
		System.out.printf("%s: The document has been printed\n", 
				Thread.currentThread().getName());
	}
}
