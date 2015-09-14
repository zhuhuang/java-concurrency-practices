import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

/*
 * File: MyLock.java
 * Package: 
 * Project: thread-Test-Lock
 * Created on: Aug 17, 2013
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
 * MyLock extends ReentrantLock
 */
public class MyLock extends ReentrantLock {
	
	//The name of the thread that has the control of a lock
	public String getOwnerName() {
		if (this.getOwner() == null) {
			return "None";
		}
		return this.getOwner().getName();
	}
	
	//A list of threads queued in a lock.
	public Collection<Thread> getThreads() {
		return this.getQueuedThreads();
	}
}
