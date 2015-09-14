/*
 * File: MyWorkerThreadFactory.java
 * Package: 
 * Project: thread-Customize-ForkJoinWorkerThread
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


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * TODO
 */
public class MyWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
	public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
		return new MyWorkerThread(pool);
	}
}
