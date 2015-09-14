import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/*
 * File: TestForkJoinWorkerThread.java
 * Package: 
 * Project: thread-Customize-ForkJoinWorkerThread
 * Created on: Aug 11, 2013
 *
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 *
 * Description: TODO
 * Compilation: TODO
 *
 */

/**
 * TODO
 */
public class TestForkJoinWorkerThread {

	public static void main(String[] args) {
		MyWorkerThreadFactory factory = new MyWorkerThreadFactory();
		ForkJoinPool pool = new ForkJoinPool(4, factory, null, false);
		
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		
		MyRecursiveTask task = new MyRecursiveTask(array, 0, array.length);
		pool.execute(task); //arrange asynchonous execution
		//pool.invoke(task); //await and obtain result. no join needed.
		task.join(); //work with execute
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Integer result = null;
		try {
			result = task.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Result: %d\n", result);
		System.out.printf("Main: End of the program.\n");
	}

}
