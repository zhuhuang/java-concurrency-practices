/**
 *  File: Server.java
 *  Package: 
 *  Project: thread-ThreadPoolExecutor_Server
 *  Created on: Mar 13, 2013
 * 
 *  Description: create a thread executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

/*
 * Executors:
Factory and utility methods for Executor, ExecutorService, ScheduledExecutorService, ThreadFactory, and Callable classes defined in this package. This class supports the following kinds of methods:
Methods that create and return an ExecutorService set up with commonly useful configuration settings.
Methods that create and return a ScheduledExecutorService set up with commonly useful configuration settings.
Methods that create and return a "wrapped" ExecutorService, that disables reconfiguration by making implementation-specific methods inaccessible.
Methods that create and return a ThreadFactory that sets newly created threads to a known state.
Methods that create and return a Callable out of other closure-like forms, so they can be used in execution methods requiring Callable.
 */

//Interface: Executor, ExecutorService, ScheduledExecutorService
//Class: ThreadPoolExecutor, Executors, ScheduledThreadedPoolExecutor


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	private ThreadPoolExecutor executor;
	
	public Server() {
		//create a thread pool
		//executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		//create a thread pool with fixed size threads
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
	}
	
	public void executeTask(Task task) {
		System.out.printf("Server: A new task has arrived\n");
		
		//execute task
		executor.execute(task);
		
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
		
		System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
		
		System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
		
		System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
		
	}
	
	public void endServer() {
		//shut down
		executor.shutdown();
	}
}
