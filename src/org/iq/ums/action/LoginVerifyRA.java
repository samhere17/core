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
@Action(name = "LoginVerify")
public class LoginVerifyRA extends RedirectAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4297073573764672003L;

	/**
	 * 
	 */
	public LoginVerifyRA() {
		super();
		setName("LoginVerify");
		setRedirectUrl("verify");
	}
}