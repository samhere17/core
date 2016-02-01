/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
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
	 * ID of the page to be launched
	 */
	private String pageId;

	/**
	 * URL of the page to be launched. This is only used if <code>pageId</code>
	 * is not provided
	 */
	private String redirectUrl;

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
	 * @return the pageId
	 */
	public final String getPageId() {
		return pageId;
	}

	/**
	 * @param pageId
	 *            the pageId to set
	 */
	protected final void setPageId(String pageId) {
		this.pageId = pageId;
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