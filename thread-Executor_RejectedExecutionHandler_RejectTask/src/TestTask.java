import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  File: TestTask.java
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

public class TestTask {

	public static void main(String[] args) {
		RejectedTaskController controller = new RejectedTaskController();
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		executor.setRejectedExecutionHandler(controller);
		
		System.out.printf("Main: Starting\n");
		for (int i = 0; i < 3; i++) {
			Task task = new Task("Task " + i);
			executor.submit(task);
		}
		
		System.out.printf("Main: Shutting down the executor\n");
		executor.shutdown();
		
		System.out.printf("Main: sending another task\n");
		Task task = new Task("RejectedTask");
		executor.submit(task);
		
		System.out.printf("Main: End\n");
	}

}
