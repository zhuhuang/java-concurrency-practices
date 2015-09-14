/**
 *  File: Producer.java
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

public class Producer implements Runnable {
	FileMock mock;
	private Buffer buffer;
	
	public Producer(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}
	
	@Override
	public void run()
	{
		buffer.setPendingLines(true);
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}
}
