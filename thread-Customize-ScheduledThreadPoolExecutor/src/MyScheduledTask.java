/*
 * File: MyScheduledTask.java
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

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Use to decorate a RunnableScheduledFuture<V> task
 * RunnableScheduledFuture: a ScheduledFuture that is Runnable. 
 * Successful execution of the run method causes completion of the Future and allows access to its result.
 */
public class MyScheduledTask<V> extends FutureTask<V> implements RunnableScheduledFuture<V> {
	private RunnableScheduledFuture<V> task;
	private ScheduledThreadPoolExecutor executor;
	private long period;
	private long startDate;
	
	public MyScheduledTask(Runnable runnable, V result, RunnableScheduledFuture<V> task, ScheduledThreadPoolExecutor executor) {
		super(runnable, result); 
		this.task = task;
		this.executor = executor;
	}
	
	public long getDelay(TimeUnit unit) {
		if (!isPeriodic()) {
			return task.getDelay(unit);
		} else {
			if (startDate == 0) {
				return task.getDelay(unit);
			} else {
				Date now = new Date();
				long delay = startDate - now.getTime();
				return unit.convert(delay, TimeUnit.MILLISECONDS);
			}
		}
	}
	
	public int compareTo(Delayed o) {
		return task.compareTo(o);
	}
	
	public boolean isPeriodic() {
		return task.isPeriodic();
	}
	
	public void run() {
		if (isPeriodic() && (!executor.isShutdown())) {
			Date now = new Date();
			startDate = now.getTime() + period; //periodic task: update startDate of next execution
			executor.getQueue().add(this);
		}
		System.out.printf("Pre-MyScheduledTask: %s\n", new Date());
		System.out.printf("MyScheduledTask: Is Periodic: %s\n", isPeriodic());
		super.runAndReset();
		System.out.printf("Post-MyScheduledTask: %s\n", new Date());
	}
	
	public void setPeriod(long period) {
		this.period = period;
	}
}
