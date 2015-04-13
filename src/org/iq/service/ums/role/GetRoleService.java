package org.iq.service.ums.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsOptionHelper;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.service.ums.option.OptionKeys;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsOption;

@Service(name = "GetRole")
public class GetRoleService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1137779888934396383L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int roleId = Integer.valueOf(StringUtil.getStringValue(input
				.get(RoleKeys.ROLE_ID_KEY)));
		
		int currUserRole = umsSession.getRoleId();

		try {
			resultAttributes.put(RoleKeys.ROLE_KEY,
					new UmsRoleHelper().getRoleByRoleId(roleId));
			
			List<UmsOption> options = null;
			
			if (currUserRole == RoleKeys.SUPER_ADMIN_ROLE_ID) {
				options = new UmsOptionHelper().getAllOptions();
			} else {
				options = new UmsOptionHelper().getAppOptions();
			}		

//			List<UmsOption> options = new UmsOptionHelper().getAllOptions();

			UmsRoleHelper umsRoleHelper = new UmsRoleHelper();
			Map<Integer, Boolean> optionsMap = umsRoleHelper
					.getOptionsMap(roleId);

			if (options != null && optionsMap != null) {
				for (UmsOption thisParentOption : options) {
					if (optionsMap.get(thisParentOption.getOptionId()) != null
							&& optionsMap.get(thisParentOption.getOptionId())) {
						thisParentOption.setMenuItemEnabled(true);
						List<UmsOption> umsChildOptions = thisParentOption.getChildOptions();
						if (umsChildOptions != null && umsChildOptions.size() > 0) {
							for (UmsOption thisChildOption : umsChildOptions) {
								if (optionsMap.get(thisChildOption.getOptionId()) != null
										&& optionsMap.get(thisChildOption.getOptionId())) {
									thisChildOption.setMenuItemEnabled(true);
								}
							}
						}
					}
				}
			}
			
			resultAttributes.put(OptionKeys.OPTIONS_LIST_KEY, options);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "ums/role/details.jsp";

		LocalLogger.logMethodEnd();
	}
}