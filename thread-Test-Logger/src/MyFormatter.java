import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/*
 * File: MyFormatter.java
 * Package: 
 * Project: thread-Test-Logger
 * Created on: Aug 17, 2013
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

/**
 * A Formatter provides support for formatting LogRecords.
 */
public class MyFormatter extends Formatter {
	@Override
	public String format(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		sb.append("[" + record.getLevel() + "] - ");
		sb.append(new Date(record.getMillis()) + " : ");
		sb.append(record.getSourceClassName() + "." + record.getSourceMethodName() + " : ");
		sb.append(record.getMessage() + "\n");
		return sb.toString();
	}
}
