package org.iq.service.ums.role;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;

@Service(name = "ListRoles")
public class ListRolesService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1137779888934396383L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		
		int currUserRole = umsSession.getRoleId();
		
		try {
			if (currUserRole == RoleKeys.SUPER_ADMIN_ROLE_ID) {
				resultAttributes.put(RoleKeys.ROLES_LIST_KEY,
						new UmsRoleHelper().getAllRoles());
			} else {
				resultAttributes.put(RoleKeys.ROLES_LIST_KEY,
						new UmsRoleHelper().getAppRoles());
			}
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}
}