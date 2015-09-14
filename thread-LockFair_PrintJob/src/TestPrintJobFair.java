/**
 *  File: TestFairPrintJob.java
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

public class TestPrintJobFair {

	public static void main(String[] args) {
			PrintQueue printQueue = new PrintQueue();
			Thread thread[] = new Thread[10];
			for (int i=0; i<10; i++) {
				thread[i] = new Thread(new Job(printQueue), "Thread_" + i);
			}
			
			for (int i=0; i<10; i++) {
				thread[i].start();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}

}
