/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.util;

import java.util.Map;

import org.iq.exception.UtilityException;

/**
 * @author Sam
 */
public class SystemUtil extends BaseUtil {
	
	/**
	 * Reads the System properties defined at the Operating System level.
	 * 
	 * @param sysParamName
	 *            Operating System Environment variable name
	 * @return String Value of the parameter.
	 * @throws UtilityException
	 */
	public static String getSystemProperty(String sysParamName)
			throws UtilityException {
		String paramValue = System.getProperty(sysParamName);
		if (paramValue == null || paramValue.length() == 0) {
			Map<String, String> map = System.getenv();
			paramValue = map.get(sysParamName);
		}
		if (paramValue == null) {
			throw new UtilityException("System enironment variable: "
					+ sysParamName + " is not set.");
		}
		System.out.println("Found System Property: " + sysParamName + " = "
				+ paramValue);
		return paramValue;
	}
}
