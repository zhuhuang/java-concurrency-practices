/**
 *  File: TestFileClock.java
 *  Package: 
 *  Project: thread-FileClock
 *  Created on: Feb 24, 2013
 * 
 *  Description: Sleep and Resume a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.concurrent.TimeUnit;

public class TestFileClock {

	public static void main(String[] args) {
		FileClock fc = new FileClock();
		Thread thread = new Thread(fc);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
	}

}
