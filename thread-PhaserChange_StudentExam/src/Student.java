/**
 *  File: Student.java
 *  Package: 
 *  Project: thread-MyPhaser
 *  Created on: Mar 1, 2013
 * 
 *  Description: control phase change in concurrent phased tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */


import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {
	private Phaser phaser;
	
	public Student(Phaser phaser) {
		this.phaser = phaser;
	}
	
	@Override
	public void run() {
		System.out.printf("%s: Has arrived to do the exam. %s\n", 
				Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance(); //phase 0 to phase 1
		
		System.out.printf("%s: Is going to do the first exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		doExercise1();
		System.out.printf("%s: Has done the first exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance(); //phase 1 to phase 2
		
		System.out.printf("%s: Is going to do the second exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		doExercise2();
		System.out.printf("%s: Has done the second exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance(); //phase 2 to phase 3
		
		System.out.printf("%s: Is going to do the third exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		doExercise3();
		System.out.printf("%s: Has done the third exercise. %s\n", 
				Thread.currentThread().getName(), new Date());
		
		System.out.printf("%s: Has finished the exam. %s\n", 
				Thread.currentThread().getName(), new Date());
		phaser.arriveAndAwaitAdvance(); //phase 3 to phase 4
	}
	
	private void doExercise1() {
		try {
			long duration = (long) (Math.random() * 10);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void doExercise2() {
		try {
			long duration = (long) (Math.random() * 10);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void doExercise3() {
		try {
			long duration = (long) (Math.random() * 10);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
