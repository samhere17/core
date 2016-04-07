/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.action;

import org.iq.action.Action;
import org.iq.action.SubmitAction;

/**
 * @author Sam
 * 
 */
@Action(id = "Authentication")
public class AuthenticationSA extends SubmitAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938218481685588931L;
	
	public static final String LOGIN_SUCCESS_ACTION_KEY = "LoginSuccess";
	public static final String LOGIN_FAILURE_ACTION_KEY = "LoginFailure";
	public static final String LOGIN_VERIFY_ACTION_KEY = "LoginVerify";
	
	/**
	 * 
	 */
	public AuthenticationSA() {
		setName("Authentication");
		setServiceName("Authentication");
		
		setSessionNotRequired();
	}
}