import java.util.ArrayList;
import java.util.List;

/**
 *  File: ProductListGenerator.java
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

public class ProductListGenerator {
	public List<Product> generate(int size) {
		List<Product> list = new ArrayList<Product>();
		
		for (int i = 0; i < size; i++) {
			Product product = new Product();
			product.setName("Product" + i);
			//product.setPrice(Math.random() * 100);
			product.setPrice(10);
			list.add(product);
		}
		
		return list;
	}
}
