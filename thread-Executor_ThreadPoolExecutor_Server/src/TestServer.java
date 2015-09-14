/**
 *  File: TestServer.java
 *  Package: 
 *  Project: thread-ThreadPoolExecutor_Server
 *  Created on: Mar 13, 2013
 * 
 *  Description: create a thread executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestServer {

	public static void main(String[] args) {
		Server server = new Server();
		for (int i = 0; i < 100; i++) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.endServer();
	}
}
