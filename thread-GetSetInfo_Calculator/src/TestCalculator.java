import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//get and set thread information
public class TestCalculator {

	private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
		pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ************************************\n");
		pw.flush();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		
		for (int i = 0; i < 10; i++) {
			//Calculator calculator = new Calculator(i);
			//Thread thread = new Thread(calculator);
			//thread.start();
			
			//AnotherCalculator cal = new AnotherCalculator(i);
			//cal.start();
			
			threads[i] = new Thread(new Calculator(i));
			if(i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " + i);
		}
		
		FileWriter file = new FileWriter("./data/log.txt");
		PrintWriter pw = new PrintWriter(file);
		
		for (int i = 0; i < 10; i++) {
			pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
			//flush the stream, otherwise data are not written to the file.
			pw.flush();
			status[i] = threads[i].getState(); //initial state
		}
		
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}

		boolean finish=false;
		
		while (!finish) {
			for (int i = 0; i < 10; i++){
				//Does thread status change?
				if (threads[i].getState() != status[i]) {
					writeThreadInfo(pw, threads[i], status[i]);
					status[i] = threads[i].getState();
				}
			}
			finish=true;
			for (int i = 0; i < 10; i++){
				finish = finish &&(threads[i].getState() == Thread.State.TERMINATED);
			}
		}
		
		System.out.println("All threads are finished? " + finish);
		
		pw.close();
		file.close();
	}
}
