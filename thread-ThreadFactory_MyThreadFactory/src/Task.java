/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-MyThreadFactory
 *  Created on: Feb 25, 2013
 * 
 *  Description: Creating threads through a factory
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
