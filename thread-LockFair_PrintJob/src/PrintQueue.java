import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  File: PrintQueue.java
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

public class PrintQueue {
	//enable lock fairness
	private final Lock queueLock = new ReentrantLock(true);
	
	public void printJob(Object document) {
		queueLock.lock();
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + 
					": PrintQueue: Printing a Job during " + (duration/1000) +
					" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
		
		//have a break and let other threads "compete"
		queueLock.lock(); 
		
		try {
			Long duration = (long) (Math.random() * 10000);
			System.out.println(Thread.currentThread().getName() + 
					": PrintQueue: Printing a Job during " + (duration/1000) +
					" seconds");
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			queueLock.unlock();
		}
	}
}
