package org.iq.exception;

/**
 * @author
 * 
 */
public class RenderableException extends ServiceException {

  /**
   * 
   */
  private static final long serialVersionUID = -7135422052446869712L;

  /**
   * 
   */
  public RenderableException() {
	super();
  }

  /**
   * @param msg
   */
  public RenderableException(String msg) {
	super(msg);
  }

  /**
   * @param msg
   */
  public RenderableException(Throwable th) {
	super(th);
  }

  /**
   * @param msg
   * @param th
   */
  public RenderableException(String msg, Throwable th) {
	super(msg, th);
  }
}