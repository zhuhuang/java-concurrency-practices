/**
 *  File: TestPrintJobMultiSemaphore.java
 *  Package: 
 *  Project: thread-PrintJobMultiSemaphore
 *  Created on: Feb 28, 2013
 * 
 *  Description: control concurrent access to multiple copies of a resource
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestPrintJobMultiSemaphore {

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
