package org.iq.logger.formatter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Formatter;

/**
 * @author Sam
 * 
 */
public class FormatterFactory {

	/**
	 * @return
	 */
	public static Formatter getFormatter(String formatterClassName) {
		Formatter formatter = null;
		try {
			Class<?> classDefinition = Class.forName(formatterClassName);
			formatter = (Formatter) classDefinition.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO
		} catch (InstantiationException e) {
			// TODO
		} catch (IllegalAccessException e) {
			// TODO
		}
		return formatter;
	}

	public static Formatter getFormatter(String formatterClassName,
			String formatterPattern) {
		Formatter formatter = null;
		try {
			Class<?> classDefinition = Class.forName(formatterClassName);
			Constructor<?> constructor = classDefinition
					.getConstructor(String.class);
			formatter = (Formatter) constructor.newInstance(formatterPattern);
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
		return formatter;
	}
}