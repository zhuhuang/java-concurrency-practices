/*
 * File: Event.java
 * Package: 
 * Project: thread-Collection-PriorityBlockingQueue
 * Created on: Aug 10, 2013
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
 * Priority Event
 */
public class Event implements Comparable<Event> {
	private int thread;
	private int priority;
	
	public Event(int thread, int priority) {
		this.thread = thread;
		this.priority = priority;
	}
	
	public int getThread() {
		return thread;
	}
	
	public int getPriority() {
		return priority;
	}
	
	//The head of the queue is the LEAST element with respect to the specified ordering. 
	//So to put highest priority first, need to reverse the comparison.
	public int compareTo(Event e) {
		//The smaller number value has the higher priority
		//Since the least element is in the head, we should revert the original/intuitive way of comparing
		
		//Original (or Intuitive) Way
		/*if(this.priority < e.getPriority())
			return 1;
		else if (this.priority > e.getPriority())
			return -1;
		else
			return 0;*/
		
		//Real way
		//Make sure highest priority element is obtained through poll, remove, peek, and element.
		if(this.priority < e.getPriority())
			return -1;
		else if (this.priority > e.getPriority())
			return 1;
		else
			return 0;
	}

}
