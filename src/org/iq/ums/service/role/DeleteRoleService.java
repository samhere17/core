package org.iq.ums.service.role;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsRoleHelper;
import org.iq.util.StringUtil;

@Service(name = "DeleteRole")
public class DeleteRoleService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7127273438580661810L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int roleId = Integer.valueOf(StringUtil.getStringValue(input.get(RoleKeys.ROLE_ID_KEY)));
		int userId = umsSession.getUserId();
		try {
			new UmsRoleHelper().delete(roleId, userId);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "adapter?serviceName=GetRole&path=ums/role/details&roleId=" + roleId;

		LocalLogger.logMethodEnd();
	}

}
