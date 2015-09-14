import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestFolderProcessor.java
 *  Package: 
 *  Project: thread-ForkJoin_RecursiveTask_Asynchronous_FolderProcessor
 *  Created on: May 14, 2013
 * 
 *  Description: running tasks asynchronously
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TestFolderProcessor {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		
		FolderProcessor workspace = new FolderProcessor("/home/zhuhuang/Workspace", "log");
		FolderProcessor dropbox = new FolderProcessor("/home/zhuhuang/Dropbox/Workspace", "log");
		FolderProcessor curriculum = new FolderProcessor("/home/zhuhuang/Curriculum", "log");
		
		pool.execute(workspace);
		pool.execute(dropbox);
		pool.execute(curriculum);
		
		do {
			System.out.printf("\n**************************************\n");
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
			System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while ((!workspace.isDone()) || (!dropbox.isDone()) || (!curriculum.isDone()));
		
		pool.shutdown();
		
		List<String> results;
		
		results = workspace.join();
		System.out.printf("Workspace: %d files found.\n", results.size());
		results = dropbox.join();
		System.out.printf("Dropbox: %d files found.\n", results.size());
		results = curriculum.join();
		System.out.printf("Curriculum: %d files found.\n", results.size());
	}

}
