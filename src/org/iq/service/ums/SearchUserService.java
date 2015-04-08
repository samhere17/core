package org.iq.service.ums;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.helper.ums.UmsHelper;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.service.ums.role.RoleKeys;
import org.iq.util.StringUtil;

@Service(name="SearchUser")
public class SearchUserService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2627039410001042386L;

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
			
			
			String additionalId = StringUtil.getStringValue(input.get(UserKeys.SELECTED_ORG_ID_KEY));
			if (StringUtil.isEmpty(additionalId)) {
				additionalId = umsSession.getAdditionalId();
			}

			String userId = StringUtil.getStringValue(input.get(UserKeys.USER_ID_KEY));
			String username = StringUtil.getStringValue(input.get(UserKeys.USERNAME_KEY));

			String firstname = StringUtil.getStringValue(input.get(UserKeys.FIRST_NAME_KEY));
			String lastname = StringUtil.getStringValue(input.get(UserKeys.LAST_NAME_KEY));

			String phone = StringUtil.getStringValue(input.get(UserKeys.PHONE_KEY));
			String email = StringUtil.getStringValue(input.get(UserKeys.EMAIL_KEY));

			Integer roleId = null;
			if (StringUtil.isEmpty(StringUtil.getStringValue(input.get(UserKeys.SELECTED_ROLE_ID_KEY)))==false) {
				roleId = Integer.valueOf(StringUtil.getStringValue(input.get(UserKeys.SELECTED_ROLE_ID_KEY)));
			}
		
			resultAttributes.put(UserKeys.USERS_LIST_KEY, new UmsHelper()
					.getSearchedUsers(additionalId, userId, username,
							firstname, lastname, phone, email, roleId));
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		resultAttributes.put("searchDone",true);
		redirectUrl = "ums/search.jsp";

		LocalLogger.logMethodEnd();
	}

}
