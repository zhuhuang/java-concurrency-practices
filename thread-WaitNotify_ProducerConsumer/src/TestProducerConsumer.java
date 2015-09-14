/**
 *  File: TestProducerConsumer.java
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

public class TestProducerConsumer {

	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread pthread = new Thread(producer);
		Consumer consumer = new Consumer(storage);
		Thread cthread = new Thread(consumer);
		
		pthread.start();
		cthread.start();
		
		try {
			pthread.join();
			cthread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Producer-Consumer Simulation Completed.");
	}

}
