import java.util.concurrent.TimeUnit;

/*
 * File: MyTask.java
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
public class MyTask implements Runnable {
	private long milliseconds;
	
	public MyTask(long milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public void run() {
		System.out.printf("%s: Begin\n", Thread.currentThread().getName());
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: End\n", Thread.currentThread().getName());
	}
}
