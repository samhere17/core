package org.iq.logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.iq.config.LoggerConfig;
import org.iq.logger.formatter.TextFormatter;

/**
 * @author Sam
 * 
 */
public class LocalLogger {

	public static final String LOGGER_APP_NAME = "__iq_local_logger";
	public static final String LOG_FILE_NAME = "__iq_system_%g.log";
	private final static String LOCAL_LOGGER_FORMAT = "%d %l - %m";

	private static Logger localLogger = null;

	static {
		localLogger = Logger.getLogger(LOGGER_APP_NAME);
		localLogger.setLevel(Level.ALL);

		// Remove the default handlers
		Handler[] handlers = localLogger.getHandlers();
		for (Handler handler : handlers) {
			localLogger.removeHandler(handler);
		}
		Handler[] parentHandlers = localLogger.getParent().getHandlers();
		for (Handler handler : parentHandlers) {
			localLogger.getParent().removeHandler(handler);
		}

		try {
			Handler logHandler = new FileHandler(LoggerConfig.getLoggerHome() + File.separator + LOG_FILE_NAME);
			logHandler.setFormatter(new TextFormatter(LOCAL_LOGGER_FORMAT));
			localLogger.addHandler(logHandler);
		} catch (SecurityException e) {
			Handler handler = new ConsoleHandler();
			handler.setFormatter(new TextFormatter());
			localLogger.addHandler(handler);
		} catch (IOException e) {
			Handler handler = new ConsoleHandler();
			handler.setFormatter(new TextFormatter());
			localLogger.addHandler(handler);
		}
	}

	/**
	 * @param level
	 * @param msg
	 */
	public static void logInfo(String msg) {
		localLogger.log(Level.INFO, msg);
	}

	/**
	 * @param level
	 * @param msg
	 */
	public static void logDebug(String msg) {
		localLogger.log(Level.FINE, msg);
	}

	/**
	 * @param level
	 * @param msg
	 */
	public static void logDebug(Object object) {
		localLogger.log(Level.FINE, object == null ? null : object.toString());
	}

	/**
	 * @param level
	 * @param throwable
	 */
	public static void logSevere(Throwable throwable) {
		localLogger.log(Level.SEVERE, throwable.getMessage(), throwable);
	}

	/**
	 * 
	 */
	public static void logMethodStart() {
		localLogger.log(Level.FINE, "Start of " + getCallerMethod());
	}

	/**
	 * 
	 */
	public static void logMethodEnd() {
		localLogger.log(Level.FINE, "End of " + getCallerMethod());
	}

	// Private method to infer the caller's class and method names
	private static String getCallerMethod() {
		// Get the stack trace.
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		// First, search back to a method in the Logger class.
		int ix = 0;
		while (ix < stack.length) {
			StackTraceElement frame = stack[ix];
			String cname = frame.getClassName();
			if (cname.equals(LocalLogger.class.getName())) {
				break;
			}
			ix++;
		}
		// Now search for the first frame before the "Logger" class.
		while (ix < stack.length) {
			StackTraceElement frame = stack[ix];
			String cname = frame.getClassName();
			if (!cname.equals(LocalLogger.class.getName())) {
				// We've found the relevant frame.
//				setSourceClassName(cname);
//				setSourceMethodName(frame.getMethodName());
				return cname+"::"+frame.getMethodName();
			}
			ix++;
		}
		// We haven't found a suitable frame, so just punt. This is
		// OK as we are only committed to making a "best effort" here.
		return null;
	}
}