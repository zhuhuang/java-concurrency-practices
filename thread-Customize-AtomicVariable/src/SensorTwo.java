/*
 * File: SensorTwo.java
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
public class SensorTwo implements Runnable {
	private ParkingCounter counter;
	
	public SensorTwo(ParkingCounter counter) {
		this.counter = counter;
	}
	
	public void run() {
		counter.carIn();
		counter.carOut();
		counter.carOut();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
		counter.carIn();
	}
}
