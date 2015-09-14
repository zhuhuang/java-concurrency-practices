/**
 *  File: WriterTask.java
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

import java.util.Deque; //interface
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {
	
	private Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 25; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated an event", 
					Thread.currentThread().getId()));
			deque.addFirst(event);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
