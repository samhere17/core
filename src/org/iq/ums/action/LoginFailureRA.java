/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.action;

import org.iq.action.Action;
import org.iq.action.RedirectAction;
import org.iq.ums.UmsContext;

/**
 * @author Sam
 * 
 */
@Action(name = "LoginFailure")
public class LoginFailureRA extends RedirectAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7588564468508775953L;

	/**
	 * 
	 */
	public LoginFailureRA() {
		super();
		setName("LoginFailure");
		setRedirectUrl(UmsContext.umsConfig.getLoginFailureRedirectUrl());
	}
}