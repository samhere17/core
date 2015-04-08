package org.iq.exception;


/**
 * @author Sam
 *
 */
public class UmsException extends BaseException {

  /**
   * 
   */
  private static final long serialVersionUID = -1102568361486069986L;
  
  
  public UmsException(String msg) {
	  super(msg);
  }
  
  /**
   * @param th
   */
  public UmsException(Throwable th){
    super(th);
  }

  /**
   * @param message
   * @param th
   */
  public UmsException(String message,Throwable th){
    super(getErrorMessage(message, th),th);
  }
}