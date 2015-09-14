/**
 *  File: MyPhaser.java
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

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser {

	//called when phase will be changed (before it is changed)
	//phaser.arriveAndAwaitAdvance() will increase the phase
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
		case 0:
			return studentArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
	}
	
	private boolean studentArrived() {
		System.out.printf("******* Phaser: The exam are going to start. The students are ready. *******\n");
		System.out.printf("******* Phaser: We have %d students. *******\n", getRegisteredParties());
		return false; //ready to move to next phase
	}
	
	private boolean finishFirstExercise() {
		System.out.printf("******* Phaser: All students have finished the first exercise. *******\n");
		System.out.printf("******* Phaser: It's time for the second one. *******\n");
		return false; //ready to move to next phase
	}
	
	private boolean finishSecondExercise() {
		System.out.printf("******* Phaser: All students have finished the second exercise. *******\n");
		System.out.printf("******* Phaser: It's time for the third one. *******\n");
		return false; //ready to move to next phase
	}
	
	private boolean finishExam() {
		System.out.printf("******* Phaser: All students have finished the exam. *******\n");
		System.out.printf("******* Phaser: Thank you for your time. *******\n");
		return true; //ready to end
	}
}
