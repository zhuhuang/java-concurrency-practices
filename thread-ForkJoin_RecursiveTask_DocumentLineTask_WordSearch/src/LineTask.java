import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 *  File: LineTask.java
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

public class LineTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;
	private String line[];
	private int start, end;
	private String word;
	
	public LineTask(String[] line, int start, int end, String word) {
		this.line = line;
		this.start = start;
		this.end = end;
		this.word = word;
	}
	
	@Override
	protected Integer compute() {
		Integer result = null;
		if (end - start < 100) {
			result = count(line, start, end, word);
		} else {
			int mid = (start + end) / 2;
			LineTask t1 = new LineTask(line, start, mid, word);
			LineTask t2 = new LineTask(line, mid, end, word);
			
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
	
	private Integer count(String[] line, int start, int end, String word) {
		int counter = 0;
		for (int i = start; i < end; i++) {
			if (line[i].equals(word)) {
				counter++;
			}
		}
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return counter;
	}
	
	private Integer groupResults(Integer n1, Integer n2) {
		Integer result;
		result = n1 + n2;
		return result;
	}
}
