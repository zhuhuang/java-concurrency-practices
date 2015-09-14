/**
 *  File: TaskValidator.java
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

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
	private UserValidator validator;
	private String user;
	private String password;
	
	public TaskValidator(UserValidator validator, String user, String pass) {
		this.validator = validator;
		this.user = user;
		this.password = pass;
	}
	
	@Override
	public String call() throws Exception {
		if (!validator.validate(user, password)) {
			System.out.printf("%s: The user has NOT been found\n", validator.getName());
			throw new Exception("Error Validating User");
		}
		System.out.printf("%s: The user has been found\n", validator.getName());
		return validator.getName();
	}
}
