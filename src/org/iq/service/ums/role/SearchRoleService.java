package org.iq.service.ums.role;

import java.util.HashMap;
import java.util.List;

import org.iq.UmsConstants.AreaSpecifier;
import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsRole;

@Service(name = "SearchRole")
public class SearchRoleService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3057102570265452858L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		Integer roleArea = null;
		int currUserRole = umsSession.getRoleId();
		if (currUserRole != RoleKeys.SUPER_ADMIN_ROLE_ID) {
			roleArea = AreaSpecifier.APPLICATION.getAreaSpecifierValue();
		}

		Integer roleId = null;
		if (StringUtil.isEmpty(StringUtil.getStringValue(input
				.get(RoleKeys.ROLE_ID_KEY))) == false) {
			roleId = Integer.valueOf(StringUtil.getStringValue(input
					.get(RoleKeys.ROLE_ID_KEY)));
		}

		String roleName = StringUtil.getStringValue(input
				.get(RoleKeys.ROLE_NAME_KEY));

		try {
			UmsRoleHelper umsRoleHelper = new UmsRoleHelper();
			List<UmsRole> umsRoles = umsRoleHelper.getSearchedRoles(roleArea, roleId, roleName);
			resultAttributes.put(RoleKeys.ROLES_LIST_KEY, umsRoles);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		resultAttributes.put("searchDone", true);
		redirectUrl = "ums/role/search.jsp";

		LocalLogger.logMethodEnd();
	}
}