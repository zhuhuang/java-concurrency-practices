/*
 * File: FooBad.java
 * Package: cracking
 * Project: java-jobpractice
 * Created on: 10:52:53 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */


import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class FooBad extends Foo {
	public ReentrantLock lock1;
	public ReentrantLock lock2;
	
	public FooBad() {
			lock1 = new ReentrantLock();
			lock2 = new ReentrantLock(); 
			lock1.lock();
			lock2.lock();
	}
	
	public void first() {
		System.out.println("Method first is called.");
		lock1.unlock();
	}
	
	public void second() {
		lock1.lock();
		lock1.unlock();
		System.out.println("Method second is called.");
		lock2.unlock();
	}
	
	public void third() {
		lock2.lock();
		lock2.unlock();
		System.out.println("Method third is called.");
	}
}
