/*
 * File: Account.java
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

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * How Atomic Variable Works:
 * 
 * Basically, the operation gets the value of the variable, changes the value in
 * a local variable, and then tries to change the old value for the new one. If the old value is still
 * the same, it does the change. If not, the method begins the operation again. This operation is
 * called Compare and Set.
 * 
 * Atomic variables don't use locks or other synchronization mechanisms to protect the access to
 * their values. All their operations are based on the Compare and Set operation.
 * 
 */
public class Account {
	private AtomicLong balance;
	
	public Account() {
		this.balance = new AtomicLong();
	}
	
	public long getBalance() {
		return balance.get();
	}
	
	public void setBalance(long balance) {
		this.balance.set(balance);
	}
	
	public void addAmount(long amount) {
		this.balance.getAndAdd(amount);
	}
	
	public void subtractAmount(long amount) {
		this.balance.getAndAdd(-amount);
	}
}
