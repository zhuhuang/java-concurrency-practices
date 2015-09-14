import java.util.concurrent.TimeUnit;

/*
 * File: BadPhilosopher.java
 * Package: 
 * Project: thread-Philosopher
 * Created on: 11:29:41 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */

/**
 * Deadlock when many philosophers eat together.
 */
public class BadPhilosopher extends Thread {
	private int bites = 10;
	private BadChopstick left;
	private BadChopstick right;
	
	public BadPhilosopher(BadChopstick left, BadChopstick right) {
		this.left = left;
		this.right = right;
	}
	
	public void eat() {
		pickUp();
		chew();
		putDown();
	}
	
	public void pickUp() {
		left.pickUp();
		right.pickUp();
	}
	
	public void chew() {
		try{
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void putDown() {
		left.putDown();
		right.putDown();
	}
	
	public void run() {
		for (int i = 0; i < bites; i++)
			eat();
	}
}
