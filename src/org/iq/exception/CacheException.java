package org.iq.exception;

/**
 * @author Sam
 * 
 */
public class CacheException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4381787202903729888L;

	public CacheException() {

	}

	public CacheException(String msg, Throwable th) {
		super(msg, th);
	}

	public CacheException(String msg) {
		super(msg);
	}
}
