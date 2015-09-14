/**
 *  File: TestEvent.java
 *  Package: 
 *  Project: thread-Event
 *  Created on: Feb 24, 2013
 * 
 *  Description: Create and Run a Daemon Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class TestEvent {

	public static void main(String[] args) {
		
		Deque<Event> deque = new ArrayDeque<Event>(); //resizable-deque
		WriterTask writer = new WriterTask(deque);
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}
		
		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();

	}

}
