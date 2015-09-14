/*
 * File: TestAtomicVariable.java
 * Package: 
 * Project: thread-Collection-AtomicVariable
 * Created on: Aug 11, 2013
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
 * TODO
 */
public class TestAtomicVariable {
	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000);
		
		Company company = new Company(account);
		Thread companyThread = new Thread(company);
		
		Bank bank = new Bank(account);
		Thread bankThread = new Thread(bank);
		
		System.out.printf("Account: initial balance: $%d\n", account.getBalance());
		
		companyThread.start();
		bankThread.start();
		
		try {
			companyThread.join();
			bankThread.join();
			System.out.printf("Account: final balance: $%d\n", account.getBalance());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
