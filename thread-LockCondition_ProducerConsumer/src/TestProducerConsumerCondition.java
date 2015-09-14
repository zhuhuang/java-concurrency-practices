/**
 *  File: TestConditionProducerConsumer.java
 *  Package: 
 *  Project: thread-ConditionProducerConsumer
 *  Created on: Feb 27, 2013
 * 
 *  Description: use multiple conditions in a Lock
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestProducerConsumerCondition {
	
	public static void main(String[] args) {
		FileMock mock = new FileMock(100, 15);
		Buffer buffer = new Buffer(20);
		
		Producer producer = new Producer(mock, buffer);
		Thread pthread = new Thread(producer);
		
		Consumer[] consumers = new Consumer[3];
		Thread[] cthreads = new Thread[3];
		
		for (int i=0; i<3; i++) {
			consumers[i] = new Consumer(buffer);
			cthreads[i] = new Thread(consumers[i]);
		}
		
		pthread.start();
		
		for (int i=0; i<3; i++) {
			cthreads[i].start();
		}
	}

}
