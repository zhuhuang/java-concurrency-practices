import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * File: TestLogger.java
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
public class TestLogger {

	public static void main(String[] args) {
		Logger logger = MyLogger.getLogger("Core");
		logger.entering("Core", "main()", args);
		Thread[] threads = new Thread[5];
		
		for (int i = 0; i < threads.length; i++) {
			logger.log(Level.INFO, "Launching thread: " + i);
			MyTask task = new MyTask();
			threads[i] = new Thread(task);
			logger.log(Level.INFO, "Thread created: " + threads[i].getName());
			threads[i].start();
		}
		logger.log(Level.INFO, "Five threads created. Waiting for their finalization.");
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
				logger.log(Level.INFO, "Thread has finished its execution: " + threads[i].getName());
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Exception", e);
			}
		}
		
		logger.exiting("Core", "main()");
	}

}
