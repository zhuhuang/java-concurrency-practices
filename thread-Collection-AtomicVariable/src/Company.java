import java.util.concurrent.TimeUnit;

/*
 * File: Company.java
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
public class Company implements Runnable {
	private Account account;
	
	public Company(Account account) {
		this.account = account;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			account.addAmount(1000);
			System.out.printf("Account: balance after adding amount $1000: $%d\n", account.getBalance());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
