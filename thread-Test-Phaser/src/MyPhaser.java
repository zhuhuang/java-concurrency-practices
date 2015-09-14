import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/*
 * File: MyTask.java
 * Package: 
 * Project: thread-Test-Phaser
 * Created on: Aug 17, 2013
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
public class MyPhaser implements Runnable {
	private int time;
	private Phaser phaser;
	
	public MyPhaser(int time, Phaser phaser) {
		this.time = time;
		this.phaser = phaser;
	}
	
	public void run() {
		//The behavior of this function worth attention.
		//Phase starts at 0. When all parties arrive the phase number is advanced by one.
		//phaser.arrive(); //Arrives at this phaser, without waiting for others to arrive.
		
		//phase 0 to phase 1
		phaser.arriveAndAwaitAdvance();
		
		//In the output for phase 0, only two threads wrote "Entering phase 0", the thirg wrote "Entering phase 1".
		//This is because when the third call arrive(), phaser number is added by one.
		//Fixed by using arriveAndAwaitAdvance() instead in the beginning.
		System.out.printf("%s: Entering phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		
		//phase 1 to phase 2
		phaser.arriveAndAwaitAdvance(); //Arrives at this phaser and awaits others.
		
		System.out.printf("%s: Entering phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		
		//phase 2 to phase 3
		phaser.arriveAndAwaitAdvance(); //Arrives at this phaser and awaits others.
		
		System.out.printf("%s: Entering phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Finishing phase %d.\n", Thread.currentThread().getName(), phaser.getPhase());
		
		phaser.arriveAndDeregister(); //Arrives at this phaser and deregisters from it without waiting for others to arrive. 
	}
}
