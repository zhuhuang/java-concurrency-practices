import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/*
 * File: TestMyPhaser.java
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
public class TestMyPhaser {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		
		for (int i = 0; i < 3; i++) {
			MyPhaser task = new MyPhaser(i+1, phaser);
			Thread thread = new Thread(task);
			thread.start();
		}
		
		for (int i = 0; i < 10; i++) {
			if (!phaser.isTerminated()) {
				System.out.printf("****************************\n");
				System.out.printf("Main: Phaser Log\n");
				System.out.printf("Main: Phaser: Phase: %d\n", phaser.getPhase());
				System.out.printf("Main: Phaser: Registered Parties: %d\n", phaser.getRegisteredParties());
				System.out.printf("Main: Phaser: Arrived Parties: %d\n", phaser.getArrivedParties());
				System.out.printf("Main: Phaser: Unarrived Parties: %d\n", phaser.getUnarrivedParties());
				System.out.printf("****************************\n");
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
