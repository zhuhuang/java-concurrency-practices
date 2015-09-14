/*
 * File: Task.java
 * Package: 
 * Project: thread-Collection-PriorityBlockingQueue
 * Created on: Aug 10, 2013
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

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Task
 */
public class Task implements Runnable {
	private int id;
	private PriorityBlockingQueue<Event> queue;
	
	public Task(int id, PriorityBlockingQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}
	
	public void run() {
		for(int i = 0; i < 500; i++) {
			Event event = new Event(id, i); //different priorities
			queue.add(event);
		}
		System.out.printf("Task Thread %d: END.\n", id);
	}
}
