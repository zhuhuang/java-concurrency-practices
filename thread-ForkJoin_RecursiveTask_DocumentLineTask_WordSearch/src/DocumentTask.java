import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 *  File: DocumentTask.java
 *  Package: 
 *  Project: thread-ForkJoin_RecursiveTask_WordSearch
 *  Created on: May 14, 2013
 * 
 *  Description: joining the results of tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class DocumentTask extends RecursiveTask<Integer> {
	private String document[][];
	private int start, end;
	private String word;
	
	public DocumentTask(String document[][], int start, int end, String word) {
		this.document = document;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	
	//RecursiveTask.compute() has something to return. different from RecursiveAction.compute()
	@Override
	protected Integer compute() {
		Integer result = null;
		if (end - start < 10) {
			result = processLines(document, start, end, word);
		} else {
			int mid = (start + end) / 2;
			DocumentTask t1 = new DocumentTask(document, start, mid, word);
			DocumentTask t2 = new DocumentTask(document, mid, end, word);
			
			//recursive calls. synchronous call. waits until all subtasks complete.
			invokeAll(t1, t2);
			
			try {
				result = groupResults(t1.get(), t2.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//split a document task into multiple line tasks
	private Integer processLines(String[][] document, int start, int end, String word) {
		List<LineTask> tasks = new ArrayList<LineTask>();
		for (int i = start; i < end; i++) {
			LineTask task = new LineTask(document[i], 0, document[i].length, word);
			tasks.add(task);
		}
		
		invokeAll(tasks);
		
		int result = 0;
		for (int i = 0; i < tasks.size(); i++) {
			LineTask task = tasks.get(i);
			try {
				result = result + task.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		return new Integer(result);
	}
	
	private Integer groupResults(Integer n1, Integer n2) {
		Integer result;
		result = n1 + n2;
		return result;
	}
}
