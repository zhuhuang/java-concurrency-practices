/**
 *  File: TestSearcherGrouper.java
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

import java.util.concurrent.CyclicBarrier;

public class TestSearcherGrouper {

	public static void main(String[] args) {
		final int ROWS = 1000;
		final int COLUMNS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int ROWS_PER_PARTICIPANT = 20;
		
		MatrixMock mock = new MatrixMock(ROWS, COLUMNS, SEARCH);
		Results results = new Results(ROWS);
		
		Grouper grouper = new Grouper(results);
		
		//when all threads reach at the synchronization point, grouper is executed
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		
		Searcher[] searchers = new Searcher[PARTICIPANTS];
		for (int i = 0; i < PARTICIPANTS; i++) {
			searchers[i] = new Searcher(i*ROWS_PER_PARTICIPANT, i*ROWS_PER_PARTICIPANT + ROWS_PER_PARTICIPANT-1,
					mock, results, SEARCH, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}
		
		System.out.println("Main: The main thread has finished.");
	}

}
