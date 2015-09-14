import java.util.concurrent.TimeUnit;

/*
 * File: MyTask.java
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
public class MyTask implements Runnable {
	private MyLock lock;
	private String name;
	
	public MyTask(String name, MyLock lock) {
		this.lock = lock;
		this.name = name;
	}
	
	@Override
	public void run() {
		lock.lock();
		System.out.printf("MyTask: %s: Got the lock\n", name);
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.printf("MyTask: %s: Free the lock\n", name);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock(); //important: put unlock in finally block
		}
	}
}
