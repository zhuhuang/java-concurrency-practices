import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 *  File: SearchNumberTask.java
 *  Package: 
 *  Project: thread-ForkJoin_CancelTask_TaskManager
 *  Created on: May 14, 2013
 * 
 *  Description: canceling a task
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class SearchNumberTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private int[] numbers;
	private int start, end;
	private int number;
	private TaskManager manager;
	private static final int NOT_FOUND = 1;
	
	public SearchNumberTask(int[] numbers, int start, int end, int number, TaskManager manager) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
		this.number = number;
		this.manager = manager;
	}
	
	@Override
	protected Integer compute() {
		System.out.printf("Task: %d : %d\n", start, end);
		int ret;
		if (end - start > 10) {
			ret = launchTasks();
		} else {
			ret = lookForNumber();
		}
		return new Integer(ret);
	}
	
	private int lookForNumber() {
		for (int i = start; i < end; i++) {
			if (numbers[i] == number) {
				System.out.printf("Task: Number %d found in position %d\n", number, i);
				manager.cancelTasks(this);
				return i;
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return NOT_FOUND;
	}
	
	private int launchTasks() {
		int mid = (start + end) / 2;
		SearchNumberTask t1 = new SearchNumberTask(numbers, start, mid, number, manager);
		SearchNumberTask t2 = new SearchNumberTask(numbers, mid, end, number, manager);
		manager.addTask(t1);
		manager.addTask(t2);
		
		//asynchronous
		t1.fork();
		t2.fork();
		
		int returnValue;
		returnValue = t1.join(); //wait for completion
		if (returnValue != -1) {
			return returnValue;
		}
		
		returnValue = t2.join(); //wait for completion
	    return returnValue;
	}
	
	public void writeCancelMessage() {
		System.out.printf("Task: Canceled task from %d to %d\n", start, end);
	}
}
