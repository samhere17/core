package org.iq.exception;

public class BusinessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1363050711540685161L;

	/**
	 * 
	 */
	public BusinessException() {
		super();
	}

	/**
	 * @param msg
	 */
	public BusinessException(String msg) {
		super(msg);
	}

	/**
	 * @param th
	 */
	public BusinessException(Throwable th) {
		super(th);
	}

	/**
	 * @param msg
	 * @param th
	 */
	public BusinessException(String msg, Throwable th) {
		super(msg, th);
	}
}
