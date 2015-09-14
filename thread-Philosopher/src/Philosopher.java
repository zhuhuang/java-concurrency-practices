import java.util.concurrent.TimeUnit;

/*
 * File: Philosopher.java
 * Package: 
 * Project: thread-Philosopher
 * Created on: 11:29:47 PM
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 */

/**
 * Will not cause deadlock.
 */
public class Philosopher {
	private int bites = 10;
	private Chopstick left;
	private Chopstick right;
	
	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
	}
	
	public void eat() {
		//try to pick up forks
		if (pickUp()) {
			chew();
			putDown();
		}
	}
	
	public boolean pickUp() {
		//try to pick up forks
		
		//left
		if (!left.pickUp()) 
			return false;
		
		//right
		if (right.pickUp()) {
			left.putDown();
			return false;
		}
		return true;
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
