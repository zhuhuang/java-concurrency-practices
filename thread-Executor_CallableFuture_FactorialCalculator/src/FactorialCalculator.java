/**
 *  File: FactorialCalculator.java
 *  Package: 
 *  Project: thread-CallableFuture_FactorialCalculator
 *  Created on: Mar 13, 2013
 * 
 *  Description: execute tasks in an executor that returns a result
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

//Callable Interface
public class FactorialCalculator implements Callable<Integer> {
	private Integer number;
	
	public FactorialCalculator(Integer number) {
		this.number = number;
	}
	
	//call returns a value. unlike run of Runnable interface
	@Override
	public Integer call() throws Exception {
		int result = 1;
		if((number == 0) || (number == 1)) {
			result = 1;
		} else {
			for (int i = 2; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(20);
			}
		}
		System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
		return result; //return a value
	}
}
