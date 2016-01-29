/**
 * 
 */
package org.iq.action;

/**
 * @author Sam
 *
 */
public abstract class RedirectAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7089667725747718535L;
	
	private String redirectUrl;
	private String formId;
	
	public RedirectAction() {
		setSessionNotRequired();
	}

	/**
	 * @return the redirectUrl
	 */
	public final String getRedirectUrl() {
		return redirectUrl;
	}

	/**
	 * @param redirectUrl
	 *            the redirectUrl to set
	 */
	protected final void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

}
