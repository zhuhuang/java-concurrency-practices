import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/*
 * File: MyQueuedSynchronizer.java
 * Package: 
 * Project: thread-Customize-Lock
 * Created on: Aug 15, 2013
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
 * AbstractQueuedSynchronizer provides a framework for implementing blocking locks and related synchronizers (semaphores, events, etc) 
 * that rely on first-in-first-out (FIFO) wait queues. This class is designed to be a useful basis for most kinds of synchronizers 
 * that rely on a single atomic int value to represent state. Subclasses must define the protected methods that change this state, 
 * and which define what that state means in terms of this object being acquired or released. Given these, the other methods in this 
 * class carry out all queuing and blocking mechanics. Subclasses can maintain other state fields, but only the atomically updated int 
 * value manipulated using methods getState(), setState(int) and compareAndSetState(int, int) is tracked with respect to synchronization.
 */
public class MyQueuedSynchronizer extends AbstractQueuedSynchronizer {
	private AtomicInteger state;
	
	public MyQueuedSynchronizer() {
		state = new AtomicInteger(0);
	}
	
	@Override
	protected boolean tryAcquire(int arg) {
		return state.compareAndSet(0, 1); //set value to 1 if current value is 0
	}
	
	@Override
	protected boolean tryRelease(int arg) {
		return state.compareAndSet(1, 0);
	}
}
