/*
 * File: PollTask.java
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
public class PollTask implements Runnable {
	private ConcurrentLinkedDeque<String> list;
	
	public PollTask(ConcurrentLinkedDeque<String> list) {
		this.list = list;
	}
	
	public void run() {
		for(int i = 0; i < 5000; i++) {
			list.pollFirst();
			list.pollLast();
		}
	}
}
