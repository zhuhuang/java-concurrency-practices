/**
 *  File: TestDataSourceLoader.java
 *  Package: 
 *  Project: thread-DataSourceLoader
 *  Created on: Feb 24, 2013
 * 
 *  Description: Wait for the Finalization of a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Date;

public class TestDataSourceLoader {

	public static void main(String[] args) {
		
		DataSourceLoader dsLoader = new DataSourceLoader();
		Thread thread1 = new Thread(dsLoader, "DataSourceThread");
		
		NetworkConnectionLoader ncLoader = new NetworkConnectionLoader();
		Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");
		
		thread1.start();
		thread2.start();
		
		//wait for both threads to terminate
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());

	}

}
