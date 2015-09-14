import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/*
 * File: MyRecursiveTask.java
 * Package: 
 * Project: thread-Customize-ForkJoinWorkerThread
 * Created on: Aug 11, 2013
 *
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 *
 * Description: TODO
 * Compilation: TODO
 *
 */

/**
 * TODO
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {
	private int[] array;
	private int start, end;
	
	public MyRecursiveTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		Integer result = null;
		MyWorkerThread thread = (MyWorkerThread)Thread.currentThread();
		thread.addTask(); //counter the number of add tasks
		
		if (end - start <= 1000) {
			int sum = 0;
			for (int i = start; i < end; i++) {
				sum += array[i];
			}
			result = Integer.valueOf(sum);
		} else {
			int mid = (start + end) / 2;
			MyRecursiveTask t1 = new MyRecursiveTask(array, start, mid);
			MyRecursiveTask t2 = new MyRecursiveTask(array, mid, end);
			
			//recursive calls. synchronous call. waits until all subtasks complete.
			invokeAll(t1, t2);
			
			result = addResults(t1, t2);
		}
		return result;
	}
	
	private Integer addResults(MyRecursiveTask task1, MyRecursiveTask task2) {
		int value;
		try {
			value = task1.get().intValue() + task2.get().intValue();
		} catch(InterruptedException | ExecutionException e) {
			e.printStackTrace();
			value = 0;
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return value;
	}

}
