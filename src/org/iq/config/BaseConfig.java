package org.iq.config;

import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.iq.exception.ConfigException;

public abstract class BaseConfig implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4396100330724727796L;

	private static final String CONFIG_DIR = "conf/";
	private static final String CONF_EXT = "properties";

	protected InputStream confInputStream = null;

	protected BaseConfig(String confName) throws ConfigException {
		String confResPath = CONFIG_DIR + confName + "." + BaseConfig.CONF_EXT;
		confInputStream = getClass().getClassLoader().getResourceAsStream(
				confResPath);

		try {
			Class<?> handlerClass = Class.forName(this.getClass().getName()
					+ "$" + this.getClass().getSimpleName() + "Handler");
			Constructor<?> constructor = handlerClass.getConstructor(this
					.getClass());
			Method method = handlerClass.getMethod("getObject");
			method.invoke(constructor.newInstance(this));
		} catch (ClassNotFoundException e) {
			throw new ConfigException(e);
		} catch (SecurityException e) {
			throw new ConfigException(e);
		} catch (InstantiationException e) {
			throw new ConfigException(e);
		} catch (IllegalAccessException e) {
			throw new ConfigException(e);
		} catch (NoSuchMethodException e) {
			throw new ConfigException(e);
		} catch (IllegalArgumentException e) {
			throw new ConfigException(e);
		} catch (InvocationTargetException e) {
			throw new ConfigException(e);
		}
	}
}