package org.iq.ums.service;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.UmsConstants.UserStatus;
import org.iq.ums.helper.UmsHelper;
import org.iq.ums.helper.UmsRegistrationHelper;
import org.iq.util.StringUtil;

@Service(name = "VerifyUser")
public class VerifyUserService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2608012112191174260L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		int userId = Integer.valueOf((String) input.get(UserKeys.USER_ID_KEY));

		String verificationCode = StringUtil.getStringValue(input.get("verificationCode"));

		try {
			UmsRegistrationHelper umsRegistrationHelper = new UmsRegistrationHelper();

			Boolean verified = false;

			verified = umsRegistrationHelper.verify(userId, verificationCode);

			if(verified) {
				umsRegistrationHelper.deleteVerificationCode(userId);

				UmsHelper umsHelper = new UmsHelper();

				umsHelper.updateStatus(userId, UserStatus.VERIFIED);

				redirectUrl = "dashboard.jsp";
			} else {
				redirectUrl = "verify.jsp";
			}
		} catch(BusinessException e) {
			throw new ServiceException(e);
		}

	}

}
