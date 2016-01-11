/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums.service;

import java.util.Date;
import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.UmsConstants.Gender;
import org.iq.ums.UmsContext;
import org.iq.ums.helper.UmsRegistrationHelper;
import org.iq.ums.vo.UmsRegistrationResult;
import org.iq.util.DateUtil;
import org.iq.util.DateUtil.DateFormat;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
@Service(name="Registration")
public class RegistrationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938218481685588931L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.service.BaseService#execute(java.util.HashMap)
	 */
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		String firstname = StringUtil.getStringValue(input.get(UserKeys.FIRST_NAME_KEY));
		String lastname = StringUtil.getStringValue(input.get(UserKeys.LAST_NAME_KEY));
		Integer gender = Gender.UNKNOWN.getGenderValue();
		if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(UserKeys.GENDER_KEY)))==false) {
			gender = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.GENDER_KEY)));
		}

		String username = StringUtil.getStringValue(input.get(UserKeys.USERNAME_KEY));
		String password = StringUtil.getStringValue(input.get(UserKeys.PASSWORD_KEY));
		String cpassword = StringUtil.getStringValue(input.get(UserKeys.C_PASSWORD_KEY));
		
		String mobile = StringUtil.getStringValue(input.get(UserKeys.PHONE_KEY));
		String email = StringUtil.getStringValue(input.get(UserKeys.EMAIL_KEY));
		Date birthday = DateUtil.stringToDate(StringUtil.getStringValue(input.get(UserKeys.BIRTH_DAY_KEY)),DateFormat.yyyy_MM_dd);

		String remoteAddr = StringUtil.getStringValue(input.get(UserKeys.REMOTE_ADDRESS_KEY));
		String captchaChallenge = StringUtil.getStringValue(input.get(UserKeys.CAPTCHA_CHALLENGE_KEY));
		String captchaResponse = StringUtil.getStringValue(input.get(UserKeys.CAPTCHA_RESPONSE_KEY));

		UmsRegistrationResult umsRegistrationResult = null;
		
		try {
			umsRegistrationResult = new UmsRegistrationHelper().register(firstname, lastname,
					username, password, cpassword, birthday, gender, email,
					mobile, remoteAddr, captchaChallenge,
					captchaResponse);
			
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		resultAttributes.put(UserKeys.UMS_REGISTRATION_RESULT_KEY, umsRegistrationResult);

		if (umsRegistrationResult != null && umsRegistrationResult.isRegistrationSuccess()) {
			redirectUrl = UmsContext.umsConfig.getRegisterSuccessRedirectUrl();
		} else {
			redirectUrl = UmsContext.umsConfig.getRegisterFailureRedirectUrl();
		}
		LocalLogger.logMethodEnd();
	}
}