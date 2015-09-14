/*
 * File: Task.java
 * Package: 
 * Project: thread-Customize-ForkJoinTask
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
public class Task extends MyWorkerTask {
	private int[] array;
	int start, end;
	
	public Task(String name, int[] array, int start, int end) {
		super(name);
		this.array = array;
		this.start = start;
		this.end = end;
	}
	
	protected void compute() {
		if (end - start > 1000) {
			int mid = (start + end) / 2; //this is end+start, not end-start
			Task task1 = new Task(this.getName(), array, start, mid);
			Task task2 = new Task(this.getName(), array, mid, end);
			invokeAll(task1, task2);
		} else {
			for (int i = start; i < end; i++) {
				array[i]++;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
