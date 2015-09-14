/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-ThreadPoolExecutor_Server
 *  Created on: Mar 13, 2013
 * 
 *  Description: create a thread executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private Date initDate;
	private String name;
	
	public Task(String name) {
		initDate = new Date();
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());
		
		try {
			Long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
	}
}
