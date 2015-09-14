import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 *  File: TaskManager.java
 *  Package: 
 *  Project: thread-ForkJoin_CancelTask_TaskManager
 *  Created on: May 14, 2013
 * 
 *  Description: canceling a task
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class TaskManager {
	private List<ForkJoinTask<Integer>> tasks;
	
	public TaskManager() {
		tasks = new ArrayList<ForkJoinTask<Integer>>();
	}
	
	public void addTask(ForkJoinTask<Integer> task) {
		tasks.add(task);
	}
	
	//cancel tasks except cancelTask
	public void cancelTasks(ForkJoinTask<Integer> cancelTask) {
		for (ForkJoinTask<Integer> task : tasks) {
			if (task != cancelTask) {
				//cancel a task that hasn't started yet
				task.cancel(true);
				((SearchNumberTask)task).writeCancelMessage();
			}
		}
	}
}
