/**
 *  File: TicketOfficeTwo.java
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

public class TicketOfficeTwo implements Runnable {
	private Cinema cinema;
	private String name;
	
	public TicketOfficeTwo(Cinema cinema, String name) {
		this.cinema = cinema;
		this.name = name;
	}
	
	@Override
	public void run() {
		cinema.sellTickets2(2, name);
		cinema.sellTickets2(4, name);
		cinema.sellTickets1(2, name);
		cinema.sellTickets1(1, name);
		cinema.returnTickets2(2, name);
		cinema.sellTickets1(3, name);
		cinema.sellTickets2(2, name);
		cinema.sellTickets1(2, name);
	}
}
