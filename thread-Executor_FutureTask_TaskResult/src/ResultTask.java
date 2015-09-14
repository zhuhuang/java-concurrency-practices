import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *  File: ResultTask.java
 *  Package: 
 *  Project: thread-Executor_FutureTask_TaskResult
 *  Created on: May 13, 2013
 * 
 *  Description: controlling a task finishing in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class ResultTask extends FutureTask<String> {
	private String name;
	
	public ResultTask(Callable<String> callable) {
		super(callable);
		this.name = ((ExecutableTask)callable).getName();
	}
	
	//The done() method is called by the FutureTask class when the task that is being controlled finishes its execution.

	@Override
	protected void done() {
		if (isCancelled()) {
			System.out.printf("%s: Has been canceled\n", name);
		} else {
			System.out.printf("%s: Has finished\n", name);
		}
	}
}
