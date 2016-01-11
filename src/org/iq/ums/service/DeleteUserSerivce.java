package org.iq.ums.service;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsHelper;
import org.iq.util.StringUtil;

@Service(name = "DeleteUser")
public class DeleteUserSerivce extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3037982410280581247L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		int userId = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.USER_ID_KEY)));
		String userAccessKey = StringUtil.getStringValue(input.get(UserKeys.USER_ACCESS_KEY));
	
		try {
			UmsHelper umsHelper = new UmsHelper();
			umsHelper.delete(userAccessKey);
			redirectUrl = "adapter?path=ums/details&serviceName=GetUser&userId=" + userId;
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}
		
	}

}
