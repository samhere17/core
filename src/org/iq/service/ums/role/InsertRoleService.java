package org.iq.service.ums.role;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsRoleHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsRole;

@Service(name="InsertRole")
public class InsertRoleService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -92743573380502163L;
	
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
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

		UmsRole umsRole =  new UmsRole();
		try {
			umsRole = new UmsRoleHelper().createRole(roleName,
					roleDesc, optionsMap, additionalId, userId);
		} catch (BusinessException e) {
			// e.printStackTrace();
			throw new ServiceException(e);
		}
		
		//redirectUrl = "__sys/org/details.jsp";
		
		redirectUrl = "adapter?serviceName=GetRole&path=ums/role/details&roleId="+umsRole.getRoleId();
		LocalLogger.logMethodEnd();
	}
}