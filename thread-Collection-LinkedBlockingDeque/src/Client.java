/*
 * File: Client.java
 * Package: 
 * Project: thread-Collection-LinkedBlockingDeque
 * Created on: Aug 10, 2013
 *
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 *
 * Description: TODO
 * Compilation: TODO
 *
 */

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingDeque: put, take; push, pop; add, remove; offer, poll
 */
public class Client implements Runnable {
	private LinkedBlockingDeque<String> requestQueue;
	
	public Client(LinkedBlockingDeque<String> requestQueue) {
		this.requestQueue = requestQueue;
	}

	public void run() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				StringBuilder request = new StringBuilder();
				request.append(i);
				request.append(":");
				request.append(j);
				try {
					requestQueue.put(request.toString()); //add to queue
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.printf("Client: %s at %s.\n", request, new Date());
			}
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Client: END.\n");
	}
}
