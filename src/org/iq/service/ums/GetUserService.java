package org.iq.service.ums;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsHelper;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;

@Service(name = "GetUser")
public class GetUserService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1137779888934396383L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int userId = umsSession.getUserId();
		if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(UserKeys.USER_ID_KEY)))==false) {
			userId = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.USER_ID_KEY)));
		}

		try {
			resultAttributes.put(UserKeys.USER_KEY, new UmsHelper().getUser(userId));
			resultAttributes.put(UserKeys.USER_DETAILS_KEY, new UmsHelper().getUserDetails(userId));
			resultAttributes.put(UserKeys.USER_ROLE_KEY, new UmsRoleHelper().getRoleByUserId(userId));
			
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "ums/details.jsp";

		LocalLogger.logMethodEnd();
	}
}