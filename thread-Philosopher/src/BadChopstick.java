

/*
 * File: BadChopstick.java
 * Package: 
 * Project: thread-Philosopher
 * Created on: 11:29:33 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 
 */
public class BadChopstick {
	private Lock lock;
	
	public BadChopstick() {
		lock = new ReentrantLock();
	}
	
	public void pickUp() {
		lock.lock();
	}
	
	public void putDown() {
		lock.unlock();
	}
}
