/**
 *  File: TestTaskValidator.java
 *  Package: 
 *  Project: thread-Executor_FirstResult_TaskValidator
 *  Created on: Mar 13, 2013
 * 
 *  Description: run multiple tasks and process the first result
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
import java.util.concurrent.ThreadPoolExecutor;
public class TestTaskValidator {

	public static void main(String[] args) {
		String username = "test";
		String password = "test";
		
		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("DataBase");
		
		TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
		TaskValidator dbTask = new TaskValidator(dbValidator, username, password);
		
		List<TaskValidator> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);
		
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		//or
		//ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		
		String result;
		
		try {
			//launch tasks in the list and returns the result of the first completed task
			result = executor.invokeAny(taskList);
			System.out.printf("Main: Result: %s\n", result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		System.out.printf("Main: End of the Execution\n");
	}
}
