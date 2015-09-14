/**
 *  File: Consumer.java
 *  Package: 
 *  Project: thread-ProducerConsumerExchanger
 *  Created on: Mar 1, 2013
 * 
 *  Description: change data between concurrent tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {
	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;
	
	public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		int cycle = 1;
		
		//ten cycles of interchange
		for (int i = 0; i < 10; i++) {
			System.out.printf("Consumer: Cycle %d\n", cycle);
			
			try {
				//interchange data with the producer
				//when return, buffer is filled
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Consumer: " + buffer.size());
			
			//read strings from the buffer
			for (int j = 0; j < 10; j++) {
				String message = buffer.get(0);
				System.out.printf("Consumer: %s\n", message);
				buffer.remove(0);
			}
			
			cycle++;
		}
	}
}
