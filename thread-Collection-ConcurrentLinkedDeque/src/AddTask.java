/*
 * File: AddTask.java
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
 */
public class AddTask implements Runnable {
	private ConcurrentLinkedDeque<String> list;
	
	public AddTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}

	public void run() {
		String name = Thread.currentThread().getName();
		for(int i = 0; i < 10000; i++) {
			list.add(name + ": Element " + i);
		}
	}
}
