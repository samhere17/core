package org.iq.db.dao.organization.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.BasicSearchInput;
import org.iq.Constants.OrganizationStatus;
import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.organization.OrganizationDao;
import org.iq.exception.DbException;
import org.iq.util.StringUtil;
import org.iq.valueobject.organization.Organization;

public class OrganizationDaoImpl extends BaseDaoImpl implements OrganizationDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5087119854129027527L;

	private static final String SELECT_ALL = "SELECT ORGANIZATION_ID, ORGANIZATION_NAME, ORGANIZATION_ALIAS, ORGANIZATION_ADDRESS_1, ORGANIZATION_ADDRESS_2, ORGANIZATION_CITY, ORGANIZATION_DISTRICT, ORGANIZATION_STATE, ORGANIZATION_COUNTRY, ORGANIZATION_PIN, ORGANIZATION_PRIMARY_PHONE, ORGANIZATION_PRIMARY_FAX, ORGANIZATION_PRIMARY_EMAIL, ORGANIZATION_ALTERNATE_PHONE, ORGANIZATION_ALTERNATE_FAX, ORGANIZATION_ALTERNATE_EMAIL, ORGANIZATION_STATUS, ORGANIZATION_CREATION_STAMP, ORGANIZATION_CREATED_BY, ORGANIZATION_UPDATED_STAMP, ORGANIZATION_UPDATED_BY FROM ORGANIZATION";
	private static final String SELECT_BY_ORGANIZATION_ID = "SELECT ORGANIZATION_ID, ORGANIZATION_NAME, ORGANIZATION_ALIAS, ORGANIZATION_ADDRESS_1, ORGANIZATION_ADDRESS_2, ORGANIZATION_CITY, ORGANIZATION_DISTRICT, ORGANIZATION_STATE, ORGANIZATION_COUNTRY, ORGANIZATION_PIN, ORGANIZATION_PRIMARY_PHONE, ORGANIZATION_PRIMARY_FAX, ORGANIZATION_PRIMARY_EMAIL, ORGANIZATION_ALTERNATE_PHONE, ORGANIZATION_ALTERNATE_FAX, ORGANIZATION_ALTERNATE_EMAIL, ORGANIZATION_STATUS, ORGANIZATION_CREATION_STAMP, ORGANIZATION_CREATED_BY, ORGANIZATION_UPDATED_STAMP, ORGANIZATION_UPDATED_BY FROM ORGANIZATION WHERE ORGANIZATION_ID = ?";

	private static final String INSERT_ALL = "INSERT INTO ORGANIZATION (ORGANIZATION_NAME, ORGANIZATION_ALIAS, ORGANIZATION_ADDRESS_1, ORGANIZATION_ADDRESS_2, ORGANIZATION_CITY, ORGANIZATION_DISTRICT, ORGANIZATION_STATE, ORGANIZATION_COUNTRY, ORGANIZATION_PIN, ORGANIZATION_PRIMARY_PHONE, ORGANIZATION_PRIMARY_FAX, ORGANIZATION_PRIMARY_EMAIL, ORGANIZATION_ALTERNATE_PHONE, ORGANIZATION_ALTERNATE_FAX, ORGANIZATION_ALTERNATE_EMAIL, ORGANIZATION_STATUS, ORGANIZATION_CREATION_STAMP, ORGANIZATION_CREATED_BY, ORGANIZATION_UPDATED_STAMP, ORGANIZATION_UPDATED_BY) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String UPDATE_ALL = "UPDATE ORGANIZATION SET ORGANIZATION_NAME = ?, ORGANIZATION_ALIAS = ?, ORGANIZATION_ADDRESS_1 = ?, ORGANIZATION_ADDRESS_2 = ?, ORGANIZATION_CITY = ?, ORGANIZATION_DISTRICT = ?, ORGANIZATION_STATE = ?, ORGANIZATION_COUNTRY = ?, ORGANIZATION_PIN = ?, ORGANIZATION_PRIMARY_PHONE = ?, ORGANIZATION_PRIMARY_FAX = ?, ORGANIZATION_PRIMARY_EMAIL = ?, ORGANIZATION_ALTERNATE_PHONE = ?, ORGANIZATION_ALTERNATE_FAX = ?, ORGANIZATION_ALTERNATE_EMAIL = ?, ORGANIZATION_UPDATED_STAMP = ?, ORGANIZATION_UPDATED_BY = ? WHERE ORGANIZATION_ID = ? ";
	
	private static final String DELETE_BY_ORGANIZATION_ID = "DELETE FROM ORGANIZATION WHERE ORGANIZATION_ID = ? ";
	
	private static final String SELECT_LAST_ORGANIZATION_ID = "SELECT MAX(ORGANIZATION_ID) AS ORGANIZATION_ID FROM ORGANIZATION";
	
	/*
	  
  	ORGANIZATION_ID, ORGANIZATION_NAME, ORGANIZATION_ALIAS, ORGANIZATION_ADDRESS_1, ORGANIZATION_ADDRESS_2, ORGANIZATION_CITY, ORGANIZATION_DISTRICT, ORGANIZATION_STATE, ORGANIZATION_COUNTRY, ORGANIZATION_PIN, ORGANIZATION_PRIMARY_PHONE, ORGANIZATION_PRIMARY_FAX, ORGANIZATION_PRIMARY_EMAIL, ORGANIZATION_ALTERNATE_PHONE, ORGANIZATION_ALTERNATE_FAX, ORGANIZATION_ALTERNATE_EMAIL, ORGANIZATION_STATUS, ORGANIZATION_CREATION_STAMP, ORGANIZATION_CREATED_BY, ORGANIZATION_UPDATED_STAMP, ORGANIZATION_UPDATED_BY
	
	ORGANIZATION_ID					INT NOT NULL AUTO_INCREMENT,
	ORGANIZATION_NAME				VARCHAR(100) NOT NULL,
	ORGANIZATION_ALIAS				VARCHAR(50),
	ORGANIZATION_ADDRESS_1			VARCHAR(200),
	ORGANIZATION_ADDRESS_2			VARCHAR(200),
	ORGANIZATION_CITY				VARCHAR(100),
	ORGANIZATION_DISTRICT			VARCHAR(100),
	ORGANIZATION_STATE				VARCHAR(100),
	ORGANIZATION_COUNTRY			VARCHAR(100),
	ORGANIZATION_PIN				VARCHAR(6),
	ORGANIZATION_PRIMARY_PHONE		VARCHAR(30),
	ORGANIZATION_PRIMARY_FAX		VARCHAR(30),
	ORGANIZATION_PRIMARY_EMAIL		VARCHAR(100),
	ORGANIZATION_ALTERNATE_PHONE	VARCHAR(30),
	ORGANIZATION_ALTERNATE_FAX		VARCHAR(30),
	ORGANIZATION_ALTERNATE_EMAIL	VARCHAR(100),
	ORGANIZATION_STATUS				INT(2),
	ORGANIZATION_CREATION_STAMP		DATETIME NOT NULL,
	ORGANIZATION_CREATED_BY			INT,
	ORGANIZATION_UPDATED_STAMP		DATETIME NOT NULL,
	ORGANIZATION_UPDATED_BY			INT,
  
 */

	public OrganizationDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	/**
	 * ORGANIZATION_ID, ORGANIZATION_ACCESS_KEY, ORGANIZATION_NAME,
	 * ORGANIZATION_ALIAS, ORGANIZATION_ADDRESS_1, ORGANIZATION_ADDRESS_2,
	 * ORGANIZATION_CITY, ORGANIZATION_DISTRICT, ORGANIZATION_STATE,
	 * ORGANIZATION_COUNTRY, ORGANIZATION_PIN, ORGANIZATION_PRIMARY_PHONE,
	 * ORGANIZATION_PRIMARY_FAX, ORGANIZATION_PRIMARY_EMAIL,
	 * ORGANIZATION_ALTERNATE_PHONE, ORGANIZATION_ALTERNATE_FAX,
	 * ORGANIZATION_ALTERNATE_EMAIL, ORGANIZATION_STATUS,
	 * ORGANIZATION_CREATION_STAMP, ORGANIZATION_UPDATED_STAMP,
	 * ORGANIZATION_UPDATED_BY
	 */
	
	
	
	@Override
	public int insertAndGetOrganizationId(Organization organization)
			throws DbException {
		int count = insert(organization);
		if (count==1) {
			return getLastOrganizationId();
		}
		return -1;
	}
	
	public int getLastOrganizationId() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_LAST_ORGANIZATION_ID);

		if (dataSet.getRowCount() > 0) {
			return dataSet.getIntValue(0, "ORGANIZATION_ID");
		}
		return -1;
	}
	@Override
	public int insert(Organization organization) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, organization
				.getOrganizationName(), organization.getOrganizationAlias(),
				organization.getOrganizationAddress1(), organization
						.getOrganizationAddress2(), organization
						.getOrganizationCity(), organization
						.getOrganizationDistrict(), organization
						.getOrganizationState(), organization
						.getOrganizationCountry(), organization
						.getOrganizationPin(), organization
						.getOrganizationPrimaryPhone(), organization
						.getOrganizationPrimaryFax(), organization
						.getOrganizationPrimaryEmail(), organization
						.getOrganizationAlternatePhone(), organization
						.getOrganizationAlternateFax(), organization
						.getOrganizationAlternateEmail(), organization
						.getOrganizationStatus().getOrganizationStatusValue(),
				organization.getOrganizationCreation(), organization
						.getOrganizationCreatedBy(), organization
						.getOrganizationUpdated(), organization
						.getOrganizationUpdatedBy());
	}

	@Override
	public int update(Organization object) throws DbException {
		return dbSession.executeUpdate(UPDATE_ALL,
				object.getOrganizationName(), object.getOrganizationAlias(),
				object.getOrganizationAddress1(),
				object.getOrganizationAddress2(), object.getOrganizationCity(),
				object.getOrganizationDistrict(),object.getOrganizationState(),
				object.getOrganizationCountry(),object.getOrganizationPin(),
				object.getOrganizationPrimaryPhone(),object.getOrganizationPrimaryFax(),
				object.getOrganizationPrimaryEmail(),object.getOrganizationAlternatePhone(),
				object.getOrganizationAlternateFax(),object.getOrganizationAlternateEmail(),
				object.getOrganizationUpdated(),object.getOrganizationUpdatedBy(),object.getOrganizationId());
	}

	@Override
	public List<Organization> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);
		List<Organization> organizations = null;
		if (dataSet.getRowCount() > 0) {
			organizations = new ArrayList<Organization>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				organizations.add(getSingleRow(dataSet, i));
			}
		}
		return organizations;
	}

	@Override
	public Organization selectByOrganizationId(int organizationId)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_ORGANIZATION_ID,
				organizationId);
		if (dataSet.getRowCount() > 0) {
			return getSingleRow(dataSet, 0);
		}
		return null;
	}


	@Override
	public List<Organization> search(BasicSearchInput basicSearchInput)
			throws DbException {
		StringBuilder qryBuilder = generateSearchQuery(basicSearchInput);
		
		DataSet dataSet = dbSession.executeQuery(qryBuilder.toString());
		List<Organization> organizations = null;
		if (dataSet.getRowCount() > 0) {
			organizations = new ArrayList<Organization>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				organizations.add(getSingleRow(dataSet, i));
			}
		}
		return organizations;
	}
	
	private StringBuilder generateSearchQuery(BasicSearchInput basicSearchInput) {
		
			StringBuilder queryBuilder = new StringBuilder();
			
			boolean hasOccured = false;
			
			if (StringUtil.hasText(basicSearchInput.getName())) {
				hasOccured = true;
				queryBuilder.append(SELECT_ALL+" WHERE ");
				queryBuilder.append(" ORGANIZATION_NAME ='" + basicSearchInput.getName() + "'");
			}
			if (StringUtil.hasText(basicSearchInput.getAlias())) {
				hasOccured = populateInnerQuery(hasOccured,queryBuilder);
				queryBuilder.append(" ORGANIZATION_ALIAS ='" + basicSearchInput.getAlias() + "'");
			}
			if (StringUtil.hasText(basicSearchInput.getPrimaryPhone())) {
				hasOccured = populateInnerQuery(hasOccured,queryBuilder);
				queryBuilder.append(" ORGANIZATION_PRIMARY_PHONE ='" + basicSearchInput.getPrimaryPhone() + "'");
			}
			if (StringUtil.hasText(basicSearchInput.getPrimaryFax())) {
				hasOccured = populateInnerQuery(hasOccured,queryBuilder);
				queryBuilder.append(" ORGANIZATION_PRIMARY_FAX ='" + basicSearchInput.getPrimaryFax() + "'");
			}
			if (StringUtil.hasText(basicSearchInput.getPrimaryEmail())) {
				hasOccured = populateInnerQuery(hasOccured,queryBuilder);
				queryBuilder.append(" ORGANIZATION_PRIMARY_EMAIL ='" + basicSearchInput.getPrimaryEmail() + "'");
			}
			if(!hasOccured){
				queryBuilder.append(SELECT_ALL);
			}
			return queryBuilder;
	}

	private boolean populateInnerQuery(boolean hasOccured,
			StringBuilder queryBuilder) {
		
			if(hasOccured){
				hasOccured = true;
				queryBuilder.append(" AND ");
			}else{
				hasOccured = true;
				queryBuilder.append(SELECT_ALL+" WHERE ");
			}
		return hasOccured;
	}

	@Override
	public int delete(Organization object) throws DbException {
		return dbSession.executeUpdate(DELETE_BY_ORGANIZATION_ID,object.getOrganizationId());
	}

	@Override
	public Organization getSingleRow(DataSet dataSet, int rowNum) {
		Organization organization = new Organization();

		organization.setOrganizationId(dataSet.getIntValue(rowNum, "ORGANIZATION_ID"));
		organization.setOrganizationName(dataSet.getStringValue(rowNum, "ORGANIZATION_NAME"));
		organization.setOrganizationAlias(dataSet.getStringValue(rowNum, "ORGANIZATION_ALIAS"));
		organization.setOrganizationAddress1(dataSet.getStringValue(rowNum, "ORGANIZATION_ADDRESS_1"));
		organization.setOrganizationAddress2(dataSet.getStringValue(rowNum, "ORGANIZATION_ADDRESS_2"));
		organization.setOrganizationCity(dataSet.getStringValue(rowNum, "ORGANIZATION_CITY"));
		organization.setOrganizationDistrict(dataSet.getStringValue(rowNum, "ORGANIZATION_DISTRICT"));
		organization.setOrganizationState(dataSet.getStringValue(rowNum, "ORGANIZATION_STATE"));
		organization.setOrganizationCountry(dataSet.getStringValue(rowNum, "ORGANIZATION_COUNTRY"));
		organization.setOrganizationPin(dataSet.getStringValue(rowNum, "ORGANIZATION_PIN"));
		organization.setOrganizationPrimaryPhone(dataSet.getStringValue(rowNum, "ORGANIZATION_PRIMARY_PHONE"));
		organization.setOrganizationPrimaryFax(dataSet.getStringValue(rowNum, "ORGANIZATION_PRIMARY_FAX"));
		organization.setOrganizationPrimaryEmail(dataSet.getStringValue(rowNum, "ORGANIZATION_PRIMARY_EMAIL"));
		organization.setOrganizationAlternatePhone(dataSet.getStringValue(rowNum, "ORGANIZATION_ALTERNATE_PHONE"));
		organization.setOrganizationAlternateFax(dataSet.getStringValue(rowNum, "ORGANIZATION_ALTERNATE_FAX"));
		organization.setOrganizationAlternateEmail(dataSet.getStringValue(rowNum, "ORGANIZATION_ALTERNATE_EMAIL"));
		organization.setOrganizationStatus(OrganizationStatus.getOrganizationStatus(dataSet.getIntValue(rowNum, "ORGANIZATION_STATUS")));
		organization.setOrganizationCreation(dataSet.getDateValue(rowNum,"ORGANIZATION_CREATION_STAMP"));
		organization.setOrganizationCreatedBy(dataSet.getIntValue(rowNum,"ORGANIZATION_CREATED_BY"));
		organization.setOrganizationUpdated(dataSet.getDateValue(rowNum,"ORGANIZATION_UPDATED_STAMP"));
		organization.setOrganizationUpdatedBy(dataSet.getIntValue(rowNum,"ORGANIZATION_UPDATED_BY"));

		return organization;
	}
	
}