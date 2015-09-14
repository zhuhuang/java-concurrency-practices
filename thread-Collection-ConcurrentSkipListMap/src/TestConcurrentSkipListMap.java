/*
 * File: TestTask.java
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

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentSkipListMap, ConcurrentHashMap
 */
public class TestConcurrentSkipListMap {

	public static void main(String[] args) {
		ConcurrentSkipListMap<String, Contact> map;
		map = new ConcurrentSkipListMap<String, Contact>();
		
		Thread threads[] = new Thread[26];
		int counter = 0;
		
		for (char i = 'A'; i <= 'Z'; i++) {
			Task task = new Task(String.valueOf(i), map);
			threads[counter] = new Thread(task);
			threads[counter].start();
			counter++;
		}
		
		for (int i = 0; i < 25; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Main: Size of the map: %d\n", map.size());
		
		Map.Entry<String, Contact> element; //Entry in Map
		Contact contact;
		
		element = map.firstEntry(); //the entry associated with the least key
		contact = element.getValue();
		System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());
		
		element = map.lastEntry(); //the entry associated with the greatest key
		contact = element.getValue();
		System.out.printf("Main: Last Entry: %s: %s\n", contact.getName(), contact.getPhone());
		
		System.out.printf("Main: Submap from A1996 to B1002: \n");
		ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
		for(Map.Entry<String, Contact> entry : submap.entrySet()) {
			System.out.printf("%s: %s\n", entry.getValue().getName(), entry.getValue().getPhone());
		}
	}

}
