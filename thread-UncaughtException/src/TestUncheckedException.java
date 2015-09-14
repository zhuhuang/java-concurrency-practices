/**
 *  File: TestUncheckedException.java
 *  Package: 
 *  Project: thread-UncheckedException
 *  Created on: Feb 24, 2013
 * 
 *  Description: Process Uncontrolled Exceptions in a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class TestUncheckedException {

	public static void main(String[] args) {
		
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();

	}

}
