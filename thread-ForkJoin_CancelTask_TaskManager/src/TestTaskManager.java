import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestTaskManager.java
 *  Package: 
 *  Project: thread-ForkJoin_CancelTask_TaskManager
 *  Created on: May 14, 2013
 * 
 *  Description: canceling a task
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestTaskManager {

	public static void main(String[] args) {
		ArrayGenerator generator = new ArrayGenerator();
		int[] array = generator.generateArray(1000);
		TaskManager manager = new TaskManager();
		ForkJoinPool pool = new ForkJoinPool();
		SearchNumberTask task = new SearchNumberTask(array, 0, 1000, 5, manager);
		
		pool.execute(task);
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: The program has finished\n");
	}

}
