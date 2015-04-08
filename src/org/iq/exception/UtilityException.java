/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.exception;

/**
 * @author Sam
 * 
 */
public class UtilityException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1102568361486069986L;

	/**
	 * @param msg
	 */
	public UtilityException(String msg) {
		super(msg);
	}

	/**
	 * @param th
	 */
	public UtilityException(Throwable th) {
		super(th);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public UtilityException(String msg, Throwable th) {
		super(msg, th);
	}
}