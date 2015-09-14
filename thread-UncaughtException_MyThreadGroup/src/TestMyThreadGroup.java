/**
 *  File: TestMyThreadGroup.java
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

public class TestMyThreadGroup {

	public static void main(String[] args) {
		MyThreadGroup mtg = new MyThreadGroup("MMMyThreadGroup");
		Task task = new Task();
		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(mtg, task);
			thread.start();
		}
	}

}
