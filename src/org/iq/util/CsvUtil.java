/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.iq.exception.UtilityException;
import org.iq.valueobject.BaseVO;

/**
 * @author Sam
 */
public class CsvUtil extends BaseUtil {

	public static <T extends CsvObject<? extends BaseVO>> T getCsvObject(Class<T> actualCsvObjectType,
			String csvFileContent) throws UtilityException {
		try {
			Constructor<?> constructor = actualCsvObjectType.getConstructor(String.class);
			return actualCsvObjectType.cast(constructor.newInstance(csvFileContent));
		} catch (NoSuchMethodException e) {
			throw new UtilityException(e);
		} catch (SecurityException e) {
			throw new UtilityException(e);
		} catch (InstantiationException e) {
			throw new UtilityException(e);
		} catch (IllegalAccessException e) {
			throw new UtilityException(e);
		} catch (IllegalArgumentException e) {
			throw new UtilityException(e);
		} catch (InvocationTargetException e) {
			throw new UtilityException(e);
		}
	}
}