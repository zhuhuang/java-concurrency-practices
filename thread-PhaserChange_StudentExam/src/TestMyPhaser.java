/**
 *  File: TestMyPhaser.java
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

public class TestMyPhaser {
	public static void main(String[] args) {
		MyPhaser phaser = new MyPhaser();
		
		Student[] students = new Student[5];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Student(phaser);
			phaser.register(); //add to the phaser
		}
		
		Thread[] threads = new Thread[5];
		for (int i = 0; i < students.length; i++) {
			threads[i] = new Thread(students[i], "Student " + i);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: The phaser has finished: %s.\n", phaser.isTerminated());
		
	}

}
