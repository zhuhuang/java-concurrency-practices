/**
 *  File: Cinema.java
 *  Package: 
 *  Project: thread-Cinema
 *  Created on: Feb 26, 2013
 * 
 *  Description: Arrange independent attributes in synchronized classes
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */
/*
In this example, we have an object that controls access to the
vacanciesCinema1 attribute, so only one thread can modify
this attribute each time, and another object controls access to the
vacanciesCinema2 attribute, so only one thread can modify
this attribute each time. But there may be two threads running
simultaneously, one modifying the vacancesCinema1 attribute and
the other one modifying the vacanciesCinema2 attribute.
 */
public class Cinema {
	private long vacancyCinema1;
	private long vacancyCinema2;
	private final Object controlCinema1, controlCinema2;
	
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacancyCinema1 = 20;
		vacancyCinema2 = 20;
	}
	
	public boolean sellTickets1(int number, String office) {
		synchronized(controlCinema1) {
			if (number < vacancyCinema1) {
				vacancyCinema1 -= number;
				System.out.printf("Sold %d Tickets by %s for Cinema 1\n", 
						number, office);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean sellTickets2(int number, String office) {
		synchronized(controlCinema2) {
			if (number < vacancyCinema2) {
				vacancyCinema2 -= number;
				System.out.printf("Sold %d Tickets by %s for Cinema 2\n", 
						number, office);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean returnTickets1(int number, String office) {
		synchronized(controlCinema1) {
			vacancyCinema1 += number;
			System.out.printf("Returned %d Tickets by %s for Cinema 1\n", 
					number, office);
			return true;
		}
	}
	
	public boolean returnTickets2(int number, String office) {
		synchronized(controlCinema2) {
			vacancyCinema2 += number;
			System.out.printf("Returned %d Tickets by %s for Cinema 2\n", 
					number, office);
			return true;
		}
	}
	
	public long getVacancyCinema1() {
		return this.vacancyCinema1;
	}
	
	public long getVacancyCinema2() {
		return this.vacancyCinema2;
	}
}
