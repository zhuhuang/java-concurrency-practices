/**
 *  File: UserValidator.java
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

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String name;
	
	public UserValidator(String name) {
		this.name = name;
	}
	
	public boolean validate(String name, String password) {
		Random random = new Random();
		try {
			long duration = (long)(Math.random() * 10);
			System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			return false;
		}
		return random.nextBoolean();
	}
	
	public String getName() {
		return name;
	}
}
