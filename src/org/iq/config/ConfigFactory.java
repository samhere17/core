package org.iq.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.iq.exception.ConfigException;

final public class ConfigFactory {

	public static BaseConfig getConfig(String configClassName) throws ConfigException {
		BaseConfig baseConfig = null;
		try {
			Class<?> configClassDefinition = Class.forName(configClassName);
			baseConfig = (BaseConfig) configClassDefinition.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		}
		return baseConfig;
	}

	public static BaseConfig getConfig(String configClassName, Object... args) throws ConfigException {
		BaseConfig baseConfig = null;

		try {
			Class<?> configClassDefinition = Class.forName(configClassName);

			Class<?>[] params = new Class[args.length];
			int i = 0;
			for (Object thisArg : args) {
				params[i++] = thisArg.getClass();
			}
			Constructor<?> constructor = configClassDefinition
					.getConstructor(params);
			baseConfig = (BaseConfig) constructor.newInstance(args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new ConfigException(e);
		}

		return baseConfig;
	}
}