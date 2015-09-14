
/**
 *  File: DataSourceLoader.java
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

import java.util.concurrent.TimeUnit;
import java.util.Date;

public class DataSourceLoader implements Runnable {
	
	@Override
	public void run() {
		System.out.printf("Beginning data sources loading: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Data sources loading has finished: %s\n", new Date());
	}

}
