package org.iq.service.ums;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.service.ums.role.RoleKeys;

@Service(name = "GetNewUser")
public class GetNewUserService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4332535430561232232L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {

		LocalLogger.logMethodStart();

		try {
			int currUserRole = umsSession.getRoleId();

			// Getting organization list for lookup on the screen
			if (currUserRole == RoleKeys.SUPER_ADMIN_ROLE_ID) {
				resultAttributes.put(
						UserKeys.ORGANIZATIONS_LIST_FOR_LOOKUP_KEY,
						new OrganizationHelper().getAllOrganization());
			} else {
				resultAttributes.put(
						UserKeys.ORGANIZATIONS_LIST_FOR_LOOKUP_KEY, null);
			}

			// Getting roles list for lookup on the screen
			if (currUserRole == RoleKeys.SUPER_ADMIN_ROLE_ID) {
				resultAttributes.put(UserKeys.ROLES_LIST_FOR_LOOKUP_KEY,
						new UmsRoleHelper().getAllRoles());
			} else {
				resultAttributes.put(UserKeys.ROLES_LIST_FOR_LOOKUP_KEY,
						new UmsRoleHelper().getAppRoles());
			}
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}
}