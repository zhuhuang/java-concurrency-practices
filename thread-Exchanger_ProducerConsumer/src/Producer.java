/**
 *  File: Producer.java
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

public class Producer implements Runnable {
	private List<String> buffer;
	
	private final Exchanger<List<String>> exchanger;
	
	public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		int cycle = 1;
		
		//ten cycles of interchange
		for (int i = 0; i < 10; i++) {
			System.out.printf("Producer: Cycle %d\n", cycle);
			
			//add 10 strings to buffer in each cycle
			for (int j = 0; j < 10; j++) {
				String message = "Event " + ((i * 10) + j);
				System.out.printf("Producer: %s\n", message);
				buffer.add(message);
			}
			
			try {
				//interchange data with the consumer
				//when return, buffer is cleared
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Producer: " + buffer.size());
			cycle++;
		}
	}
}
