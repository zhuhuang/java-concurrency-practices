import java.util.concurrent.CompletionService;

/**
 *  File: ReportRequest.java
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

//generate reports
//send report results through CompletionService
public class ReportRequest implements Runnable {
	private String name;
	
	private CompletionService<String> service;
	
	public ReportRequest(String name, CompletionService<String> service) {
		this.name = name;
		this.service = service;
	}
	
	public void run() {
		ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
		// submit task using executor. run the generator.
		service.submit(reportGenerator);
	}
}
