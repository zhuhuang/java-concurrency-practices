import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * File: TestExecutor.java
 * Package: 
 * Project: thread-Test-Executor
 * Created on: Aug 17, 2013
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
public class TestExecutor {
	public static void showLog(ThreadPoolExecutor executor) {
		System.out.printf("*********************************\n");
		System.out.printf("Main: Executor: Log\n");
		System.out.printf("Main: Executor: Core Pool Size: %d\n", executor.getCorePoolSize());
		System.out.printf("Main: Executor: Pool Size: %d\n", executor.getPoolSize());
		System.out.printf("Main: Executor: Active Count: %d\n", executor.getActiveCount());
		System.out.printf("Main: Executor: Task Count: %d\n", executor.getTaskCount());
		System.out.printf("Main: Executor: Completed Task Count: %d\n", executor.getCompletedTaskCount());
		System.out.printf("Main: Executor: Shutdown: %s\n", executor.isShutdown());
		System.out.printf("Main: Executor: Terminating: %s\n", executor.isTerminating());
		System.out.printf("Main: Executor: Terminated: %s\n", executor.isTerminated());
		System.out.printf("*********************************\n");
	}

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			MyTask task = new MyTask(random.nextInt(10000));
			executor.submit(task);
		}
		
		for (int i = 0; i < 5; i++) {
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		
		for (int i = 0; i < 5; i++) {
			showLog(executor);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: End of the program\n");
	}

}
