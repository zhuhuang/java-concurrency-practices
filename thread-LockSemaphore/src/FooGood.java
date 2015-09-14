/*
 * File: FooGood.java
 * Package: cracking
 * Project: java-jobpractice
 * Created on: 11:01:27 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 */
public class FooGood extends Foo {
	public Semaphore sem1;
	public Semaphore sem2;
	
	public FooGood() {
			sem1 = new Semaphore(1);
			sem2 = new Semaphore(1); 
			
			try {
				sem1.acquire();
				sem2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void first() {
		System.out.println("Method first is called.");
		sem1.release();
	}
	
	public void second() {
		try {
			sem1.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sem1.release();
		System.out.println("Method second is called.");
		sem2.release();
	}
	
	public void third() {
		try {
			sem2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sem2.release();
		System.out.println("Method third is called.");
	}
}
