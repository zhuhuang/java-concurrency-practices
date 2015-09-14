/**
 *  File: TestVideoConference.java
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

public class TestVideoConference {
	public static void main(String[] args) {
		VideoConference conference = new VideoConference(10);
		
		Thread threadConference = new Thread(conference);
		threadConference.start();
		
		for (int i = 0; i < 10; i++) {
			//conference also has a thread: threadConference
			Participant p = new Participant(conference, "Participant " + i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
