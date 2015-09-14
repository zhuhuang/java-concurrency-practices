/*
 * File: TestTask.java
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
import java.util.concurrent.TimeUnit;
/**
 * TODO
 */
public class TestDelayQueue {

	public static void main(String[] args) {
		DelayQueue<Event> queue = new DelayQueue<>();
		Thread threads[] = new Thread[5];
		
		for (int i = 0; i < threads.length; i++) {
			Task task = new Task(i, queue);
			threads[i] = new Thread(task);
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try{
				threads[i].join();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		do {
			int counter = 0;
			Event event;
			do {
				event = queue.poll();
				if (event != null)
					counter++;
			} while(event != null);
			System.out.printf("At %s you have read %d events\n", new Date(), counter);
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while(queue.size() > 0);
	}
}
