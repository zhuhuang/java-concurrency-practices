/**
 *  File: MyThreadGroup.java
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

public class MyThreadGroup extends ThreadGroup {
	public MyThreadGroup(String name) {
		super(name);
	}
	
	//Called by the Java Virtual Machine when a thread in this thread group stops 
	//because of an uncaught exception, and the thread does not have a specific 
	//Thread.UncaughtExceptionHandler installed.
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %s has thrown an Exception\n", t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Thread\n");
		interrupt();
	}

}
