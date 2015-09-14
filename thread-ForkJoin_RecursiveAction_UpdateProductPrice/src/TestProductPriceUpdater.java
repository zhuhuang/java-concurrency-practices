import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *  File: TestProductPriceUpdater.java
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

// Executor, ExecutorService, AbstractExecutorService -> ForkJoinPool
public class TestProductPriceUpdater {

	public static void main(String[] args) {
		ProductListGenerator generator = new ProductListGenerator();
		List<Product> products = generator.generate(10000);
		
		//Three steps. So easy.
		Task task = new Task(products, 0, products.size(), 2.0);
		ForkJoinPool pool = new ForkJoinPool();
		pool.execute(task);
		
		do {
			System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
			System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
			System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
			
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		
		pool.shutdown();
		
		if (task.isCompletedNormally()) {
			System.out.printf("Main: The process has completed normally\n");
		}
		
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getPrice() != 13) {
				System.out.printf("Product %s: %f\n", product.getName(), product.getPrice());
			}
		}
		
		System.out.printf("Main: End of Program.\n");
	}

}
