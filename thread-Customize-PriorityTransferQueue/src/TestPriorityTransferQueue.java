import java.util.concurrent.TimeUnit;

/*
 * File: TestPriorityTransferQueue.java
 * Package: 
 * Project: thread-Customize-PriorityTransferQueue
 * Created on: Aug 16, 2013
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

/**
 * TODO
 */
public class TestPriorityTransferQueue {

	public static void main(String[] args) {
		MyPriorityTransferQueue<Event> buffer = new MyPriorityTransferQueue<Event>();
		Producer producer = new Producer(buffer);
		Thread[] producerThreads = new Thread[10];
		for (int i = 0; i < producerThreads.length; i++) {
			producerThreads[i] = new Thread(producer);
			producerThreads[i].start();
		}
		
		Consumer consumer = new Consumer(buffer);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
		Event myEvent = new Event("Core Event 1", 0);
		try {
			buffer.transfer(myEvent); //synchronous sending
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: My Event has been transfered.\n");
		
		for (int i = 0; i < producerThreads.length; i++) {
			try {
				producerThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.printf("Main: Buffer: Consumer count: %d\n", buffer.getWaitingConsumerCount());
		myEvent = new Event("Core Event 2", 0);
		try {
			buffer.transfer(myEvent); //synchronous sending
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			consumerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: End of the program.");
	}

}
