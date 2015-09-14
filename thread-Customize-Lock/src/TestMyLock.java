import java.util.concurrent.TimeUnit;

/*
 * File: TestMyLock.java
 * Package: 
 * Project: thread-Customize-Lock
 * Created on: Aug 15, 2013
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
public class TestMyLock {

	public static void main(String[] args) {
		MyLock lock = new MyLock();
		
		for (int i=0; i < 10; i++) {
			MyTask task = new MyTask("Task-" + i, lock);
			Thread thread = new Thread(task);
			thread.start();
		}
		boolean value;
		do {
			try {
				value = lock.tryLock(1, TimeUnit.SECONDS);
				if (!value) {
					System.out.printf("Main: Trying to get the Lock\n");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				value = false;
			}
		} while (!value);
		
		System.out.printf("Main: Got the lock\n");
		lock.unlock();
		System.out.printf("Main: End of the program\n");
	}
}
