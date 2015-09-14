import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-ForkJoin_ThrowException_UncheckedException
 *  Created on: May 14, 2013
 * 
 *  Description: throwing exceptions in the tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class Task extends RecursiveTask<Integer> {
	private int array[];
	private int start, end;
	
	public Task(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	//compute doesn't throw any exception by default
	//checked exception such as InterruptedException has to be handled inside compute()
	//unchecked exception such as RuntimeException can be thrown
	@Override
	protected Integer compute() {
		System.out.printf("Task: Start from %d to %d\n", start, end);
		if (end - start < 10) {
			if ((start < 3) && (end > 3)) {
				throw new RuntimeException("This task throws an Exception: Task from " + start + " to " + end);
			    // or 
				//Exception e=new Exception("This task throws an Exception: " + "Task from "+start + " to " + end);
				//completeExceptionally(e);
			}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			int mid = (start + end) / 2;
			Task t1 = new Task(array, start, mid);
			Task t2 = new Task(array, mid, end);
			
			//may throw RuntimeException because of previous settings
			invokeAll(t1, t2);
		}
		
		System.out.printf("Task: End from %d to %d\n", start, end);
		return 0;
	}
}
