import java.util.concurrent.TimeUnit;

/**
 *  File: TestSafeTask.java
 *  Package: 
 *  Project: thread-SafeTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Using Thread Local Variables
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class TestSafeTask {

	public static void main(String[] args) {
		SafeTask task = new SafeTask();
		for (int i = 0; i < 10; i++) {
			//Using the same UnsafeTask object to create Thread objects
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
