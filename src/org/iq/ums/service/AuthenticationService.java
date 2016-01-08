/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.service;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.UmsConstants;
import org.iq.ums.UmsContext;
import org.iq.ums.exception.UmsException;
import org.iq.ums.helper.UmsAuthenticationHelper;
import org.iq.ums.vo.UmsSession;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
@Service(name="Authentication")
public class AuthenticationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938218481685588931L;

	private static final String USERNAME_KEY = "username";
	private static final String PASSWORD_KEY = "password";
	private static final String J_SESSION_ID_KEY = "jSessionId";
	private static final String ACCESS_IP_KEY = "accessIP";
	private static final String ACCESS_PORT_KEY = "accessPort";
	private static final String ACCESS_GATEWAY_KEY = "accessGateway";
	private static final String ACTUAL_ACCESS_IP_KEY = "actualAccessIP";
	private static final String USER_AGENT_KEY = "userAgent";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.service.BaseService#execute(java.util.HashMap)
	 */
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		String username = StringUtil.getStringValue(input.get(USERNAME_KEY));
		String password = StringUtil.getStringValue(input.get(PASSWORD_KEY));
		String jSessionId = StringUtil.getStringValue(input.get(J_SESSION_ID_KEY));
		String accessIp = StringUtil.getStringValue(input.get(ACCESS_IP_KEY));
		String accessPort = StringUtil.getStringValue(input.get(ACCESS_PORT_KEY));
		String accessGateway = StringUtil.getStringValue(input.get(ACCESS_GATEWAY_KEY));
		String actualAccessIP = StringUtil.getStringValue(input.get(ACTUAL_ACCESS_IP_KEY));
		String userAgentString = StringUtil.getStringValue(input.get(USER_AGENT_KEY));
		
//		String successUrl = StringUtil.getStringValue(input.get(SUCCESS_URL_KEY));
//		String errorUrl = StringUtil.getStringValue(input.get(ERROR_URL_KEY));

		UmsSession umsSession = null;
		try {
			umsSession = new UmsAuthenticationHelper().authenticate(username, password, jSessionId, accessIp,
					accessPort, accessGateway, actualAccessIP, userAgentString);
		} catch (UmsException e) {
			throw new ServiceException(e);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

//		System.out.println(umsSession);
		LocalLogger.logDebug(umsSession);
		resultAttributes.put(UmsConstants.UMS_SESSION_KEY, umsSession);

		if (umsSession.isSessionValid()) {
			redirectUrl = UmsContext.umsConfig.getLoginSuccessRedirectUrl();
		} else {
			redirectUrl = UmsContext.umsConfig.getLoginFailureRedirectUrl();
		}
		LocalLogger.logMethodEnd();
	}
}