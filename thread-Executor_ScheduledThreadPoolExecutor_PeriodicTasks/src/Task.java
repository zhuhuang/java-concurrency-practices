/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-Executor_ScheduledThreadPoolExecutor_PeriodicTasks
 *  Created on: May 13, 2013
 * 
 *  Description: running a task in an executor periodically
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

//public class Task implements Callable<String> {
public class Task implements Runnable {
	private String name;
	
	public Task(String name) {
		this.name = name;
	}
	
	
	//public String call() throws Exception {
	public void run() {
		System.out.printf("%s: Starts at: %s\n", name, new Date());
		
		try {
			//TimeUnit.SECONDS.sleep((long) (Math.random() * 10)); 
			TimeUnit.SECONDS.sleep(1); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s: Ends at: %s\n", name, new Date());
		//return "Hello, World!";
	}
}
