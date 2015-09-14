/**
 *  File: TestReaderWriter.java
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

public class TestReaderWriter {

	public static void main(String[] args) {
		PriceInfo price = new PriceInfo();
		Reader[] readers = new Reader[5];
		Thread[] threadReaders = new Thread[5];
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(price);
			threadReaders[i] = new Thread(readers[i]);
		}
		
		Writer[] writers = new Writer[5];
		Thread[] threadWriters = new Thread[5];
		
		for (int i = 0; i < 5; i++) {
			writers[i] = new Writer(price);
			threadWriters[i] = new Thread(writers[i]);
		}
		
		for (int i = 0; i < 5; i++) {
			threadReaders[i].start();
			threadWriters[i].start();
		}
	}

}
