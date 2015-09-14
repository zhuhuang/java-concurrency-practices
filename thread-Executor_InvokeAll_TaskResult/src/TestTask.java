/**
 *  File: TestTask.java
 *  Package: 
 *  Project: thread-Executor_InvokeAll_TaskResult
 *  Created on: May 13, 2013
 * 
 *  Description: TODO
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TestTask {

	public static void main(String[] args) {
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		List<Task> taskList = new ArrayList<Task> ();
		for (int i = 0; i < 3; i++) {
			Task task = new Task("Thread_" + i);
			taskList.add(task);
		}
		
		List<Future<Result>> resultList = null;
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		System.out.println("Main: Printing the results");
		for (int i = 0; i < resultList.size(); i++) {
			Future<Result> future = resultList.get(i);
			try {
				Result result = future.get();
				System.out.println(result.getName() + ": " + result.getValue());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

}
