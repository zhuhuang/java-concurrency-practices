import java.util.Random;

/**
 *  File: Document.java
 *  Package: 
 *  Project: thread-ForkJoin_RecursiveTask_WordSearch
 *  Created on: May 14, 2013
 * 
 *  Description: joining the results of tasks
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 */

public class DocumentGenerator {
	private String[] words = {"the", "hello", "goodbye", "package", 
			"java", "thread", "pool", "random", "class", "main"};
	
	public String[][] generateDocument(int numLines, int numWords, String word) {
		int counter = 0;
		String document[][] = new String[numLines][numWords];
		Random random = new Random();
		for (int i = 0; i < numLines; i++) 
			for (int j = 0; j < numWords; j++) {
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if (document[i][j].equals(word)) {
					counter++;
				}
			}
		
		System.out.printf("DocumentGenerator: The word appears %d times in the document", counter);
		return document;
	}
}
