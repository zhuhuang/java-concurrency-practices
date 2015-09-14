/**
 *  File: Grouper.java
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

public class Grouper implements Runnable {
	//results accumulated by Searchers
	private Results results;
	
	public Grouper(Results results) {
		this.results = results;
	}
	
	@Override
	public void run() {
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");
		
		//read data
		int[] data = results.getData();
		
		//process data
		for (int number:data) {
			finalResult += number;
		}
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}
	
}
