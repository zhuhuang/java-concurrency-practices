import java.util.concurrent.ThreadLocalRandom;

/*
 * File: TaskLocalRandom.java
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
 * Usages of this class should typically be of the form: ThreadLocalRandom.current().nextX(...) (where X is Int, Long, etc). 
 * When all usages are of this form, it is never possible to accidently share a ThreadLocalRandom across multiple threads.
 */
public class TaskLocalRandom implements Runnable {
	//private ThreadLocalRandom randomGenerator;
	
	public TaskLocalRandom() {
		//randomGenerator = ThreadLocalRandom.current();
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s: %d\n", name, ThreadLocalRandom.current().nextInt(10));
		}
	}
}
