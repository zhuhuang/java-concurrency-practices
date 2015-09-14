/*
 * File: TestTaskLocalRandom.java
 * Package: 
 * Project: thread-Collection-ThreadLocalRandom
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

/**
 * TODO
 */
public class TestThreadLocalRandom {

	public static void main(String[] args) {
		Thread threads[] = new Thread[5];
		for (int i = 0; i < threads.length; i++) {
			TaskLocalRandom task = new TaskLocalRandom();
			threads[i] = new Thread(task);
			threads[i].start();
		}
	}

}
