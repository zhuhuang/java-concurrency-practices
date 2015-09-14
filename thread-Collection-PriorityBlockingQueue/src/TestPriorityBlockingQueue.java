/*
 * File: TestTask.java
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
 * PriorityBlockingQueue is backed by a heap data structure (MinHeap).
 * poll, remove, peek, and element access the element at the head of the queue.
 * The head of the queue is the least element with respect to the specified ordering. 
 * To put highest priority first need to reverse the comparison.
 */
public class TestPriorityBlockingQueue {

	public static void main(String[] args) {
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>(); //unbounded
		Thread taskThreads[] = new Thread[5];
		
		for(int i = 0; i < taskThreads.length; i++) {
			Task task = new Task(i, queue);
			taskThreads[i] = new Thread(task);
		}
		
		for(int i = 0; i < taskThreads.length; i++) {
			taskThreads[i].start();
		}
		
		for(int i = 0; i < taskThreads.length; i++) {
			try {
				taskThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		for(int i = 0; i < taskThreads.length * 500; i++) {
			Event event = queue.poll();
			System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
		}
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		
		System.out.printf("Main: End of the program.\n");
	}

}
