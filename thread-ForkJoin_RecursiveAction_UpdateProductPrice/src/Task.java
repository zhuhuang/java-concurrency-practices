/**
 *  File: Task.java
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


import java.util.List;
import java.util.concurrent.RecursiveAction;

//Future, Serializable -> ForkJoinTask -> RecursiveAction, RecursiveTask
public class Task extends RecursiveAction {
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private int first;
	private int last;
	private double increment;
	
	public Task(List<Product> products, int first, int last, double increment) {
		this.products = products;
		this.first = first;
		this.last = last;
		this.increment = increment;
	}
	
	@Override
	protected void compute() {
		if (last - first < 10) {
			updatePrices();
		} else {
			int middle = (first + last) / 2;
			System.out.printf("Task: Pending tasks: %s\n", getQueuedTaskCount());
			Task t1 = new Task(products, first, middle + 1, increment);
			Task t2 = new Task(products, middle + 1, last, increment);
			
			//recursive calls. synchronous call. waits until all subtasks complete.
			invokeAll(t1, t2);
		}
	}
	
	private void updatePrices() {
		for (int i = first; i < last; i++) {
			Product product = products.get(i);
			product.setPrice(product.getPrice() + (1 + increment));
		}
	}
}
