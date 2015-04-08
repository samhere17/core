package org.iq.db.dao.ums.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.ums.UmsUserDetailsDao;
import org.iq.exception.DbException;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsUserDetails;

/**
 * @author Sam
 * 
 */
public class UmsUserDetailsDaoImpl extends BaseDaoImpl implements
		UmsUserDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1485579035421758517L;

	private static final String UMS_USER_DETAILS_SELECT_BY_USER_ID = "SELECT USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ALIAS, USER_ADDRESS, PRIMARY_PHONE, PRIMARY_EMAIL, ALTERNATE_PHONE, ALTERNATE_EMAIL, GENDER, DATE_OF_BIRTH_STAMP, ANNIVERSARY_STAMP FROM UMS_USER_DETAILS WHERE USER_ID = ?";
	
	private static final String UMS_USER_DETAILS_SELECT_ALL = "SELECT USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ALIAS, USER_ADDRESS, PRIMARY_PHONE, PRIMARY_EMAIL, ALTERNATE_PHONE, ALTERNATE_EMAIL, GENDER, DATE_OF_BIRTH_STAMP, ANNIVERSARY_STAMP FROM UMS_USER_DETAILS";

	private static final String UMS_USER_DETAILS_SELECT_BY_EMAIL = "SELECT USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ALIAS, USER_ADDRESS, PRIMARY_PHONE, PRIMARY_EMAIL, ALTERNATE_PHONE, ALTERNATE_EMAIL, GENDER, DATE_OF_BIRTH_STAMP, ANNIVERSARY_STAMP FROM UMS_USER_DETAILS WHERE PRIMARY_EMAIL = ?";

	private static final String INSERT_ALL = "INSERT INTO UMS_USER_DETAILS (USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ALIAS, USER_ADDRESS, PRIMARY_PHONE, PRIMARY_EMAIL, ALTERNATE_PHONE, ALTERNATE_EMAIL, GENDER, DATE_OF_BIRTH_STAMP, ANNIVERSARY_STAMP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

//	private static final String UMS_USER_DETAILS_UPDATE_ALL_BY_USER_ID = "UPDATE UMS_USER_DETAILS SET USER_FIRST_NAME = ?, USER_LAST_NAME = ?, USER_ALIAS = ?, PRIMARY_PHONE = ?, PRIMARY_EMAIL = ?, ALTERNATE_PHONE = ?, ALTERNATE_EMAIL = ?, GENDER = ? , DATE_OF_BIRTH_STAMP = ?, ANNIVERSARY_STAMP = ? WHERE USER_ID = ?";
	
