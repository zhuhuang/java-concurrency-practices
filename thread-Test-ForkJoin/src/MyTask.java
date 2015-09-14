import java.util.concurrent.RecursiveAction;

/*
 * File: MyTask.java
 * Package: 
 * Project: thread-Test-ForkJoin
 * Created on: Aug 17, 2013
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
 * Subclass of ForkJoinTask:
 * RecursiveTask: A recursive result-bearing ForkJoinTask. (compute())
 * RecursiveAction: A recursive resultless ForkJoinTask. (compute())
 */
public class MyTask extends RecursiveAction {
	private int[] array;
	private int start;
	private int end;
	
	public MyTask(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	//no results returned
	@Override
	protected void compute() {
		if (end - start > 100) {
			int mid = (start + end) / 2;
			MyTask task1 = new MyTask(array, start, mid);
			MyTask task2 = new MyTask(array, mid, end);
			//task1.fork();
			//task2.fork();
			//task1.join();
			//task2.join();
			invokeAll(task1, task2);
		} else {
			for (int i = start; i < end; i++) {
				array[i]++;
			}
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
