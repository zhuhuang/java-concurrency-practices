/*
 * File: Task.java
 * Package: 
 * Project: thread-Collection-DelayedQueue
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

import java.util.Date;
import java.util.concurrent.DelayQueue;
/**
 * TODO
 */
public class Task implements Runnable {
	private int id;
	
	private DelayQueue<Event> queue;
	
	public Task(int id, DelayQueue<Event> queue) {
		this.id = id;
		this.queue = queue;
	}
	
	public void run() {
		Date now = new Date();
		Date delay = new Date();
		delay.setTime(now.getTime() + (id * 1000)); //milliseconds
		System.out.printf("Thread %s: %s\n", id, delay);
		
		for(int i = 0; i < 100; i++) {
			Event event = new Event(delay);
			queue.add(event);
		}
	}
}
