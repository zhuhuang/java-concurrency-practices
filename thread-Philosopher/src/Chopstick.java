import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * File: Chopstick.java
 * Package: 
 * Project: thread-Philosopher
 * Created on: 11:29:55 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */

/**
 * 
 */
public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public boolean pickUp() {
		return lock.tryLock(); //not lock
	}
	
	public void putDown() {
		lock.unlock();
	}
}
