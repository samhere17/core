/**
 * 
 */
package org.iq.gen.data.action;

import org.iq.gen.GeneratorUtil;

/**
 * @author Sam
 *
 */
public class LaunchActionData extends ActionData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -739791148288313720L;

	private static final String CLASS_SUFFIX = "LA";

	private String serviceName;
	private RedirectActionData redirectAction;

	/**
	 * @return the serviceName
	 */
	public final String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	protected final void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the redirectAction
	 */
	public final RedirectActionData getRedirectAction() {
		return redirectAction;
	}

	/**
	 * @param redirectAction the redirectAction to set
	 */
	protected final void setRedirectAction(RedirectActionData redirectAction) {
		this.redirectAction = redirectAction;
	}
	/**
	 * @return String
	 */
	public String getClassName() {
		return GeneratorUtil.toCamelCase(getName()) + CLASS_SUFFIX;
	}
}