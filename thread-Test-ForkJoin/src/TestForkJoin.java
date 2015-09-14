import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * File: TestForkJoin.java
 * Package: 
 * Project: thread-Test-ForkJoin
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
public class TestForkJoin {

	public static void showLog(ForkJoinPool pool) {
		System.out.printf("*********************************\n");
		System.out.printf("Main: Fork/Join Pool: Log\n");
		System.out.printf("Main: Fork/Join Pool: Parallelism: %d\n", pool.getParallelism());
		System.out.printf("Main: Fork/Join Pool: Pool Size: %d\n", pool.getPoolSize());
		System.out.printf("Main: Fork/Join Pool: Active Thread Count: %d\n", pool.getActiveThreadCount());
		System.out.printf("Main: Fork/Join Pool: Running Thread Count: %d\n", pool.getRunningThreadCount());
		System.out.printf("Main: Fork/Join Pool: Queued Submissions: %s\n", pool.hasQueuedSubmissions());
		System.out.printf("Main: Fork/Join Pool: Queued Submission: %d\n", pool.getQueuedSubmissionCount());
		System.out.printf("Main: Fork/Join Pool: Queued Tasks: %d\n", pool.getQueuedTaskCount());
		System.out.printf("Main: Fork/Join Pool: Steal Count: %d\n", pool.getStealCount());
		System.out.printf("Main: Fork/Join Pool: Terminated: %s\n", pool.isTerminated());
		System.out.printf("*********************************\n");
	}
	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		int[] array = new int[10000];
		MyTask task = new MyTask(array, 0, array.length);
		pool.execute(task); //Arrange async execution
		//pool.invoke(task); //Await and obtain result
		//pool.submit(task); //Arrange exec and obtain Future
		
		while (!task.isDone()) {
			showLog(pool);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		pool.shutdown();
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		showLog(pool);
		System.out.printf("Main: End of the program\n");
	}

}
