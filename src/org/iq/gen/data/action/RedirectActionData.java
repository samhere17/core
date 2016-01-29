/**
 * 
 */
package org.iq.gen.data.action;

import org.iq.gen.GeneratorUtil;

/**
 * @author Sam
 *
 */
public class RedirectActionData extends ActionData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7089667725747718535L;

	private static final String CLASS_SUFFIX = "RA";
	
	private String redirectUrl;
	
	public RedirectActionData() {
		setSessionRequired(false);
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
	public final void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	/**
	 * @return String
	 */
	public String getClassName() {
		return GeneratorUtil.toCamelCase(getName()) + CLASS_SUFFIX;
	}
}