//	private static final String UMS_USER_DETAILS_DELETE_BY_USER_ID = "DELETE FROM UMS_USER_DETAILS WHERE USER_ID = ?";
	
	/*
	
	USER_ID, USER_FIRST_NAME, USER_LAST_NAME, USER_ALIAS, USER_ADDRESS, PRIMARY_PHONE, PRIMARY_EMAIL, ALTERNATE_PHONE, ALTERNATE_EMAIL, GENDER, DATE_OF_BIRTH_STAMP, ANNIVERSARY_STAMP

	USER_ID				INT NOT NULL,
	USER_FIRST_NAME		VARCHAR(100),
	USER_LAST_NAME		VARCHAR(100),
	USER_ALIAS			VARCHAR(50),
	USER_ADDRESS		VARCHAR(500),
	PRIMARY_PHONE		VARCHAR(30),
	PRIMARY_EMAIL		VARCHAR(100),
	ALTERNATE_PHONE		VARCHAR(30),
	ALTERNATE_EMAIL		VARCHAR(100),
	GENDER				TINYINT(1),
	DATE_OF_BIRTH_STAMP	TIMESTAMP,
	ANNIVERSARY_STAMP	TIMESTAMP,
	
	 */

	/**
	 * 
	 * @param dbSession
	 */
	public UmsUserDetailsDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public UmsUserDetails getUserDetailsByUserId(int userId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				UMS_USER_DETAILS_SELECT_BY_USER_ID, userId);

		UmsUserDetails userDetails = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			userDetails = (UmsUserDetails) getSingleRow(dataSet, 0);
		}

		return userDetails;
	}

	@Override
	public UmsUserDetails getUserDetailsByEmail(String email)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				UMS_USER_DETAILS_SELECT_BY_EMAIL, email);

		UmsUserDetails userDetails = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			userDetails = getSingleRow(dataSet, 0);
		}

		return userDetails;
	}

	@Override
	public int insert(UmsUserDetails umsUserDetails) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsUserDetails.getUserId(),
				umsUserDetails.getUserFirstName(), umsUserDetails
						.getUserLastName(), umsUserDetails.getUserAlias(),
				umsUserDetails.getAddress(), umsUserDetails.getPrimaryPhone(),
				umsUserDetails.getPrimaryEmail(), umsUserDetails
						.getAlternatePhone(), umsUserDetails
						.getAlternateEmail(), umsUserDetails.getGender()
						.getGenderValue(), umsUserDetails.getDateOfBirth(),
				umsUserDetails.getAnniversary());
	}

	@Override
	public int update(UmsUserDetails umsUserDetails) throws DbException {
		return dbSession.executeUpdate(/*UMS_USER_DETAILS_UPDATE_ALL_BY_USER_ID*/"", 
				umsUserDetails.getUserFirstName(),
				umsUserDetails.getUserLastName(),
				umsUserDetails.getUserAlias(),
				umsUserDetails.getPrimaryPhone(),
				umsUserDetails.getPrimaryEmail(),
				umsUserDetails.getAlternatePhone(),
				umsUserDetails.getAlternateEmail(), 
				umsUserDetails.getGender(),
				umsUserDetails.getDateOfBirth(),
				umsUserDetails.getAnniversary(),
				umsUserDetails.getUserId());
	}

	@Override
	public List<UmsUserDetails> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(UMS_USER_DETAILS_SELECT_ALL);
		List<UmsUserDetails> umsUserDetails = null;
		if (dataSet.getRowCount() > 0) {
			umsUserDetails = new ArrayList<UmsUserDetails>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsUserDetails.add(getSingleRow(dataSet, i));
			}
		}
		return null;
	}

	@Override
	public int delete(UmsUserDetails object) throws DbException {
		return dbSession.executeUpdate(/*UMS_USER_DETAILS_DELETE_BY_USER_ID*/"", object.getUserId());
	}

	@Override
	public UmsUserDetails getSingleRow(DataSet dataSet, int rowNum) {
		UmsUserDetails userDetails = new UmsUserDetails();
		userDetails.setUserId(dataSet.getIntValue(rowNum, "USER_ID"));
		userDetails.setUserFirstName(dataSet.getStringValue(rowNum, "USER_FIRST_NAME"));
		userDetails.setUserLastName(dataSet.getStringValue(rowNum, "USER_LAST_NAME"));
		userDetails.setUserAlias(dataSet.getStringValue(rowNum, "USER_ALIAS"));
		userDetails.setAddress(dataSet.getStringValue(rowNum, "USER_ADDRESS"));
		userDetails.setPrimaryPhone(dataSet.getStringValue(rowNum, "PRIMARY_PHONE"));
		userDetails.setPrimaryEmail(dataSet.getStringValue(rowNum, "PRIMARY_EMAIL"));
		userDetails.setAlternatePhone(dataSet.getStringValue(rowNum, "ALTERNATE_PHONE"));
		userDetails.setAlternateEmail(dataSet.getStringValue(rowNum, "ALTERNATE_EMAIL"));
		userDetails.setGenderValue(dataSet.getIntValue(rowNum, "GENDER"));
		userDetails.setDateOfBirth(dataSet.getDateValue(rowNum, "DATE_OF_BIRTH_STAMP"));
		userDetails.setAnniversary(dataSet.getDateValue(rowNum, "ANNIVERSARY_STAMP"));

		return userDetails;

	}

	@Override
	public List<UmsUserDetails> search(String additionalId, String userId,
			String username, String firstname, String lastname, String phone,
			String email, Integer roleId) throws DbException {
		String qryBuilder = generateSearchQuery(additionalId, userId, username,
				firstname, lastname, phone, email, roleId);

		DataSet dataSet = dbSession.executeQuery(qryBuilder);
		List<UmsUserDetails> umsUserDetailsList = null;
		if (dataSet.getRowCount() > 0) {
			umsUserDetailsList = new ArrayList<UmsUserDetails>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsUserDetailsList.add(getSingleRow(dataSet, i));
			}
		}
		return umsUserDetailsList;
	}
	
	private String generateSearchQuery(String additionalId, String userId,
			String username, String firstname, String lastname, String phone,
			String email, Integer roleId) {

		StringBuilder query = new StringBuilder();

		query.append(UMS_USER_DETAILS_SELECT_ALL);

		boolean hasOccured = false;

		StringBuilder innerQuery = new StringBuilder();
		if (StringUtil.hasText(additionalId) || StringUtil.hasText(userId)
				|| StringUtil.hasText(username)) {

			innerQuery.append("SELECT USER_ID FROM UMS_USER");

			boolean innerHasOccured = false;

			if (StringUtil.hasText(additionalId)) {
				innerQuery.append(getWhereOrAnd(innerHasOccured));
				innerQuery.append(getCriteriaString("ADDITIONAL_ID",
						additionalId, SearchType.EQUALS));
				innerHasOccured = true;
			}

			if (StringUtil.hasText(userId)) {
				innerQuery.append(getWhereOrAnd(innerHasOccured));
				innerQuery.append(getCriteriaString("USER_ID", userId,
						SearchType.CONTAINS));
				innerHasOccured = true;
			}

			if (StringUtil.hasText(username)) {
				innerQuery.append(getWhereOrAnd(innerHasOccured));
				innerQuery.append(getCriteriaString("USERNAME", username,
						SearchType.CONTAINS));
				innerHasOccured = true;
			}
		}		
		
		if (StringUtil.hasText(StringUtil.getStringValue(roleId))) {
			String moreInner = innerQuery.toString();
			innerQuery = new StringBuilder();
			innerQuery.append("SELECT USER_ID FROM UMS_USER_ROLE_MAP WHERE USER_ID IN (");
			innerQuery.append(moreInner);
			innerQuery.append(") AND ");
			innerQuery.append(getCriteriaString("ROLE_ID",
					StringUtil.getStringValue(roleId), SearchType.EQUALS));
		}
		
		
		if (StringUtil.hasText(innerQuery.toString())) {
			query.append(" WHERE USER_ID IN (");
			query.append(innerQuery);
			query.append(")");
			hasOccured = true;
		}

		
		if (StringUtil.hasText(firstname)) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("USER_FIRST_NAME", firstname, SearchType.CONTAINS));
			hasOccured = true;
		}

		if (StringUtil.hasText(lastname)) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("USER_LAST_NAME", lastname, SearchType.CONTAINS));
			hasOccured = true;
		}

		if (StringUtil.hasText(phone)) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("PRIMARY_PHONE", phone, SearchType.CONTAINS));
			hasOccured = true;
		}

		if (StringUtil.hasText(email)) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("PRIMARY_EMAIL", email, SearchType.CONTAINS));
			hasOccured = true;
		}

		return query.toString();
	}

	private String getWhereOrAnd(boolean hasOccured) {
		return hasOccured?" AND ":" WHERE ";
	}
	
	private String getCriteriaString(String columnName, String criteria,
			SearchType searchType) {
		switch (searchType) {
		case EQUALS:
			return columnName + " = " + criteria;
		case STARTS_WITH:
			return columnName + " LIKE '" + criteria + "%'";
		case ENDS_WITH:
			return columnName + " LIKE '%" + criteria + "'";
		case CONTAINS:
		default:
			return columnName + " LIKE '%" + criteria + "%'";
		}
	}
	
	enum SearchType {
		STARTS_WITH, CONTAINS, ENDS_WITH, EQUALS;
	}


}