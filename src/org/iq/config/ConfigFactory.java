package org.iq.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

final public class ConfigFactory {

	public static BaseConfig getConfig(String configClassName) {
		BaseConfig baseConfig = null;
		try {
			Class<?> configClassDefinition = Class.forName(configClassName);
			baseConfig = (BaseConfig) configClassDefinition.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return baseConfig;
	}

	public static BaseConfig getConfig(String configClassName, Object... args) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return baseConfig;
	}
}