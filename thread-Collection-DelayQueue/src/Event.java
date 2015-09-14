/*
 * File: Event.java
 * Package: 
 * Project: thread-Collection-DelayedQueue
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

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Interface Delayed
 */
public class Event implements Delayed {
	private Date startDate; //the activation time
	
	public Event(Date startDate) {
		this.startDate = startDate;
	}
	
	//compare two Delayed objects
	public int compareTo(Delayed other) {
		long result = this.getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS);
		if(result < 0) {
			return -1;
		} else if (result > 0) {
			return 1;
		} else 
			return 0;
	}
	
	//return the time remaining until the activation date in the units specified by the unit parameter
	public long getDelay(TimeUnit unit) {
		Date now = new Date();
		long diff = startDate.getTime() - now.getTime(); //milliseconds
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}
}
