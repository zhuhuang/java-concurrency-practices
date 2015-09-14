/**
 *  File: UnsafeTask.java
 *  Package: 
 *  Project: thread-UnsafeTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Not Using Thread Local Variables
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	//not thread local variable
	//can be changed by other threads using the same UnsafeTask object
	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread: %s : %s\n",
				Thread.currentThread().getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished: %s : %s\n", 
				Thread.currentThread().getId(), startDate);
	}
}
