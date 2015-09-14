import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *  File: ExecutableTask.java
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

public class ExecutableTask implements Callable<String> {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public ExecutableTask(String name) {
		this.name = name;
	}
	
	public String call() throws Exception {
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: Waiting %d seconds for results\n", name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Hello, World. I'm " + name;
	}
}
