/**
 *  File: Producer.java
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

public class Producer implements Runnable {
	private EventStorage storage;
	
	public Producer(EventStorage storage) {
		this.storage = storage;
	}
	
	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			storage.set();
		}
	}
}
