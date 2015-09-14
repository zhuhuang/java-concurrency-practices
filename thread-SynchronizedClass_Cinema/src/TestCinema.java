/**
 *  File: TestCinema.java
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

public class TestCinema {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOfficeOne ticoff1 = new TicketOfficeOne(cinema, "Manhattan Ticket Office");
		Thread thread1 = new Thread(ticoff1, "TicketOfficeOne");
		TicketOfficeTwo ticoff2 = new TicketOfficeTwo(cinema, "Lawrence Ticket Office");
		Thread thread2 = new Thread(ticoff2, "TicketOfficeTwo");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Cinema 1 Vacancies: %d\n", 
				cinema.getVacancyCinema1());
		System.out.printf("Cinema 2 Vacancies: %d\n", 
				cinema.getVacancyCinema2());
	}

}
