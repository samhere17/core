package org.iq.ums.service.role;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsRoleHelper;
import org.iq.util.StringUtil;

@Service(name="UpdateRole")
public class UpdateRoleService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6476871961127060788L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		int roleId = Integer.valueOf(StringUtil.getStringValue(input.get(RoleKeys.ROLE_ID_KEY)));
		String roleName = StringUtil.getStringValue(input.get(RoleKeys.ROLE_NAME_KEY));
		String roleDesc = StringUtil.getStringValue(input.get(RoleKeys.ROLE_DESCRIPTION_KEY));

		Map<Integer, Boolean> optionsMap = new HashMap<>();
		
		Set<String> paramKeys = input.keySet();
		for (String paramKey : paramKeys) {
			if (paramKey.startsWith("option-")) {
				optionsMap.put(Integer.valueOf(paramKey.substring(paramKey.indexOf("-")+1)), input.get(paramKey).equals("on"));
			}
		}
		
		int userId = umsSession.getUserId();
		String additionalId = umsSession.getAdditionalId();

//		UmsRole umsRole =  new UmsRole();
		try {
			new UmsRoleHelper().updateRole(roleId,roleName,
					roleDesc, optionsMap, additionalId, userId);
		} catch (BusinessException e) {
			// e.printStackTrace();
			throw new ServiceException(e);
		}
		
		//redirectUrl = "__sys/org/details.jsp";
		
		redirectUrl = "adapter?serviceName=GetRole&path=ums/role/details&roleId="+roleId;
		LocalLogger.logMethodEnd();
	}

}
