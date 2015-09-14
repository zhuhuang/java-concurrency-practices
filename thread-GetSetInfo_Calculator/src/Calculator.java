//How to create a thread
//1. Extending the Thread class and overriding the run() method.
//2. Building a class that implements the Runnable interface and then creating an object 
//of the Thread class passing the Runnable object as a parameter.

//method 2
public class Calculator implements Runnable {
	private int number;
	
	public Calculator(int number) {
		this.number = number;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, number * i);
		}
	}
}
