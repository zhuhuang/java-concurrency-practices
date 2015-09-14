/**
 *  File: TestMyThreadFactory.java
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

public class TestMyThreadFactory {
	public static void main(String[] args) {
		MyThreadFactory mtf = new MyThreadFactory("MMMyThreadFactory");
		Task task = new Task();
		Thread thread;
		System.out.printf("Starting the Threads");
		for (int i = 0; i < 10; i++) {
			thread = mtf.newThread(task);
			thread.start();
		}
		System.out.printf("Factory stats: \n");
		System.out.printf("%s\n", mtf.getStats());
	}

}
