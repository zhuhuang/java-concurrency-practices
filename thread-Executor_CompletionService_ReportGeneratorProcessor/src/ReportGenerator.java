import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *  File: ReportGenerator.java
 *  Package: 
 *  Project: thread-Executor_CompletionService_ReportGeneratorProcessor
 *  Created on: May 13, 2013
 * 
 *  Description: separate the launching of tasks and the processing of results in an executor
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class ReportGenerator implements Callable<String> {
	private String sender;
	private String title;
	
	public ReportGenerator(String sender, String title) {
		this.sender = sender;
		this.title = title;
	}
	
	public String call() throws Exception {
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", 
					this.sender, this.title, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String ret = sender + ": " + title;
		return ret;
	}
}
