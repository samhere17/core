/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.service.ums;

import java.util.Date;
import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsRegistrationHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.DateUtil;
import org.iq.util.DateUtil.DateFormat;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsRegistrationResult;

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
	
	private static final String REGISTRATION_TYPE_KEY = "registrationType";
	private static final String REGISTRATION_TYPE_SYSTEM = "system";


	private static final String FIRST_NAME_KEY = "firstname";
	private static final String LAST_NAME_KEY = "lastname";
	private static final String ALIAS_KEY = "alias";

	private static final String ADDRESS_KEY = "address";
	private static final String PHONE_KEY = "phone";
	private static final String EMAIL_KEY = "email";
	private static final String ALT_PHONE_KEY = "altPhone";
	private static final String ALT_EMAIL_KEY = "altEmail";

	private static final String GENDER_KEY = "gender";
	private static final String BIRTH_DAY_KEY = "birthday";
	private static final String ANNIVERSARY_KEY = "anniversary";

	private static final String USERNAME_KEY = "username";
	private static final String PASSWORD_KEY = "password";
	private static final String C_PASSWORD_KEY = "cpassword";

	private static final String ADDITIONAL_ID_KEY = "additionalId";
	private static final String ROLE_ID_KEY = "roleID";
//	private static final String USER_UPDATED_BY_KEY = "updatedBy";

	private static final String UMS_REGISTRATION_RESULT_KEY = "umsRegistrationResult";


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.service.BaseService#execute(java.util.HashMap)
	 */
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		String registrationType = StringUtil.getStringValue(input.get(REGISTRATION_TYPE_KEY));

		String firstname = StringUtil.getStringValue(input.get(FIRST_NAME_KEY));
		String lastname = StringUtil.getStringValue(input.get(LAST_NAME_KEY));
		String alias = StringUtil.getStringValue(input.get(ALIAS_KEY));
		
		String address = StringUtil.getStringValue(input.get(ADDRESS_KEY));
		String phone = StringUtil.getStringValue(input.get(PHONE_KEY));
		String altPhone = StringUtil.getStringValue(input.get(ALT_PHONE_KEY));
		String email = StringUtil.getStringValue(input.get(EMAIL_KEY));
		String altEmail = StringUtil.getStringValue(input.get(ALT_EMAIL_KEY));
		
		Integer gender = Integer.valueOf(StringUtil.getStringValue(input.get(GENDER_KEY)));
		Date birthday = DateUtil.stringToDate(StringUtil.getStringValue(input.get(BIRTH_DAY_KEY)),DateFormat.yyyy_MM_dd);
		Date anniversary = DateUtil.stringToDate(StringUtil.getStringValue(input.get(ANNIVERSARY_KEY)),DateFormat.yyyy_MM_dd);

		String username = StringUtil.getStringValue(input.get(USERNAME_KEY));
		String password = StringUtil.getStringValue(input.get(PASSWORD_KEY));
		String cpassword = StringUtil.getStringValue(input.get(C_PASSWORD_KEY));
		
		String additionalId = StringUtil.getStringValue(input.get(ADDITIONAL_ID_KEY));
		Integer roleId = null;
		if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(ROLE_ID_KEY)))==false) {
			roleId = Integer.valueOf(StringUtil.getStringValue(input.get(ROLE_ID_KEY)));
		}

/*		Integer userUpdatedBy = null;
		if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(USER_UPDATED_BY_KEY)))==false) {
			userUpdatedBy = Integer.valueOf(StringUtil.getStringValue(input.get(USER_UPDATED_BY_KEY)));
		}
*/
//		String successUrl = StringUtil.getStringValue(input.get(SUCCESS_URL_KEY));
//		String errorUrl = StringUtil.getStringValue(input.get(ERROR_URL_KEY));
		

		UmsRegistrationResult umsRegistrationResult = null;
		
		try {
			if (REGISTRATION_TYPE_SYSTEM.equalsIgnoreCase(registrationType)) {
				umsRegistrationResult = new UmsRegistrationHelper().register(
						firstname, lastname, alias, address, phone, email,
						altPhone, altEmail, gender, birthday, anniversary,
						username, password, cpassword);
			} else {
				umsRegistrationResult = new UmsRegistrationHelper().register(
						firstname, lastname, alias, address, phone, email,
						altPhone, altEmail, gender, birthday, anniversary,
						username, password, cpassword, additionalId, roleId,
						umsSession.getUserId());
			}
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logDebug(umsRegistrationResult);
		resultAttributes.put(UMS_REGISTRATION_RESULT_KEY, umsRegistrationResult);

		if (umsRegistrationResult != null
				&& umsRegistrationResult.isRegistrationSuccess()) {
			redirectUrl = "index.jsp";
		} else {
			redirectUrl = "ums/register.jsp";
		}
		LocalLogger.logMethodEnd();
	}
}