/**
 * 
 */
package org.iq.action;

/**
 * @author Sam
 *
 */
public abstract class LaunchAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -739791148288313720L;

	/**
	 * the service name if any service needs to be executed before the form is
	 * launched
	 */
	private String serviceName;
	/**
	 * ID of the form to be launched
	 */
	private String formId;
	
	private RedirectAction redirectAction;

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
	public final RedirectAction getRedirectAction() {
		return redirectAction;
	}

	/**
	 * @param redirectAction the redirectAction to set
	 */
	protected final void setRedirectAction(RedirectAction redirectAction) {
		this.redirectAction = redirectAction;
	}
}