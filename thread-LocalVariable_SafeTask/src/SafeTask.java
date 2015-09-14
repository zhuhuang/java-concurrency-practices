/**
 *  File: SafeTask.java
 *  Package: 
 *  Project: thread-SafeTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Using Thread Local Variables
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	//thread local variable
	//can't be changed by other threads using the same UnsafeTask object
	private static ThreadLocal<Date> startDate = new
			ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %s\n",
				Thread.currentThread().getId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", 
				Thread.currentThread().getId(), startDate.get());
	}
}
