/*
 * File: Producer.java
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
 * Producer
 */
public class Producer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	
	public Producer(MyPriorityTransferQueue<Event> buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			Event event = new Event(Thread.currentThread().getName(), i);
			
			/*
			 * A BlockingQueue in which producers may wait for consumers to receive elements. A TransferQueue may be useful for 
			 * example in message passing applications in which producers sometimes (using method transfer(E)) await receipt of 
			 * elements by consumers invoking take or poll, while at other times enqueue elements (via method put) without waiting 
			 * for receipt.
			 */
			buffer.put(event); //asynchronous sending, not using transfer(event). never block (unbounded queue).
		}
	}
}
