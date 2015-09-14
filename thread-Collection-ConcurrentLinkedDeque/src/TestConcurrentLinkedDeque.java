/*
 * File: TestConcurrentLinkedDeque.java
 * Package: 
 * Project: thread-Collection-ConcurrentLinkedDeque
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

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * ConcurrentLinkedDeque
 * get, add, remove; peek, offer, poll;
 */
public class TestConcurrentLinkedDeque {

	public static void main(String[] args) {
		ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
		Thread threads[] = new Thread[100];
		
		for(int i = 0; i < threads.length; i++) {
			AddTask addTask = new AddTask(list);
			threads[i] = new Thread(addTask, "AddTask_Thread_" + i);
			threads[i].start();
		}
		System.out.printf("Main: %d AddTask threads have benn launched\n", threads.length);
		for(int i = 0; i < threads.length; i++) {
			try{
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: Size of the List:%d\n", list.size());
		
		for(int i = 0; i < threads.length; i++) {
			PollTask addTask = new PollTask(list);
			threads[i] = new Thread(addTask);
			threads[i].start();
		}
		System.out.printf("Main: %d PollTask threads have been launched\n", threads.length);
		for(int i = 0; i < threads.length; i++) {
			try{
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: Size of the List:%d\n", list.size());
	}

}
