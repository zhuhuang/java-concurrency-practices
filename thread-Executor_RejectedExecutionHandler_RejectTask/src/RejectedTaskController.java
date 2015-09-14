import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *  File: RejectedTaskController.java
 *  Package: 
 *  Project: thread-Executor_RejectedExecutionHandler_RejectTask
 *  Created on: May 13, 2013
 * 
 *  Description: controlling rejected tasks in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class RejectedTaskController implements RejectedExecutionHandler {
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.printf("RejectedTaskController: The task %s has been rejected\n", r.toString());
		System.out.printf("RejectedTaskController: %s\n", executor.toString());
		System.out.printf("RejectedTaskController: Terminating: %s\n", executor.isTerminating());
		System.out.printf("RejectedTaskController: Terminated: %s\n", executor.isTerminated());
	}
}
