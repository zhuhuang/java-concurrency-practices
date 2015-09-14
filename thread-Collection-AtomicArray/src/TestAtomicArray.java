/*
 * File: TestAtomicArray.java
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

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * TODO
 */
public class TestAtomicArray {

	public static void main(String[] args) {
		final int THREADS = 100;
		AtomicIntegerArray vector = new AtomicIntegerArray(100);
		
		Incrementer incrementer = new Incrementer(vector);
		Decrementer decrementer = new Decrementer(vector);
		Thread threadIncrementer[] = new Thread[THREADS];
		Thread threadDecrementer[] = new Thread[THREADS];
		
		for (int i = 0; i < THREADS; i++) {
			threadIncrementer[i] = new Thread(incrementer); //share the same incrementer
			threadDecrementer[i] = new Thread(decrementer); //share the same decrementer
			threadIncrementer[i].start();
			threadDecrementer[i].start();
		}
		
		for (int i = 0; i < THREADS; i++) {
			try {
				threadIncrementer[i].join();
				threadDecrementer[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/*for (int i = 0; i < vector.length(); i++) {
			if (vector.get(i) != 0) {
				System.out.println("Vector[" + i + "] : " + vector.get(i));
			}
		}*/
		
		System.out.println("Main: End of the example");
	}

}
