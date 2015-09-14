import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestTask.java
 *  Package: 
 *  Project: thread-ForkJoin_ThrowException_UncheckedException
 *  Created on: May 14, 2013
 * 
 *  Description: throwing exceptions in the tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestTask {

	public static void main(String[] args) {
		int[] array = new int[100];
		Task task = new Task(array, 0, 100);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (task.isCompletedAbnormally()) {
			System.out.printf("Main: An exception has occured\n");
			System.out.printf("Main: %s\n", task.getException());
		}
		
		// RuntimeException thrown here
		System.out.printf("Main: Result: %d\n", task.join());
		
	}

}
