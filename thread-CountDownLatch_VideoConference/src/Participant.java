import java.util.concurrent.TimeUnit;

/**
 *  File: Participant.java
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

public class Participant implements Runnable {
	private VideoConference conference;
	private String name;
	
	public Participant(VideoConference conf, String name) {
		this.conference = conf;
		this.name = name;
	}
	
	@Override
	public void run() {
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		conference.arrive(name);
	}
}
