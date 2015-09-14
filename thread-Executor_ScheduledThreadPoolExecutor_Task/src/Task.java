/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-Executor_ScheduledThreadPoolExecutor_Task
 *  Created on: May 13, 2013
 * 
 *  Description: running a task in an executor after a delay
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	private String name;

	public Task(String name) {
		this.name = name;
	}
	
	public String call() throws Exception {
		System.out.printf("%s: Starting at: %s\n", name, new Date());
		return "Hello, World!";
	}
}
