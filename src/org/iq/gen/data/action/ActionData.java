package org.iq.gen.data.action;

import org.iq.gen.data.BaseData;

public abstract class ActionData extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438365728861221847L;

	private String name;
	private boolean sessionRequired = false;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sessionRequired
	 */
	public final boolean isSessionRequired() {
		return sessionRequired;
	}

	/**
	 * @param sessionRequired
	 *            the sessionRequired to set
	 */
	public final void setSessionRequired(boolean sessionRequired) {
		this.sessionRequired = sessionRequired;
	}

}