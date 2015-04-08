package org.iq.exception;

/**
 * @author
 * 
 */
public class ServiceException extends BaseException {

  /**
   * 
   */
  private static final long serialVersionUID = -7135422052446869712L;

  /**
   * 
   */
  public ServiceException() {
	super();
  }

  /**
   * @param msg
   */
  public ServiceException(String msg) {
	super(msg);
  }

  /**
   * @param msg
   */
  public ServiceException(Throwable th) {
	super(th);
  }

  /**
   * @param msg
   * @param th
   */
  public ServiceException(String msg, Throwable th) {
	super(msg, th);
  }
}