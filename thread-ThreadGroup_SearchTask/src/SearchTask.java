/**
 *  File: SearchTask.java
 *  Package: 
 *  Project: thread-SearchTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Group threads into a group
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Random;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
	private static final String Date = null;
	private Result result;

	public SearchTask(Result result) {
		this.result = result;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start\n", name);
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			System.out.printf("Thread %s: Interrupted\n", name);
			return;
		}
		System.out.printf("Thread %s: End\n", name);
	}
	
	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int)(random.nextDouble() * 100);
		System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}
}
