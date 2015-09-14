import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestTask.java
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

public class TestTask {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Task task = new Task();
		System.out.printf("Main: Executing the Task\n");
		Future<String> result = executor.submit(task);
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Cancelling the Task\n");
		
		// cancel a task
		result.cancel(true);
		
		System.out.printf("Main: Cancelled: %s\n", result.isCancelled());
		System.out.printf("Main: Done: %s\n", result.isDone());
		
		executor.shutdown();
		System.out.printf("Main: The executor has finished\n");
	}

}
