import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 *  File: FolderProcessor.java
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

public class FolderProcessor extends RecursiveTask<List<String>> {
	private static final long serialVersionUID = 1L;
	private String path;
	private String extension;
	
	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}
	
	@Override
	protected List<String> compute() {
		List<String> list = new ArrayList<String>();
		List<FolderProcessor> tasks =  new ArrayList<FolderProcessor>();
		
		File file = new File(path);
		File[] content = file.listFiles();
		
		if (content != null) {
			for (int i = 0; i < content.length; i++) {
				if (content[i].isDirectory()) {
					//a directory
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), extension);
					
					// ForkJoinTask.join(): Arranges to asynchronously execute this task
					task.fork(); // not invokeAll() here, which is synchronous
					tasks.add(task);
				} else {
					// a file
					if (checkFile(content[i].getName())) {
						list.add(content[i].getAbsolutePath());
					}
				}
			}
			
			if (tasks.size() > 50) {
				System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
			}
			
			addResultsFromTasks(list, tasks);
		}
		
		return list;
	}
	
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}
	
	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
		for (FolderProcessor item : tasks) {
			// ForkJoinTask.join(): Returns the result of the computation when it is done.
			// or get()
			// join() can't be interrupted, but get() can
			list.addAll(item.join());
		}
	}
}
