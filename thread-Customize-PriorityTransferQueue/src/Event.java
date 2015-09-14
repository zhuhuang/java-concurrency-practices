/*
 * File: Event.java
 * Package: 
 * Project: thread-Customize-PriorityTransferQueue
 * Created on: Aug 16, 2013
 *
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 *
 * Description: TODO
 * Compilation: TODO
 *
 */

/**
 * Event: to be used in PriorityBlockingQueue
 */
public class Event implements Comparable<Event> {
	private String thread;
	private int priority;
	
	public Event(String thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}
	
	public String getThread() {
		return thread;
	}
	
	public int getPriority() {
		return priority;
	}
	
	/*
	 * Return -1 if the actual event has a bigger priority than the parameter, 1 if the actual event has a lower priority than 
	 * the parameter, and 0 if both events have the same priority. You will get the list ordered by priority in the descending 
	 * order. Events with higher priority will be stored first in the queue.
	 */
	public int compareTo(Event e) {
		//The larger number, the higher priority
		//For PriorityBlockingQueue, the least element will be placed in the beginning.
		//Thus in order to get highest prioritized event, return -1 is current event has higher priority
		if (this.priority > e.getPriority()) {
			return -1;
		} else if (this.priority < e.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}
}
