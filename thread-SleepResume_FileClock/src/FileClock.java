/**
 *  File: FileClock.java
 *  Package: 
 *  Project: thread-FileClock
 *  Created on: Feb 24, 2013
 *
 *  Description: Sleep and Resume a Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

//Thread.sleep()
//TimeUnit.SECONDS.sleep(), TimeUnit.MILISECONDS.sleep()

public class FileClock implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("The FileClock has been interrupted.\n");
				//e.printStackTrace();
			}
		}
	}

}
