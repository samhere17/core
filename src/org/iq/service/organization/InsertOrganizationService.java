package org.iq.service.organization;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.organization.OrganizationHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;
import org.iq.valueobject.organization.Organization;

@Service(name="InsertOrganization")
public class InsertOrganizationService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -92743573380502163L;
	
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		String organizationName = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_NAME_KEY));
		String organizationAlias = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ALIAS_KEY));

		String organizationAddress1 = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ADDRESS_1_KEY));
		String organizationAddress2 = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ADDRESS_2_KEY));
		String organizationCity = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_CITY_KEY));
		String organizationDistrict = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_DISTRICT_KEY));
		String organizationState = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_STATE_KEY));
		String organizationCountry = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_COUNTRY_KEY));
		String organizationPin = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PIN_KEY));
		
		String organizationPrimaryPhone = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_PHONE_KEY));
		String organizationPrimaryFax = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_FAX_KEY));
		String organizationPrimaryEmail = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_PRIMARY_EMAIL_KEY));
		
		String organizationAlternatePhone = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ALTERNATE_PHONE_KEY));
		String organizationAlternateFax = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ALTERNATE_FAX_KEY));
		String organizationAlternateEmail = StringUtil.getStringValue(input.get(OrganizationParamKeys.ORGANIZATION_ALTERNATE_EMAIL_KEY));
		
//		int userId = 1;//umsSession.getUserDetails().getUserId();
		int userId = umsSession.getUserDetails().getUserId();

		Organization organization =  new Organization();
		try {
			organization = 
			
			//resultAttributes.put(OrganizationParamKeys.ORGANIZATION_KEY, 
			new OrganizationHelper().createOrganization(organizationName,
					organizationAlias, organizationAddress1, organizationAddress2,
					organizationCity, organizationDistrict, organizationState,
					organizationCountry, organizationPin, organizationPrimaryPhone,
					organizationPrimaryFax, organizationPrimaryEmail,
					organizationAlternatePhone, organizationAlternateFax,
					organizationAlternateEmail, userId);
		} catch (BusinessException e) {
			// e.printStackTrace();
			throw new ServiceException(e);
		}
		
		//redirectUrl = "__sys/org/details.jsp";
		
		redirectUrl = "adapter?serviceName=GetOrganization&path=__sys/org/details&orgId="+organization.getOrganizationId();
		LocalLogger.logMethodEnd();
	}
}