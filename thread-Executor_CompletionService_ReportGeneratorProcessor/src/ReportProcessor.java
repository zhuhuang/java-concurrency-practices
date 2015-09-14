import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  File: ReportProcessor.java
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

//process reports
//get report results through CompletionService
public class ReportProcessor implements Runnable {
	
	private CompletionService<String> service;
	
	private boolean end;
	
	public ReportProcessor(CompletionService<String> service) {
		this.service = service;
		end = false;
	}
	
	public void run() {
		while (!end) {
			try {
				//poll(): Retrieves and removes the Future representing the next completed task, 
				//waiting if necessary up to the specified wait time if none are yet present.
				Future<String> result = service.poll(20, TimeUnit.SECONDS);
				
				if (result != null) {
					
					String report = result.get();
					
					System.out.printf("ReportProcessor: Report Received: %s\n", report);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} 
		}
		System.out.printf("ReportProcessor: End\n");
	}
	
	public void setEnd(boolean end) {
		this.end = end;
	}
}
