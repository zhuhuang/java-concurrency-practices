
//Interrupt a Thread
//For simple programs
public class PrimeGenerator extends Thread {
	private boolean isPrime(long num) {
		if(num <= 2)
			return true;
		
		for(long i = 2; i < num; i++) {
			if ((num % i) == 0)
				return false;
		}
		return true;
	}
	
	@Override
	public void run() {
		long number =  1L;
		while (true) {
			if(isPrime(number))
				System.out.printf("Number %d is Prime\n", number);
			
			//check wheter the thread is interrupted
			if(isInterrupted()) {
				System.out.println("The PrimeGenerator has been interrupted!");
				return;
			}
			number++;
		}
	}

}
