package org.iq.helper.organization;

import java.util.Date;
import java.util.List;

import org.iq.BasicSearchInput;
import org.iq.Constants.OrganizationStatus;
import org.iq.db.dao.organization.OrganizationDao;
import org.iq.db.dao.organization.impl.OrganizationDaoImpl;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.util.system.CoreDbProvider;
import org.iq.valueobject.organization.Organization;

public class OrganizationHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7588016512736391623L;
	
	public OrganizationHelper() throws BusinessException {
		super(CoreDbProvider.getDbSession());
	}

	/**
	 * @param organizationName
	 * @param organizationAlias
	 * @param organizationAddress1
	 * @param organizationAddress2
	 * @param organizationCity
	 * @param organizationDistrict
	 * @param organizationState
	 * @param organizationCountry
	 * @param organizationPin
	 * @param organizationPrimaryPhone
	 * @param organizationPrimaryFax
	 * @param organizationPrimaryEmail
	 * @param organizationAlternatePhone
	 * @param organizationAlternateFax
	 * @param organizationAlternateEmail
	 * @param userId
	 * @return Organization
	 * @throws BusinessException
	 */
	public Organization createOrganization(String organizationName,
			String organizationAlias, String organizationAddress1,
			String organizationAddress2, String organizationCity,
			String organizationDistrict, String organizationState,
			String organizationCountry, String organizationPin,
			String organizationPrimaryPhone, String organizationPrimaryFax,
			String organizationPrimaryEmail, String organizationAlternatePhone, String organizationAlternateFax,
			String organizationAlternateEmail, int userId) throws BusinessException {

			 //TODO Need to validate the input first
			
			Organization organization = populateOrganizationDetails(organizationName,
					organizationAlias, organizationAddress1,
					organizationAddress2, organizationCity,
					organizationDistrict, organizationState,
					organizationCountry, organizationPin,
					organizationPrimaryPhone, organizationPrimaryFax,
					organizationPrimaryEmail, organizationAlternatePhone, organizationAlternateFax,
					organizationAlternateEmail, userId);
			
			organization.setOrganizationStatus(OrganizationStatus.NEW);
			organization.setOrganizationCreation(new Date());
			organization.setOrganizationCreatedBy(userId);
			organization.setOrganizationUpdated(new Date());
					
			OrganizationDao organizationDao = new OrganizationDaoImpl(dbSession);
			try {
				organization.setOrganizationId(organizationDao.insertAndGetOrganizationId(organization));
	//			System.out.println("Created Organization ID  : " + organization.getOrganizationId());
			} catch (DbException e) {
				// e.printStackTrace();
				throw new BusinessException(e);
			}
			
			return organization;
	}
	
	/**
	 * @param orgId
	 * @param organizationName
	 * @param organizationAlias
	 * @param organizationAddress1
	 * @param organizationAddress2
	 * @param organizationCity
	 * @param organizationDistrict
	 * @param organizationState
	 * @param organizationCountry
	 * @param organizationPin
	 * @param organizationPrimaryPhone
	 * @param organizationPrimaryFax
	 * @param organizationPrimaryEmail
	 * @param organizationAlternatePhone
	 * @param organizationAlternateFax
	 * @param organizationAlternateEmail
	 * @param userId
	 * @return Organization
	 * @throws BusinessException
	 */
	public Organization updateOrganization(int orgId, String organizationName,
			String organizationAlias, String organizationAddress1,
			String organizationAddress2, String organizationCity,
			String organizationDistrict, String organizationState,
			String organizationCountry, String organizationPin,
			String organizationPrimaryPhone, String organizationPrimaryFax,
			String organizationPrimaryEmail, String organizationAlternatePhone, String organizationAlternateFax,
			String organizationAlternateEmail,int userId) throws BusinessException {
		
		Organization organization = populateOrganizationDetails(organizationName,
				organizationAlias, organizationAddress1,
				organizationAddress2, organizationCity,
				organizationDistrict, organizationState,
				organizationCountry, organizationPin,
				organizationPrimaryPhone, organizationPrimaryFax,
				organizationPrimaryEmail, organizationAlternatePhone, organizationAlternateFax,
				organizationAlternateEmail, userId);
		
		organization.setOrganizationId(orgId);
		organization.setOrganizationStatus(OrganizationStatus.NEW);
		organization.setOrganizationCreatedBy(userId);
		organization.setOrganizationUpdated(new Date());
		OrganizationDao organizationDao = new OrganizationDaoImpl(dbSession);
		
		try {
			organization.setOrganizationId(organizationDao.update(organization));
//			System.out.println("Created Organization ID  : " + organization.getOrganizationId());
		} catch (DbException e) {
			// e.printStackTrace();
			throw new BusinessException(e);
		}
		
		return organization;
		
	}

	private Organization populateOrganizationDetails(String organizationName,
			String organizationAlias, String organizationAddress1,
			String organizationAddress2, String organizationCity,
			String organizationDistrict, String organizationState,
			String organizationCountry, String organizationPin,
			String organizationPrimaryPhone, String organizationPrimaryFax,
			String organizationPrimaryEmail, String organizationAlternatePhone, String organizationAlternateFax,
			String organizationAlternateEmail, int userId){
		
			Organization organization = new Organization();
		
			organization.setOrganizationName(organizationName);
			organization.setOrganizationAlias(organizationAlias);
			organization.setOrganizationAddress1(organizationAddress1);
			organization.setOrganizationAddress2(organizationAddress2);
			organization.setOrganizationCity(organizationCity);
			organization.setOrganizationDistrict(organizationDistrict);
			organization.setOrganizationState(organizationState);
			organization.setOrganizationCountry(organizationCountry);
			organization.setOrganizationPin(organizationPin);
			organization.setOrganizationPrimaryPhone(organizationPrimaryPhone);
			organization.setOrganizationPrimaryFax(organizationPrimaryFax);
			organization.setOrganizationPrimaryEmail(organizationPrimaryEmail);
			organization.setOrganizationAlternatePhone(organizationAlternatePhone);
			organization.setOrganizationAlternateFax(organizationAlternateFax);
			organization.setOrganizationAlternateEmail(organizationAlternateEmail);
			organization.setOrganizationUpdatedBy(userId);

			return organization;
		
	}

	/**
	 * @return List<Organization>
	 * @throws BusinessException
	 */
	public List<Organization> getAllOrganization() throws BusinessException {
		OrganizationDao organizationDao = new OrganizationDaoImpl(dbSession);
		try {
			return organizationDao.select();
		} catch (DbException e) {
			// e.printStackTrace();
			throw new BusinessException(e);
		}
	}

	public Organization getOrganization(int orgId) throws BusinessException {
		OrganizationDao organizationDao = new OrganizationDaoImpl(dbSession);
		try {
			return organizationDao.selectByOrganizationId(orgId);
		} catch (DbException e) {
			// e.printStackTrace();
			throw new BusinessException(e);
		}
	}

	public List<Organization> getSearchedOrganization(BasicSearchInput basicSearchInput) throws BusinessException {
		OrganizationDao organizationDao = new OrganizationDaoImpl(dbSession);
		try {
			return organizationDao.search(basicSearchInput);
		} catch (DbException e) {
			// e.printStackTrace();
			throw new BusinessException(e);
		}
	}

}
