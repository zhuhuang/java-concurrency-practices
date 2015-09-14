/**
 *  File: TestFactorialCalculator.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TestFactorialCalculator {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		//Callable and Future
		List<Future<Integer>> resultList = new ArrayList<>();
		
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
			Integer number = random.nextInt(10);
			
			//create task
			FactorialCalculator calculator = new FactorialCalculator(number);
			
			//send task to executor
			//use submit here, not execute
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}
		
		do {
			System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
			
			for(int i = 0; i < resultList.size(); i++) {
				//query status of threads
				Future<Integer> result = resultList.get(i);
				System.out.printf("Main: Task %d Done: %s\n", i, result.isDone());
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (executor.getCompletedTaskCount() < resultList.size());
		
		System.out.printf("Main: Results\n");
		for (int i = 0; i < resultList.size(); i++) {
			Future<Integer> result = resultList.get(i);
			Integer number  = null;
			try {
				//get the result returned by call() method
				number = result.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			System.out.printf("Main: Task %d: %d\n", i, number);
		}
		executor.shutdown();
	}

}
