/*
 * File: SensorOne.java
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
public class SensorOne implements Runnable {
	private ParkingCounter counter;
	
	public SensorOne(ParkingCounter counter) {
		this.counter = counter;
	}
	
	public void run() {
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	}
}
