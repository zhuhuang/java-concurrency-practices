/**
 *  File: PrintQueue.java
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

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Semaphore semaphore;
	private boolean freePrinters[];
	
	//protect access to freePrinters array
	private Lock lockPrinters;
	
	public PrintQueue() {
		//semaphore, non-fair
		semaphore = new Semaphore(3, false);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			
			//return value of getPrinter are not checked
			//semaphore kind of guarantee that a valid printer will be returned
			int assignedPrinter = getPrinter();
			
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", 
					Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			
			freePrinters[assignedPrinter] = true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private int getPrinter() {
		int ret = -1;
		
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
