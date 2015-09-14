import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestReportGeneratorProcessor.java
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

public class TestReportGeneratorProcessor {

	public static void main(String[] args) {
		//previous examples submit tasks using executor and use Future objects returned to process results
		ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
		
		//interface: CompletionService
		//class: ExecutorCompletionService
		CompletionService<String> service = new ExecutorCompletionService<String>(executor);
		
		ReportRequest faceRequest = new ReportRequest("Face", service);
		ReportRequest onlineRequest = new ReportRequest("Online", service);
		Thread faceThread = new Thread(faceRequest);
		Thread onlineThread = new Thread(onlineRequest);
		
		ReportProcessor processor = new ReportProcessor(service);
		Thread processorThread = new Thread(processor);
		
		System.out.printf("Main: Starting the Threads\n");
		faceThread.start(); // connected with executor
		onlineThread.start(); // connected with executor
		
		processorThread.start(); // unconnected with executor
		
		try {
			System.out.printf("Main: Waiting for the report generators\n");
			faceThread.join();
			onlineThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Shutting down the executor\n");
		//faceThread and onlineThread submit ReportGenerator tasks through executor
		executor.shutdown(); 
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		processor.setEnd(true);
		System.out.printf("Main: Ends");
	}

}
