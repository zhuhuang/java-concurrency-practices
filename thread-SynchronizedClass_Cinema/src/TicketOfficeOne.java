/**
 *  File: TicketOfficeOne.java
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

public class TicketOfficeOne implements Runnable {
	private Cinema cinema;
	private String name;
	
	public TicketOfficeOne(Cinema cinema, String name) {
		this.cinema = cinema;
		this.name = name;
	}
	
	@Override
	public void run() {
		cinema.sellTickets1(3, name);
		cinema.sellTickets1(2, name);
		cinema.sellTickets2(2, name);
		cinema.returnTickets1(3, name);
		cinema.sellTickets1(5, name);
		cinema.sellTickets2(2, name);
		cinema.sellTickets2(2, name);
		cinema.sellTickets2(2, name);
	}
}
