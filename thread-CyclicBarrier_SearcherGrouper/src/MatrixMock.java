/**
 *  File: MatrixMock.java
 *  Package: 
 *  Project: thread-SearcherGrouper
 *  Created on: Feb 28, 2013
 * 
 *  Description: synchronize tasks in a common point
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.Random;

//Also check FileMock under project: thread-ConditionProducerConsumer
//simulate a matrix
public class MatrixMock {
	private int[][] data;
	
	public MatrixMock(int row, int col, int number) {
		int counter = 0;
		data = new int[row][col];
		Random random = new Random();
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i][j] = random.nextInt(10);
				if (data[i][j] == number) {
					counter++;
				}
			}
		}
		
		System.out.printf("Mock: There are %d occurrences of number %d in generated data.\n", 
				counter, number);
	}
	
	public int[] getRow(int row) {
		if ((row >= 0) && (row < data.length)) {
			return data[row];
		}
		return null;
	}
}
