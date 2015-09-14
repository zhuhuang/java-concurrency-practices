/**
 *  File: TestFileSearch.java
 *  Package: 
 *  Project: thread-FileSearch
 *  Created on: Feb 23, 2013
 * 
 *  Description: Control the Interruption of a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.concurrent.TimeUnit;

public class TestFileSearch {

	public static void main(String[] args) {
		
		//when I use "~/Workspace/eclipse" for the path, isDirectory returns a wrong value.
		FileSearch searcher = new FileSearch("/home/zhuhuang/Workspace/eclipse", "log.txt");
		Thread thread = new Thread(searcher);
		thread.start();
		
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
