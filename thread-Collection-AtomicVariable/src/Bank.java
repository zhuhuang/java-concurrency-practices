import java.util.concurrent.TimeUnit;

/*
 * File: Bank.java
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
public class Bank implements Runnable {
	private Account account;
	
	public Bank(Account account) {
		this.account = account;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			account.subtractAmount(1000);
			System.out.printf("Account: balance after subtracting amount $1000: $%d\n", account.getBalance());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
