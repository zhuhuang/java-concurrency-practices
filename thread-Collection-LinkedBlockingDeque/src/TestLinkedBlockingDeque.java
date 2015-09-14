/*
 * File: TestClient.java
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
public class TestLinkedBlockingDeque {

	public static void main(String[] args) {
		LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(3); //bounded
		Client client = new Client(queue);
		Thread thread = new Thread(client);
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				try {
					String request = queue.take();
					System.out.printf("Main: Request: %s at %s. Size: %d\n", request, new Date(), queue.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("TestClient: End of the program.\n");
	}

}
