import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
 * File: MyLock.java
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
 * TODO
 */
public class MyLock implements Lock {
	private AbstractQueuedSynchronizer sync;
	
	public MyLock() {
		sync = new MyQueuedSynchronizer();
	}
	
	@Override
	public void lock() {
		sync.acquire(1); //acquire in exclusive mode, ignoring interrupts
	}
	
	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1); //acquire in exclusive mode, aborting if interrupted
	}
	
	@Override
	public boolean tryLock() {
		try {
			//acquire in exclusive mode, aborting if interrupted and failing if the given timeout elapses
			return sync.tryAcquireNanos(1, 1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, TimeUnit.NANOSECONDS.convert(time, unit));
	}
	
	@Override
	public void unlock() {
		sync.release(1);
	}
	
	@Override 
	public Condition newCondition() {
		//required by interface Lock
		return sync.new ConditionObject();
	}
}
