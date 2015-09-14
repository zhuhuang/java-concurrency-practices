/*
 * File: TestMyScheduledThreadPoolExecutor.java
 * Package: 
 * Project: thread-Customize-ScheduledThreadPoolExecutor
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

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 */
public class TestMyScheduledThreadPoolExecutor {

	public static void main(String[] args) {
		MyScheduledThreadPoolExecutor executor = new MyScheduledThreadPoolExecutor(2);
		
		Task task = new Task();
		System.out.printf("Main: %s\n", new Date());
		executor.schedule(task, 1, TimeUnit.SECONDS); //send a delayed task to the executor

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		task = new Task();
		System.out.printf("Main: %s\n", new Date());
		executor.scheduleAtFixedRate(task, 1, 3, TimeUnit.SECONDS); //send a periodic task to the executor
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program.\n");
	}

}
