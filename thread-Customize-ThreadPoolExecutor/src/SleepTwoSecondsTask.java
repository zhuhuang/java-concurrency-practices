
/*
 * File: SleepTwoSecondsTask.java
 * Package: 
 * Project: thread-Customize-ThreadPoolExecutor
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

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 */
public class SleepTwoSecondsTask implements Callable<String> {
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		return new Date().toString();
	}
}
