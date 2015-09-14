import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/*
 * File: MyTask.java
 * Package: 
 * Project: thread-Test-Lock
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
 * Obtain and Release the Lock
 */
public class MyTask implements Runnable {
	private Lock lock;
	
	public MyTask(Lock lock) {
		this.lock = lock;
	}
	
	public void run() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			System.out.printf("%s: Get the Lock.\n", Thread.currentThread().getName());
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.printf("%s: Free the Lock.\n", Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
