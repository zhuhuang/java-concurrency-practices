/**
 *  File: TestPrintJob.java
 *  Package: 
 *  Project: thread-PrintJob
 *  Created on: Feb 27, 2013
 * 
 *  Description: synchronize a block of code with a lock
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class TestPrintJob {
	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread thread[] = new Thread[10];
		for (int i=0; i<10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread_" + i);
		}
		
		for (int i=0; i<10; i++) {
			thread[i].start();
		}
	}

}
