/**
 *  File: Reader.java
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

public class Reader implements Runnable {
	private PriceInfo priceInfo;
	
	public Reader(PriceInfo pi) {
		this.priceInfo = pi;
	}
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s: Price 1: %f\n", 
					Thread.currentThread().getName(), priceInfo.getPrice1());
			System.out.printf("%s: Price 2: %f\n", 
					Thread.currentThread().getName(), priceInfo.getPrice2());
		}
	}
}
