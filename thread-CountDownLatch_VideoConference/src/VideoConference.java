/**
 *  File: VideoConference.java
 *  Package: 
 *  Project: thread-VideoConference
 *  Created on: Feb 28, 2013
 * 
 *  Description: wait for multiple concurrent events
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

import java.util.concurrent.CountDownLatch;

public class VideoConference implements Runnable {
	private final CountDownLatch controller;
	
	public VideoConference(int number) {
		controller = new CountDownLatch(number);
	}
	
	//call each time when a participant arrives
	public void arrive(String name) {
		System.out.printf("Participant %s has arrived.\n", name);
		controller.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
	}
	
	@Override
	public void run() {
		System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
		try {
			//wait for participants
			controller.await();
			System.out.printf("VideoConference: All participants have come\n");
			System.out.printf("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
