/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-UncaughtExceptionThreadGroup
 *  Created on: Feb 25, 2013
 * 
 *  Description: Processing uncontrolled exceptions in a group of threads
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Random;

public class Task implements Runnable {
	
	//generate an ArithmethicException when 1000 divided by 0
	@Override
	public void run() {
		double result;
		Random random = new Random(Thread.currentThread().getId());
		while(true) {
			result = 1000 / ((int)(random.nextDouble() * 1000));
			System.out.printf("%s : %f\n", 
					Thread.currentThread().getId(), result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", 
						Thread.currentThread().getId());
				return;
			}
		}
	}
}
