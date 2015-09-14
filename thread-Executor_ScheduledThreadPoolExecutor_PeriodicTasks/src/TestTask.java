import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestTask.java
 *  Package: 
 *  Project: thread-Executor_ScheduledThreadPoolExecutor_PeriodicTasks
 *  Created on: May 13, 2013
 * 
 *  Description:  running a task in an executor periodically
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestTask {

	public static void main(String[] args) {
			// ScheduledThreadPoolExecutor, Executors
			ScheduledExecutorService executor = (ScheduledExecutorService) Executors.newScheduledThreadPool(1);
			
			System.out.printf("Main: Starts at: %s\n", new Date());
			Task task = new Task("Task");
			//wildcard type: ?
			ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
			
			for (int i = 0; i < 10; i++) {
				System.out.printf("Main: Delays: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			// shutdown does not wait for previously submitted tasks to complete execution.
			// shutdownNow() does not wait for actively executing tasks to terminate.
			// awaitTermination does.
			// The default behavior is that pending tasks will be executed despite the finalization of the executor.
			// Initiates an orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
			executor.shutdown();
			
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.printf("Main: Ends at: %s\n", new Date());
	}

}
