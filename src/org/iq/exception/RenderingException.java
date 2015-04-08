package org.iq.exception;

/**
 * @author
 * 
 */
public class RenderingException extends ServiceException {

  /**
   * 
   */
  private static final long serialVersionUID = -7135422052446869712L;

  /**
   * 
   */
  public RenderingException() {
	super();
  }

  /**
   * @param msg
   */
  public RenderingException(String msg) {
	super(msg);
  }

  /**
   * @param msg
   */
  public RenderingException(Throwable th) {
	super(th);
  }

  /**
   * @param msg
   * @param th
   */
  public RenderingException(String msg, Throwable th) {
	super(msg, th);
  }
}