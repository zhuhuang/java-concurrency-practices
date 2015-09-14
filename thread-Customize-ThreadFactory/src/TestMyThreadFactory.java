import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * File: TestMyThreadFactory.java
 * Package: 
 * Project: thread-Customize-ThreadFactory
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
public class TestMyThreadFactory {

	public static void main(String[] args) {
		MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
		MyTask task = new MyTask();
		Thread thread = myFactory.newThread(task);
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Thread information.\n");
		System.out.printf("%s\n", thread); //call MyThread.toString()
		System.out.printf("Main: End of part one.\n");
		
		
		//use the customized ThreadFactory in Executors class.
		ExecutorService executor = Executors.newCachedThreadPool(myFactory);
		executor.submit(task);
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: End of part two.\n");
	}

}
