/*
 * File: MyScheduledThreadPoolExecutor.java
 * Package: 
 * Project: thread-Customize-ScheduledThreadPoolExecutor
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

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * ScheduledThreadPoolExecutor class permits the execution of the following two kinds of tasks:
 * Delayed tasks: These kinds of tasks are executed only once after a period of time
 * Periodic tasks: These kinds of tasks are executed after a delay and then periodically every so often
 */
public class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
	public MyScheduledThreadPoolExecutor(int corePoolSize) {
		super(corePoolSize);
	}
	
	//modify or replace the task used to execute a runnable
	@Override
	protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
		MyScheduledTask<V> myTask = new MyScheduledTask<V>(runnable, null, task, this);
		return myTask;
	}
	
	//create and execute a periodic action that becomes enabled first after the given initial delay, and subsequently with 
	//the given period.
	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		ScheduledFuture<?> task = super.scheduleAtFixedRate(command, initialDelay, period, unit);
		MyScheduledTask<?> myTask = (MyScheduledTask<?>)task;
		myTask.setPeriod(TimeUnit.MILLISECONDS.convert(period, unit));
		return task;
	}
}
