package org.iq.exception;


/**
 * @author Sam
 * 
 */
public class LoggerException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6092826926430157068L;

	/**
	 * 
	 */
	public LoggerException() {
		super();
	}

	/**
	 * @param msg
	 */
	public LoggerException(String msg) {
		super(msg);
	}

	/**
	 * @param msg
	 */
	public LoggerException(Throwable th) {
		super(th);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public LoggerException(String msg, Throwable th) {
		super(msg, th);
	}
}