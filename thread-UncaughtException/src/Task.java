/**
 *  File: Task.java
 *  Package: 
 *  Project: thread-UncheckedException
 *  Created on: Feb 24, 2013
 * 
 *  Description: Process Uncontrolled Exceptions in a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class Task implements Runnable {
	
	@Override
	public void run() {
		//throws NumberFormatException
		int numero = Integer.parseInt("TTT");
	}
}
