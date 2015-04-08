/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.exception;

/**
 * @author Sam
 * 
 */
public class ConfigException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1102568361486069986L;

	/**
	 * @param msg
	 */
	public ConfigException(String msg) {
		super(msg);
	}

	/**
	 * @param th
	 */
	public ConfigException(Throwable th) {
		super(th);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public ConfigException(String msg, Throwable th) {
		super(msg, th);
	}
}