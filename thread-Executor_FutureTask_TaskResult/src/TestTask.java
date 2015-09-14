import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestTask.java
 *  Package: 
 *  Project: thread-Executor_FutureTask_TaskResult
 *  Created on: May 13, 2013
 * 
 *  Description: controlling a task finishing in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestTask {

	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		ResultTask[] resultTask = new ResultTask[5];
		
		for (int i = 0; i < 5; i++) {
			ExecutableTask task = new ExecutableTask("Task " + i);
			resultTask[i] = new ResultTask(task);
			executor.submit(resultTask[i]);
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 5; i++) {
			try {
				if (!resultTask[i].isCancelled()) {
					System.out.printf("%s\n", resultTask[i].get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
	}

}
