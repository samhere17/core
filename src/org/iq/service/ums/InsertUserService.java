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

@Service(name="InsertUser")
public class InsertUserService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1579879485745235367L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		String additionalId = StringUtil.getStringValue(input.get(UserKeys.SELECTED_ORG_ID_KEY));
		if (StringUtil.isEmpty(additionalId)) {
			additionalId = umsSession.getAdditionalId();
		}

		String firstname = StringUtil.getStringValue(input.get(UserKeys.FIRST_NAME_KEY));
		String lastname = StringUtil.getStringValue(input.get(UserKeys.LAST_NAME_KEY));
		String alias = StringUtil.getStringValue(input.get(UserKeys.ALIAS_KEY));
		
		String address = StringUtil.getStringValue(input.get(UserKeys.ADDRESS_KEY));
		String phone = StringUtil.getStringValue(input.get(UserKeys.PHONE_KEY));
		String altPhone = StringUtil.getStringValue(input.get(UserKeys.ALT_PHONE_KEY));
		String email = StringUtil.getStringValue(input.get(UserKeys.EMAIL_KEY));
		String altEmail = StringUtil.getStringValue(input.get(UserKeys.ALT_EMAIL_KEY));
		
		Integer gender = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.GENDER_KEY)));
		Date birthday = DateUtil.stringToDate(StringUtil.getStringValue(input.get(UserKeys.BIRTH_DAY_KEY)),DateFormat.yyyy_MM_dd);
		Date anniversary = DateUtil.stringToDate(StringUtil.getStringValue(input.get(UserKeys.ANNIVERSARY_KEY)),DateFormat.yyyy_MM_dd);

		String username = StringUtil.getStringValue(input.get(UserKeys.USERNAME_KEY));
		String password = StringUtil.getStringValue(input.get(UserKeys.PASSWORD_KEY));
		String cpassword = StringUtil.getStringValue(input.get(UserKeys.C_PASSWORD_KEY));
		
		Integer roleId = null;
		if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(UserKeys.SELECTED_ROLE_ID_KEY)))==false) {
			roleId = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.SELECTED_ROLE_ID_KEY)));
		}
		
		Integer userUpdatedBy = umsSession.getUserId();

		UmsRegistrationResult umsRegistrationResult = null;
		
		try {
			umsRegistrationResult = new UmsRegistrationHelper().register(
					firstname, lastname, alias, address, phone, email,
					altPhone, altEmail, gender, birthday, anniversary,
					username, password, cpassword, additionalId, roleId,
					userUpdatedBy);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logDebug(umsRegistrationResult);
//		resultAttributes.put(UMS_REGISTRATION_RESULT_KEY, umsRegistrationResult);
		
		resultAttributes.put(UserKeys.NEW_USER_VALIDATION_KEY, umsRegistrationResult);

		if (umsRegistrationResult != null
				&& umsRegistrationResult.isRegistrationSuccess()) {
			redirectUrl = "adapter?serviceName=GetUser&path=ums/details&userId="+umsRegistrationResult.getUmsUserDetails().getUserId();
		} else {
			redirectUrl = "ums/new.jsp";
		}
		LocalLogger.logMethodEnd();
	}

}
