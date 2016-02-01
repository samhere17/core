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
@Action(name = "LoginVerify")
public class LoginVerifyLA extends LaunchAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4297073573764672003L;

	/**
	 * 
	 */
	public LoginVerifyLA() {
		super();
		setName("LoginVerify");
		setRedirectUrl("verify");
	}
}