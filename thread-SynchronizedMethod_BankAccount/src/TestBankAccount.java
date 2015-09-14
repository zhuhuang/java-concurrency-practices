/**
 *  File: TestBankAccount.java
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

public class TestBankAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Account: Initial Balance: %f\n", account.getBalance());
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account: Final Balance: %f\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
