/*
 * File: TestParkingCounter.java
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
public class TestParkingCounter {

	public static void main(String[] args) {
		ParkingCounter counter = new ParkingCounter(5);
		SensorOne sensor1 = new SensorOne(counter);
		SensorTwo sensor2 = new SensorTwo(counter);
		
		Thread thread1 = new Thread(sensor1);
		Thread thread2 = new Thread(sensor2);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: Number of cars: %d\n", counter.get());
		System.out.printf("Main: End of the program.\n");
	}

}
