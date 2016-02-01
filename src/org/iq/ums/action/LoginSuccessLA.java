/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.action;

import org.iq.action.Action;
import org.iq.action.LaunchAction;
import org.iq.ums.UmsContext;

/**
 * @author Sam
 * 
 */
@Action(name = "LoginSuccess")
public class LoginSuccessLA extends LaunchAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2526497242028568286L;

	/**
	 * 
	 */
	public LoginSuccessLA() {
		super();
		setName("LoginSuccess");
		setRedirectUrl(UmsContext.umsConfig.getLoginSuccessRedirectUrl());
	}
}