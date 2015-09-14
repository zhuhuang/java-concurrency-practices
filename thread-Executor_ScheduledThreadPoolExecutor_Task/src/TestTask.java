
/**
 *  File: TestTask.java
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestTask {

	public static void main(String[] args) {
		// ScheduledThreadPoolExecutor, Executors
		ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
		
		System.out.printf("Main: Starting at: %s\n", new Date());
		for (int i = 0; i < 5; i++) {
			Task task = new Task("Task " + i);
			
			//difference between submit() and schedule()
			//executor.submit(task);
			executor.schedule(task, i+1, TimeUnit.SECONDS);
		}
		
		// shutdown does not wait for previously submitted tasks to complete execution.
		// shutdownNow() does not wait for actively executing tasks to terminate.
		// awaitTermination does.
		//The default behavior is that pending tasks will be executed despite the finalization of the executor.
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Ends at: %s\n", new Date());
	}

}
