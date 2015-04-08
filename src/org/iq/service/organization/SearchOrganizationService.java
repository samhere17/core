package org.iq.service.organization;

import java.util.HashMap;

import org.iq.BasicSearchInput;
import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;

@Service(name="SearchOrganization")
public class SearchOrganizationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3057102570265452858L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

//		String organizationStatus = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_STATUS_KEY));
		String organizationName = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_NAME_KEY));
		String organizationAlias = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ALIAS_KEY));

		String organizationPrimaryPhone = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_PHONE_KEY));
		String organizationPrimaryFax = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_FAX_KEY));
		String organizationPrimaryEmail = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_EMAIL_KEY));
		
		BasicSearchInput basicSearchInput = new BasicSearchInput();
		
		basicSearchInput.setName(organizationName);
		basicSearchInput.setAlias(organizationAlias);
		
		basicSearchInput.setPrimaryPhone(organizationPrimaryPhone);
		basicSearchInput.setPrimaryFax(organizationPrimaryFax);
		basicSearchInput.setPrimaryEmail(organizationPrimaryEmail);
		
		
		try {
			resultAttributes.put("organizationList", new OrganizationHelper().getSearchedOrganization(basicSearchInput));
		} catch (BusinessException e) {
			// e.printStackTrace();
			throw new ServiceException(e);
		}

//		redirectUrl = "__sys/org/list.jsp";
		redirectUrl = "__sys/org/search.jsp";

		LocalLogger.logMethodEnd();
	}
}