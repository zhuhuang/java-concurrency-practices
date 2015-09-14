/**
 *  File: Results.java
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

public class Results {
	//search results of each thread
	private int[] data;
	
	public Results(int size) {
		data = new int[size];
	}
	
	public void setData(int position, int value) {
		//the number of occurrence of value in row position
		data[position] = value;
	}
	
	public int[] getData() {
		return data;
	}
}
