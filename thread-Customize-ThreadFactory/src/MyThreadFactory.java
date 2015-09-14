/*
 * File: MyThreadFactory.java
 * Package: 
 * Project: thread-Customize-ThreadFactory
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

import java.util.concurrent.ThreadFactory;
/**
 * Customized ThreadFactory
 */
public class MyThreadFactory implements ThreadFactory {
	private int counter;
	private String prefix;
	
	public MyThreadFactory(String prefix) {
		this.prefix = prefix;
	}
	
	//newThread
	public Thread newThread(Runnable r) {
		MyThread myThread = new MyThread(r, prefix + "-" + counter);
		counter++;
		return myThread;
	}
}
