/**
 *  File: Bank.java
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

public class Bank implements Runnable{
	private Account account;

	public Bank(Account account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.subtractAmount(1000);
		}
	}
}
