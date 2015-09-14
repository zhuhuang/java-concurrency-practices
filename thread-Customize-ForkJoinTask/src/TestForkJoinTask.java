import java.util.concurrent.ForkJoinPool;

/*
 * File: TestForkJoinTask.java
 * Package: 
 * Project: thread-Customize-ForkJoinTask
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
public class TestForkJoinTask {

	public static void main(String[] args) {
		int[] array = new int[10000];
		for (int i = 0; i < array.length; i++) {
			array[i] = 1;
		}
		
		ForkJoinPool pool = new ForkJoinPool();
		
		Task task = new Task("Task", array, 0, array.length);
		
		pool.invoke(task);
		pool.shutdown();
		
		System.out.printf("Main: End of the program.\n");
	}

}
