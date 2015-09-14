import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * File: MyLogger.java
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
 * A Logger object is used to log messages for a specific system or application component.
 */
public class MyLogger {
	private static Handler handler;
	
	public static Logger getLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setLevel(Level.ALL);
		try {
			if (handler == null) {
				handler = new FileHandler("recipe8.log");
				Formatter format = new MyFormatter();
				handler.setFormatter(format);
			}
			if (logger.getHandlers().length == 0) {
				logger.addHandler(handler);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logger;
	}
}
