/**
 *  File: Event.java
 *  Package: 
 *  Project: thread-Event
 *  Created on: Feb 24, 2013
 * 
 *  Description: Create and Run a Daemon Thread
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.Date;

public class Event {
	private Date date;
	String event;
	
	public Date getDate() {
		return this.date;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
}
