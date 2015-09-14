/**
 *  File: Buffer.java
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

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<String>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	//insert a new line in the buffer
	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				//wait for this condition (available space)
				space.await(); 
			}
			
			buffer.offer(line);
			
			System.out.printf("%s: Inserted Line: %d\n", 
					Thread.currentThread().getName(), buffer.size());
			
			//new line added, wake up threads waiting on this condition (available lines)
			lines.signalAll(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	//get a line from the buffer
	public String get() {
		String line = null;
		lock.lock();
		try {
			//when buffer is empty and there are more lines to be produced, then wait
			while ((buffer.size() == 0) && (hasPendingLines())) {
				//nothing to read right now, just wait
				lines.await();
			}
			
			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n", 
						Thread.currentThread().getName(), buffer.size());
				
				//new space created, signal all threads waiting for this condition (available spaces)
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
		return line;
	}
	
	//will be called by content producers
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
	
	//return true if there are more lines to be processed, either in the buffer, or the on the air
	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
	
}
