package org.iq.logger;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.iq.config.LoggerConfig;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public abstract class Logger {
	
	public static void main(String[] args) {
		final File f = new File(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.println(f.getName());
		System.out.println(f.getAbsolutePath());
	}

//	private static Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();

	private String name = null;
//	private LoggerConfig loggerConf = null;
	
	private java.util.logging.Logger parentLogger = null;
//	private boolean parentLoggerConfigured = false;
	
	private LoggerThread loggerThread = null;
	private Thread runner = null;
	private volatile boolean runnerFlag = false;
	
	private Queue<LogRecord> logQueue = null;


	private transient boolean needToInferCaller = true;
	private String sourceClassName = null;
	private String sourceMethodName = null;


	/**
	 * @param loggerName
	 * @param loggerHome
	 */
	protected Logger(LoggerConfig loggerConfig) {
//		LocalLogger.logInfo("Logger: " + loggerName + ", Initialization : " + " START");
		this.name = loggerConfig.getLoggerName();

//		LocalLogger.logDebug("Logger: " + this.name + ", Configuration: " + " START");
//		this.loggerConf = new LoggerConfig(this.name);
//		LocalLogger.logDebug("Logger: " + this.name + ", Configuration: " + " COMPLETE");

//		LocalLogger.logDebug("Logger: " + this.name + ", Parent Logger: " + " START");
		this.parentLogger = java.util.logging.Logger.getLogger(this.name);
		this.parentLogger.setLevel(Level.ALL);
//		LocalLogger.logDebug("Logger: " + this.name + ", Parent Logger: " + " COMPLETE");

		resetHandlers(loggerConfig);
//		attachHandlers(this.loggerConf.getHandlerNames());

//		LocalLogger.logDebug("Logger: " + this.name + ", Queue: " + " START");
		this.logQueue = new LinkedList<LogRecord>();
//		LocalLogger.logDebug("Logger: " + this.name + ", Queue: " + " COMPLETE");

//		LocalLogger.logDebug("Logger: " + this.name + ", Thread: " + " START");
		this.loggerThread = new LoggerThread();
//		this.runner = new Thread(loggerThread, this.name + " Logger Thread");
		this.startLoggerThread();
//		LocalLogger.logDebug("Logger: " + this.name + ", Thread: " + " COMPLETE");

//		LocalLogger.logInfo("Logger: " + this.name + ", Initialization : " + " COMPLETE");
	}
	
	private void resetHandlers(LoggerConfig loggerConfig) {
		// removing handlers
		Handler[] handlers = this.parentLogger.getHandlers();
		for (Handler handler : handlers) {
			this.parentLogger.removeHandler(handler);
			Handler[] parentsHandlers = this.parentLogger.getParent()
					.getHandlers();
			for (Handler parentsHandler : parentsHandlers) {
				this.parentLogger.getParent().removeHandler(parentsHandler);
			}
		}

		// attaching configured handlers
		for (Handler handler : loggerConfig.getLogHandlers()) {
			this.parentLogger.addHandler(handler);
		}
	}

	/**
	 * @param appName
	 * @return Logger
	 * @throws LoggerException
	 */
/*	public static Logger getLogger(String loggerName) {
		LocalLogger.logInfo("Getting Logger: " + loggerName);
		if (loggers.get(loggerName) == null) {
			Logger logger = new Logger(loggerName);
			loggers.put(loggerName, logger);
		}
		return loggers.get(loggerName);
	}*/

	/**
	 * @param message
	 */
	public void logFinest(String message) {
		postLog(buildLogRecord(Level.FINEST, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted FINEST log.");
	}

	/**
	 * @param message
	 */
	public void logFiner(String message) {
		postLog(buildLogRecord(Level.FINER, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted FINER log.");
	}

	/**
	 * @param message
	 */
	public void logFine(String message) {
		postLog(buildLogRecord(Level.FINE, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted FINE log.");
	}

	/**
	 * @param message
	 */
	public void logConfig(String message) {
		postLog(buildLogRecord(Level.CONFIG, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted CONFIG log.");
	}

	/**
	 * @param message
	 */
	public void logInfo(String message) {
		postLog(buildLogRecord(Level.INFO, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted INFO log.");
	}

	/**
	 * @param message
	 */
	public void logWarning(String message) {
		postLog(buildLogRecord(Level.WARNING, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted WARNING log.");
	}

	/**
	 * @param message
	 */
	public void logSevere(String message) {
		postLog(buildLogRecord(Level.SEVERE, message));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted SEVERE log.");
	}
	
	/**
	 * @param message
	 */
	public void logSevere(Throwable throwable) {
		postLog(buildLogRecord(Level.SEVERE, throwable));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted SEVERE log.");
	}
	
	/**
	 * @param message
	 */
	public void logSevere(String message,Throwable throwable) {
		postLog(buildLogRecord(Level.SEVERE, message,throwable));
//		LocalLogger.logDebug("Logger: " + this.name + ", Posted SEVERE log.");
	}
	
	/**
	 * 
	 */
	private void startLoggerThread() {
		runnerFlag = true;
		runner.start();
//		LocalLogger.logDebug("Logger: " + this.name + ", Thread: " + runner.getName() + " started.");
	}

	/**
	 * 
	 */
	private void stopLoggerThread() {
		runnerFlag = false;
//		LocalLogger.logDebug("Logger: " + this.name + ", Thread: " + runner.getName() + " stop requested.");
	}
	
	/**
	 * @param logRecord
	 */
	private void postLog(LogRecord logRecord) {
		logQueue.add(logRecord);
//		LocalLogger.logDebug("Logger: " + this.name + ", Log added to queue.");
	}

	/**
	 * @param level
	 * @param message
	 * @return LogRecord
	 */
	private LogRecord buildLogRecord(Level level, String message) {
		return buildLogRecord(level, message, null);
	}
	
	private LogRecord buildLogRecord(Level level, Throwable throwable) {
		return buildLogRecord(level, null, throwable);
	}

	private LogRecord buildLogRecord(Level level, String message, Throwable throwable) {
//		LocalLogger.logDebug("Logger: " + this.name + ", Building log record...");
		
		if (StringUtil.isEmpty(message)) {
			message = throwable == null ? null : throwable.getMessage();
		}

		LogRecord logRecord = new LogRecord(level, message);
		logRecord.setLoggerName(name);
		logRecord.setMillis(System.currentTimeMillis());
		logRecord.setThrown(throwable);
		logRecord.setParameters(new Object[] { Thread.currentThread().getName() });
		logRecord.setSourceClassName(getSourceClassName());
		logRecord.setSourceMethodName(getSourceMethodName());

//		LocalLogger.logDebug("Logger: " + this.name + ", Log record built.");
		return logRecord;
	}



	// Private method to infer the caller's class and method names
	private void inferCaller() {
		needToInferCaller = false;
		// Get the stack trace.
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		// First, search back to a method in the Logger class.
		int ix = 0;
		while (ix < stack.length) {
			StackTraceElement frame = stack[ix];
			String cname = frame.getClassName();
			if (cname.equals(this.getClass().getName())) {
				break;
			}
			ix++;
		}
		// Now search for the first frame before the "Logger" class.
		while (ix < stack.length) {
			StackTraceElement frame = stack[ix];
			String cname = frame.getClassName();
			if (!cname.equals(this.getClass().getName())) {
				// We've found the relevant frame.
				setSourceClassName(cname);
				setSourceMethodName(frame.getMethodName());
				return;
			}
			ix++;
		}
		// We haven't found a suitable frame, so just punt. This is
		// OK as we are only committed to making a "best effort" here.
	}

	/**
	 * Get the name of the class that (allegedly) issued the logging request.
	 * <p>
	 * Note that this sourceClassName is not verified and may be spoofed. This
	 * information may either have been provided as part of the logging call, or
	 * it may have been inferred automatically by the logging framework. In the
	 * latter case, the information may only be approximate and may in fact
	 * describe an earlier call on the stack frame.
	 * <p>
	 * May be null if no information could be obtained.
	 * 
	 * @return the source class name
	 */
	private String getSourceClassName() {
		if (needToInferCaller) {
			inferCaller();
		}
		return sourceClassName;
	}

	/**
	 * Set the name of the class that (allegedly) issued the logging request.
	 * 
	 * @param sourceClassName
	 *            the source class name (may be null)
	 */
	private void setSourceClassName(String sourceClassName) {
		this.sourceClassName = sourceClassName;
		needToInferCaller = false;
	}

	/**
	 * Get the name of the method that (allegedly) issued the logging request.
	 * <p>
	 * Note that this sourceMethodName is not verified and may be spoofed. This
	 * information may either have been provided as part of the logging call, or
	 * it may have been inferred automatically by the logging framework. In the
	 * latter case, the information may only be approximate and may in fact
	 * describe an earlier call on the stack frame.
	 * <p>
	 * May be null if no information could be obtained.
	 * 
	 * @return the source method name
	 */
	private String getSourceMethodName() {
		if (needToInferCaller) {
			inferCaller();
		}
		return sourceMethodName;
	}

	/**
	 * Set the name of the method that (allegedly) issued the logging request.
	 * 
	 * @param sourceMethodName
	 *            the source method name (may be null)
	 */
	private void setSourceMethodName(String sourceMethodName) {
		this.sourceMethodName = sourceMethodName;
		needToInferCaller = false;
	}
	
	/**
	 * Class to process log messages on a thread.
	 * 
	 * @author Sam
	 */
	public class LoggerThread implements Runnable {

		//  private static final float DEFAULT_WATCH_INTERVAL = 0.0333333333333333333333333333333333333333333333333f;
		private static final float DEFAULT_NO_LOG_MSG_SLEEP_INTERVAL = 0.05f;
		private static final int MINUTE_TO_MILLIS = 1000 * 60;

		private int count = 0;

		/**
		 * Constructor.
		 */
		public LoggerThread() {
			
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		public void run() {
			while (runnerFlag == true) {
//				LocalLogger.logDebug("LoggerThread running now...");
				System.out.println("LoggerThread running now...");

				while (true) {
					if (logQueue.peek() != null) {
						count = 0;

						LogRecord logRecord = logQueue.poll();
						System.out.println("Class: "+logRecord.getSourceClassName()+" Method: "+logRecord.getSourceMethodName()+" logging msg from thread = " + logRecord.getMessage());
						logNow(logRecord);

//						logNow(logQueue.poll());
					}
					else {
//						LocalLogger.logDebug("No log message found...");
						count++;
						break;
					}
				}

				if (count > 5) {
					long sleepTime = 0;
					sleepTime = (long) (DEFAULT_NO_LOG_MSG_SLEEP_INTERVAL * MINUTE_TO_MILLIS);
//					LocalLogger.logDebug("LoggerThread Sleeping now for " + DEFAULT_NO_LOG_MSG_SLEEP_INTERVAL + " minutes...");
					System.out.println("LoggerThread Sleeping now for "
							+ ((float) sleepTime / MINUTE_TO_MILLIS)
							+ " minutes...");
					try {
						Thread.sleep(sleepTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
//			LocalLogger.logInfo("Exiting LoggerThread.");
		}
	}

	  /**
	   * 
	   */
	private void logNow(LogRecord logRecord) {
		parentLogger.log(logRecord);
	}

}