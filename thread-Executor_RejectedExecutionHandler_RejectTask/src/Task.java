import java.util.concurrent.TimeUnit;

/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-Executor_RejectedExecutionHandler_RejectTask
 *  Created on: May 13, 2013
 * 
 *  Description: controlling rejected tasks in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class Task implements Runnable {
	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("Task %s: Executing during %d seconds\n", name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return name;
	}
}
