/**
 *  File: NetworkConnectionLoader.java
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
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning network connection loading: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Network connection loading has finished: %s\n", new Date());
	}

}
