import java.util.Random;

/**
 *  File: ArrayGenerator.java
 *  Package: 
 *  Project: thread-ForkJoin_CancelTask_TaskManager
 *  Created on: May 14, 2013
 * 
 *  Description: canceling a task
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class ArrayGenerator {
	public int[] generateArray(int size) {
		int[] array = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(10);
		}
		return array;
	}
}
