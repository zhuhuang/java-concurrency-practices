/*
 * File: FooThread.java
 * Package: cracking
 * Project: java-jobpractice
 * Created on: 10:56:40 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */


/**
 * 
 */
public class FooThread extends Thread {
	private Foo foo;
	private String method;
	
	public FooThread(Foo foo, String method) {
		this.foo = foo;
		this.method = method;
	}
	
	public void run() {
		if (method.equals("first")) {
			foo.first();
		} else if (method.equals("second")) {
			foo.second();
		} else {
			foo.third();
		}
	}
}
