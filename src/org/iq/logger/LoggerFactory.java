package org.iq.logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.iq.config.LoggerConfig;

public class LoggerFactory {

	private static Hashtable<String, Logger> loggers = new Hashtable<String, Logger>();

	/**
	 * @param loggerName
	 * @return Logger
	 */
	public static Logger getLogger(String loggerName) {
		
		if (loggers.get(loggerName) == null) {
			LoggerConfig loggerConfig = null;//new LoggerConfig(loggerName);

			Logger logger = null;
			try {
				Class<?> classDefinition = Class.forName(loggerConfig.getLoggerClassName());
				Constructor<?> constructor = classDefinition.getConstructor();
				logger = (Logger) constructor.newInstance(loggerConfig);
			} catch (ClassNotFoundException e) {
				// TODO
			} catch (InstantiationException e) {
				// TODO
			} catch (IllegalAccessException e) {
				// TODO
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
			}

			loggers.put(loggerName, logger);
		}
		
		return loggers.get(loggerName);
	}
}
