package org.iq.service.organization;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;

public class ListOrganizationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -608533421641620904L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		try {
			resultAttributes.put("organizationList", new OrganizationHelper().getAllOrganization());
		} catch (BusinessException e) {
			// e.printStackTrace();
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}
}