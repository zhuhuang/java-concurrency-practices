/*
 * File: MyWorkerThread.java
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

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * ForkJoinWorkerThread
 */
public class MyWorkerThread extends ForkJoinWorkerThread {
	private static ThreadLocal<Integer> taskCounter = new ThreadLocal<Integer>(); //not correct way to use ThreadLocal
	
	protected MyWorkerThread(ForkJoinPool pool) {
		super(pool);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		System.out.printf("MyWorkerThread %d: Initializing task counter.\n", getId());
		taskCounter.set(0);
	}
	
	@Override
	public void onTermination(Throwable exception) {
		super.onTermination(exception);
		System.out.printf("MyWorkderThread %d: %d\n", getId(), taskCounter.get());
	}
	
	//counter the number of add tasks
	public void addTask() {
		int counter = taskCounter.get().intValue();
		counter++;
		taskCounter.set(counter);
	}
}
