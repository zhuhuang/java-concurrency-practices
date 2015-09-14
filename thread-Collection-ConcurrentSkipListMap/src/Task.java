/*
 * File: Task.java
 * Package: 
 * Project: thread-Collection-ConcurrentSkipListMap
 * Created on: Aug 11, 2013
 *
 *
 * @author Huang Zhu
 * @email zhuhuang.ksu@gmail.com
 *
 *
 * Description: TODO
 * Compilation: TODO
 *
 */

import java.util.concurrent.ConcurrentSkipListMap;
/**
 * A Skip List is a data structure based on parallel lists that allows us to get efficiency similar to
 * a binary tree. With it, you can get a sorted data structure with a better access time to insert,
 * search, or delete elements than a sorted list.
 */
public class Task implements Runnable {
	private String id;
	private ConcurrentSkipListMap<String, Contact> map;
	
	public Task(String id, ConcurrentSkipListMap<String, Contact> map) {
		this.id = id;
		this.map = map;
	}
	
	public void run() {
		for(int i = 0; i < 1000; i++) {
			Contact contact = new Contact(id, String.valueOf(i + 1000));
			map.put(id + contact.getPhone(), contact);
		}
		System.out.printf("%s added 1000 entries to the map. Current map size: %d.\n", 
				Thread.currentThread().getName(), map.size());
	}
}
