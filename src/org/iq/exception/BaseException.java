/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.iq.util.StringUtil;

public abstract class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7381248083824421443L;

	/**
	 * 
	 */
	public BaseException() {
		super();
	}

	/**
	 * @param msg
	 */
	public BaseException(String msg) {
		super(msg);
	}

	/**
	 * @param th
	 */
	public BaseException(Throwable th) {
		super(th);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public BaseException(String msg, Throwable th) {
		super(msg, th);
	}

	/**
	 * @param th
	 * @return String
	 */
	protected static final String getErrorMessage(String message, Throwable th) {
		return message != null ? message + " : " : "" + th.getMessage() != null ? th.getMessage() : "";
	}

	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if (StringUtil.isEmpty(msg) == false) {
			if (msg.contains(":")) {
				int index = msg.lastIndexOf(":");
				msg = msg.substring(index+1).trim();
			}
		}
		return msg;
	}

	/**
	 * @param e
	 * @return
	 */
	public static final String getStackTrace(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String stackTrace = sw.toString(); // stack trace as a string
		pw.close();

		try {
			sw.close();
		} catch (IOException e1) {
			/* need not do anything here */
		}
		return stackTrace;
	}

	/**
	 * @param e
	 * @return
	 */
	public static final String getStackTraceForWeb(Throwable e) {
		return getStackTrace(e).replace(StringUtil.lineSeparator, "<br/>&nbsp;");
	}
}
