import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestWordSearch.java
 *  Package: 
 *  Project: thread-ForkJoin_RecursiveTask_WordSearch
 *  Created on: May 14, 2013
 * 
 *  Description: joining the results of tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestWordSearch {
	public static void main(String[] args) {
		DocumentGenerator generator = new DocumentGenerator();
		String[][] document = generator.generateDocument(100, 500, "the");
		
		DocumentTask task = new DocumentTask(document, 0, 100, "the");
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		
		do {
			System.out.printf("\n**************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.printf("Main: The word appears %d in the document", task.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
