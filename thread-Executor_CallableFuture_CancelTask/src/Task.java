/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-Executor_CallableFuture_CancelTask
 *  Created on: May 13, 2013
 * 
 *  Description: canceling a task in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<String> {

	public String call() throws Exception {
		while (true) {
			System.out.printf("Task: Test\n");
			Thread.sleep(100);
		}
	}
}

