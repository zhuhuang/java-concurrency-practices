/**
 *  File: FileMock.java
 *  Package: 
 *  Project: thread-ConditionProducerConsumer
 *  Created on: Feb 27, 2013
 * 
 *  Description: use multiple conditions in a Lock
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

//simulate a text file
public class FileMock {
	private String[] content; 
	private int index;
	
	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			//to hold contents of one line
			StringBuilder buffer = new StringBuilder(length);
			
			//build each line
			for (int j=0; j<length; j++) {
				//character is a single 16bit Unicode character
				//byte is 8 bit, unsigned ranges 0~255
				int indice = (int) Math.random() * 255;
				buffer.append((char)indice);
			}
			content[i] = buffer.toString();
		}
	}
	
	public boolean hasMoreLines() {
		return index < content.length;
	}
	
	public String getLine() {
		if (this.hasMoreLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}
}
