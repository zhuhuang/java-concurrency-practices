import java.util.Date;
import java.util.concurrent.ForkJoinTask;

/*
 * File: MyWorkerTask.java
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
 * Normally, you will send to the ForkJoinPool objects one of two subclasses of the ForkJoinTask class:
 * RecursiveAction: If your tasks don't return a result
 * RecursiveTask: If your tasks return a result
 */
public abstract class MyWorkerTask extends ForkJoinTask<Void> {
	private String name;
	
	public MyWorkerTask(String name) {
		this.name = name;
	}
	
	@Override
	public Void getRawResult() { //abstract method of ForkJoinTask
		return null;
	}
	
	@Override
	public void setRawResult(Void value) { //abstract method of ForkJoinTask
	}
	
	@Override
	protected boolean exec() {
		Date startDate = new Date();
		compute();
		Date finishDate = new Date();
		long diff = finishDate.getTime() - startDate.getTime();
		System.out.printf("MyWorkerTask: %s : %d Milliseconds to complete.\n", name, diff);
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	protected abstract void compute();
}
