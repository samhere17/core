package org.iq.logger.handler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Handler;

import org.iq.logger.LocalLogger;

/**
 * @author Sam
 * 
 */
public class HandlerFactory {

	/**
	 * @param handlerClassName
	 * @param argumentsMap
	 * @return Handler
	 */
	public static Handler getHandler(String handlerClassName,
			Map<String, String> argumentsMap) {
		Handler handler = null;
		try {
			Class<?> classDefinition = Class.forName(handlerClassName);
			Constructor<?> constructor = classDefinition
					.getConstructor(Map.class);
			handler = (Handler) constructor.newInstance(argumentsMap);
		} catch (ClassNotFoundException e) {
			LocalLogger.logSevere(e);
		} catch (SecurityException e) {
			LocalLogger.logSevere(e);
		} catch (NoSuchMethodException e) {
			LocalLogger.logSevere(e);
		} catch (IllegalArgumentException e) {
			LocalLogger.logSevere(e);
		} catch (InstantiationException e) {
			LocalLogger.logSevere(e);
		} catch (IllegalAccessException e) {
			LocalLogger.logSevere(e);
		} catch (InvocationTargetException e) {
			LocalLogger.logSevere(e);
		}
		return handler;
	}
}