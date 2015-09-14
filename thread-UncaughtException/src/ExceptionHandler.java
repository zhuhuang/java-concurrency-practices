/**
 *  File: ExceptionHandler.java
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

import java.lang.Thread.UncaughtExceptionHandler;

//Implement a class to treat the unchecked exceptions.
//Wirte information about Exception and Thread that threw the exception.
public class ExceptionHandler implements UncaughtExceptionHandler {
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception has been captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s: %s\n", 
				e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status: %s\n", t.getState());
	}
}
