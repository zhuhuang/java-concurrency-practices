/**
 *  File: TestProducerConsumerExchanger.java
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
import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class TestProducerConsumerExchanger {

	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();
		
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		
		Producer producer = new Producer(buffer1, exchanger);
		Consumer consumer = new Consumer(buffer2, exchanger);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}

}
