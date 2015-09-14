import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/*
 * File: MyPriorityTransferQueue.java
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
 * PriorityBlockingQueue + TransferQueue 
 * Compared TransferQueue with Exchanger (not concurrent)
 */
public class MyPriorityTransferQueue<E> extends PriorityBlockingQueue<E> 
implements TransferQueue<E> {
	private AtomicInteger counter; //Consumer counter
	private LinkedBlockingQueue<E> transfered;
	
	/*
	 * This attribute is used to control the access to the implemented operations. 
	 * Only one thread can be working with the data structure: the queue itself
	 */
	private ReentrantLock lock; //protect whom?
	
	public MyPriorityTransferQueue() {
		counter = new AtomicInteger(0);
		lock = new ReentrantLock();
		transfered = new LinkedBlockingQueue<E>();
	}

	@Override
	public void transfer(E e) throws InterruptedException {
		// Transfers the element to a consumer, waiting if necessary to do so.
		lock.lock();
		if (counter.get() != 0) {
			//if some consumer is waiting, transfer the element immediately
			put(e); //super.put(e)
			lock.unlock();
		} else {
			//if no consumer is waiting, save the element and block until the element is consumed
			transfered.add(e);
			lock.unlock();
			synchronized(e) { //synchronize on e
				/*
				 * The current thread must own this object's monitor. The thread releases ownership of this monitor 
				 * and waits until another thread notifies threads waiting on this object's monitor to wake up either 
				 * through a call to the notify method or the notifyAll method. The thread then waits until it can 
				 * re-obtain ownership of the monitor and resumes execution.
				 */
				e.wait(); //wait until another thread calls e.notify() or e.notifyAll()
			}
		}
	}

	@Override
	public boolean tryTransfer(E e) {
		// Transfers the element to a waiting consumer immediately, if possible.
		lock.lock();
		boolean value;
		if (counter.get() == 0) {
			//no consumer exists, don't transfer
			value = false;
		} else {
			put(e); 
			value = true;
		}
		lock.unlock();
		return value;
	}
	
	@Override
	public boolean tryTransfer(E e, long timeout, TimeUnit unit)
			throws InterruptedException {
		lock.lock();
		if (counter.get() != 0) {
			put(e); //super.put(e)
			lock.unlock();
			return true;
		} else {
			transfered.add(e);
			long newTimeout = TimeUnit.MILLISECONDS.convert(timeout, unit);
			lock.unlock();
			e.wait(newTimeout);
			lock.lock();
			if (transfered.contains(e)) { //element not taken by consumer after timeout. is it safe to do so?
				transfered.remove(e);
				lock.unlock();
				return false;
			} else {
				lock.unlock();
				return true;
			} 
		}
	}

	@Override
	public boolean hasWaitingConsumer() {
		return (counter.get() != 0);
	}

	@Override
	public int getWaitingConsumerCount() {
		return counter.get();
	}

	/*
	 * This method returns the next element to be consumed. If there are elements in the list of transferred elements, 
	 * the element to be consumed is taken from that list. Otherwise, it is taken from the priority queue.
	 */
	@Override
	public E take() throws InterruptedException {
		lock.lock();
		counter.incrementAndGet(); //increase consumer counter
		E value = transfered.poll();
		if (value == null) {
			lock.unlock();
			value = super.take(); //may block if empty queue
			lock.lock(); //for what? where to unlock?
		} else {
			//some thread blocked waiting for consumer to come: see transfer()
			synchronized(value) {
				value.notify(); //wake up the thread blocked in transfer
			}
		}
		counter.decrementAndGet(); //decrese consumer counter
		lock.unlock();
		return value;
	}
}
