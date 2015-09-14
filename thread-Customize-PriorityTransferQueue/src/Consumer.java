/*
 * File: Consumer.java
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
 * Consumer
 */
public class Consumer implements Runnable {
	private MyPriorityTransferQueue<Event> buffer;
	
	public Consumer(MyPriorityTransferQueue<Event> buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i = 0; i < 1002; i++) {
			try {
				Event value = buffer.take(); //block if not elements available
				System.out.printf("Consumer: %s: %d\n", value.getThread(), value.getPriority());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
