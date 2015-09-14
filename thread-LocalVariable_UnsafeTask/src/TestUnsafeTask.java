/**
 *  File: TestUnsafeTask.java
 *  Package: 
 *  Project: thread-UnsafeTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Not Using Thread Local Variables
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.concurrent.TimeUnit;

public class TestUnsafeTask {

	public static void main(String[] args) {
		UnsafeTask task = new UnsafeTask();
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
