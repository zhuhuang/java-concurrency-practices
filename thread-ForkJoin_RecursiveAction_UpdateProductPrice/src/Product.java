/**
 *  File: Product.java
 *  Package: 
 *  Project: thread-ForkJoin_ForkJoinPool_UpdateProductPrice
 *  Created on: May 13, 2013
 * 
 *  Description: Create a Fork/Join pool
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class Product {
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
