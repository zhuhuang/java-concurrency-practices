/**
 *  File: Searcher.java
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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable {
	private int firstRow; //search range starts at this row
	private int lastRow; //search range stops at this last row (included)
	private MatrixMock mock; //matrix
	private Results results; //to store search results
	private int number; //number we're searching for
	private final CyclicBarrier barrier; //for synchronization
	
	public Searcher(int first, int last, MatrixMock mock, 
			Results results, int number, CyclicBarrier barrier) 
	{
		this.firstRow = first;
		this.lastRow = last;
		this.mock = mock;
		this.results = results;
		this.number = number;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		int counter;
		System.out.printf("%s: Processing lines from %d to %d.\n", 
				Thread.currentThread().getName(), firstRow, lastRow);
		
		//search given number is rows assigned to this thread
		//and upate the results
		for (int i = firstRow; i <= lastRow; i++) {
			int row[] = mock.getRow(i); //get row of data from matrix
			
			//process data: counting occurrence of number
			counter = 0;
			for (int j = 0; j < row.length; j++) {
				if (row[j] == number) 
					counter++;
			}
			
			//update results
			results.setData(i, counter);
		}
		
		System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
		
		try {
			//wait for other threads to arrive at this point
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
}
