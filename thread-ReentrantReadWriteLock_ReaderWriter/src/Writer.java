/**
 *  File: Writer.java
 *  Package: 
 *  Project: thread-ReaderWriter
 *  Created on: Feb 27, 2013
 * 
 *  Description: synchronize data access with read/write locks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

public class Writer implements Runnable {
	private PriceInfo priceInfo;
	
	public Writer(PriceInfo pi) {
		this.priceInfo = pi;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.printf("Writer: attempt to modify prices.\n");
			priceInfo.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.printf("Writer: prices has been modified.\n");
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
