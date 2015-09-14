/**
 *  File: TestPrintJobSemaphore.java
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

public class TestPrintJobSemaphore {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Job(printQueue), "Thread_" + i);
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}
	}

}
