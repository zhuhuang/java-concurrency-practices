/**
 *  File: EventStorage.java
 *  Package: 
 *  Project: thread-ProducerConsumer
 *  Created on: Feb 27, 2013
 * 
 *  Description: use conditions in synchronized code
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.List;
import java.util.LinkedList;
import java.util.Date;

public class EventStorage {
	
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<Date>();
	}
	
	public synchronized void set() {
		//use while loop here, not a if statement
		//because waking up doesn't mean there are available space 
		//need to double check
		while (storage.size() == maxSize) {
			try {
				wait(); //wait until notify or notifyAll is called by other threads
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//pay attention to this.
		//event storage is given a LinkedList<Date> in the constructor
		//it is still considered as a List<Date>
		//to call methods in LinkedList<Date>, we need to do type conversion
		((LinkedList<Date>)storage).offer(new Date()); //produce something
		System.out.printf("Set: %d\n", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		//use while loop here, not a if statement
		//because waking up doesn't mean there are something available
		//need to double check
		while (storage.size() == 0) {
			try {
				wait(); //wait until notify or notifyAll is called by other threads
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Get: %d: %s\n", storage.size(), 
				((LinkedList<Date>)storage).poll());
		notifyAll();
	}
}
