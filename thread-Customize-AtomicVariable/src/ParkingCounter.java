import java.util.concurrent.atomic.AtomicInteger;

/*
 * File: ParkingCounter.java
 * Package: 
 * Project: thread-Customize-AtomicVariable
 * Created on: Aug 17, 2013
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
public class ParkingCounter extends AtomicInteger {
	private int maxNumber;
	
	public ParkingCounter(int maxNumber) {
		set(0);
		this.maxNumber = maxNumber;
	}
	
	public boolean carIn() {
		for(;;) {
			int value = get();
			if (value == maxNumber) {
				System.out.printf("ParkingCounter: The parking lot is full.\n");
				return false;
			} else {
				int newValue = value + 1;
				boolean changed = compareAndSet(value, newValue);
				if (changed) { //what if changed is false
					System.out.printf("ParkingCounter: A car has entered.\n");
					return true;
				}/* else { 
					return false;
				}*/
			}
		}
	}
	
	public boolean carOut() {
		for(;;) {
			int value = get();
			if (value == 0) {
				System.out.printf("ParkingCounter: The parking lot is empty.\n");
				return false;
			} else {
				int newValue = value - 1;
				boolean changed = compareAndSet(value, newValue);
				if (changed) { //what if changed is false
					System.out.printf("ParkingCounter: A car has gone out.\n");
					return true;
				}/* else { 
					return false;
				}*/
			}
		}
	}
}
