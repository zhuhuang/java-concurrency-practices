/*
 * File: TestFoo.java
 * Package: cracking
 * Project: java-jobpractice
 * Created on: 11:05:43 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */

/**
 * 
 */
public class TestFoo {

	/**
	 * 
	 */
	public static void main(String[] args) {
		FooBad bad = new FooBad();
		FooGood good = new FooGood();
		FooThread badThread1 = new FooThread(bad, "first");
		FooThread badThread2 = new FooThread(bad, "second");
		FooThread badThread3 = new FooThread(bad, "third");
		badThread1.start();
		badThread2.start();
		badThread3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		FooThread goodThread1 = new FooThread(good, "first");
		FooThread goodThread2 = new FooThread(good, "second");
		FooThread goodThread3 = new FooThread(good, "third");
		goodThread1.start();
		goodThread2.start();
		goodThread3.start();
	}
}
