import java.util.Random;

/**
 *  File: Consumer.java
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

public class Consumer implements Runnable {
	private Buffer buffer;
	
	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}
	
	//simulate thr processing
	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
