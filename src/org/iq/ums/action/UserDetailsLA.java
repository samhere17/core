/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.action;

import org.iq.action.Action;
import org.iq.action.LaunchAction;

/**
 * @author Sam
 * 
 */
@Action(id = "UserDetails")
public class UserDetailsLA extends LaunchAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2526797242028568286L;

	/**
	 * 
	 */
	public UserDetailsLA() {
		super();
		setId("UserDetails");
		setName("UserDetails");
		setServiceName("GetUser");
		setPageId("");
		setRedirectUrl("ums/details.jsp");
	}
}