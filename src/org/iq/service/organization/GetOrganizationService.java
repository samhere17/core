package org.iq.service.organization;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;

@Service(name="GetOrganization")
public class GetOrganizationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1137779888934396383L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int organizationId = Integer.valueOf(StringUtil.getStringValue(input
				.get(OrganizationParamKeys.ORGANIZATION_ID_KEY)));

		try {
			resultAttributes.put(OrganizationParamKeys.ORGANIZATION_KEY,
					new OrganizationHelper().getOrganization(organizationId));
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "__sys/org/details.jsp";

		LocalLogger.logMethodEnd();
	}
}