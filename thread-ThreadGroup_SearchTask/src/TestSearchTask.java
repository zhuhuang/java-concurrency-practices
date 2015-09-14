/**
 *  File: TestSearchTask.java
 *  Package: 
 *  Project: thread-SearchTask
 *  Created on: Feb 24, 2013
 * 
 *  Description: Group threads into a group
 *
 *  @author: Huang Zhu
 *  Department of Computing and Information Sciences
 *  Kansas State University
 *
 */

import java.util.concurrent.TimeUnit;

/*
 * We will have 10 threads sleeping during a random period of time 
 * (simulating a search, for example) and, when one of them finishes, 
 * we are going to interrupt the rest.
 */
public class TestSearchTask {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                    TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", 
                    threads[i].getName(), threads[i].getState());
        }
        
        waitFinish(threadGroup);
        
        threadGroup.interrupt();
    }
    
    private static void waitFinish(ThreadGroup threadGroup) {
        //wait for one active thread to finish
        //interrupt others
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
