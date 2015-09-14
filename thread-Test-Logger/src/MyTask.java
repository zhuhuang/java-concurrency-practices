import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/*
 * File: MyTask.java
 * Package: 
 * Project: thread-Test-Logger
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
	@Override
	public void run() {
		Logger logger = MyLogger.getLogger(this.getClass().getName());
		logger.entering(Thread.currentThread().getName(), "run()");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.exiting(Thread.currentThread().getName(), "run()", Thread.currentThread());
	}
}
