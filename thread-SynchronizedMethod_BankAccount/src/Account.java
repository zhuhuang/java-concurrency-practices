/**
 *  File: Account.java
 *  Package: 
 *  Project: thread-BankAccount
 *  Created on: Feb 26, 2013
 * 
 *  Description: Synchronizing A Method
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

//synchronized(this) {
//    //critical section
//    //your code here
//}


public class Account {
	private double balance;
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//version 1
	//using version 1 doesn't seems to have consistency problem
	/*
	public void addAmount(double amount) {
		balance += amount;
	}
	*/
	
	//version 2
	//using version 2 has consistency problem
	/*
	public void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}
	*/
	
	//version 3
	//what if one thread calls addAmount, another calls subtractAmount at the same time
	//inconsistency? No. addAmount and subtractAmount won't interleave.
	public synchronized void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp += amount;
		balance = tmp;
	}	

	//version 1
	//using version 1 doesn't seems to have consistency problem
	/*
	public void subtractAmount(double amount) {
		balance -= amount;
	}
	*/
	
	//version 2
	//using version 2 has consistency problem
	/*
	public void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
	*/
	
	//version 3
	//what if one thread calls addAmount, another calls subtractAmount at the same time
	//inconsistency? No. addAmount and subtractAmount won't interleave.
	public synchronized void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tmp -= amount;
		balance = tmp;
	}
}
