/*
 * File: Decrementer.java
 * Package: 
 * Project: thread-Collection-AtomicArray
 * Created on: Aug 11, 2013
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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
 */
public class Decrementer implements Runnable {
	private AtomicIntegerArray vector;
	
	public Decrementer(AtomicIntegerArray vector) {
		this.vector = vector;
	}
	
	public void run() {
		for (int i = 0; i < vector.length(); i++) {
			//if (vector.get(i) != 0) {
				System.out.println("Decrementer: Vector[" + i + "] : " + vector.get(i));
			//}
		}
		
		for (int i = 0; i < vector.length(); i++) {
			this.vector.getAndDecrement(i); //atomically decrement by one element at index i
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}
	
}
