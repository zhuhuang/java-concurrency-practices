import java.util.concurrent.TimeUnit;

/*
 * File: MyPriorityTask.java
 * Package: 
 * Project: thread-Customize-PriorityBasedExecutor
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
public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
	private int priority;
	private String name;
	
	public MyPriorityTask(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int compareTo(MyPriorityTask o) {
		//the bigger value, the higher priority
		//an opposite example can be found in project: thread-Collection-PriorityBlockingQueue
		if (this.getPriority() < o.getPriority()) {
			return 1;
		} else if (this.getPriority() > o.getPriority()) {
			return -1;
		}
		return 0;
	}
	
	public void run() {
		System.out.printf("MyPriorityTask: %s Priority : %d\n", name, priority);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
