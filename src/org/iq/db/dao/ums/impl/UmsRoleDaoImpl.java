package org.iq.db.dao.ums.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.UmsConstants.AreaSpecifier;
import org.iq.UmsConstants.RoleStatus;
import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.ums.UmsRoleDao;
import org.iq.exception.DbException;
import org.iq.util.StringUtil;
import org.iq.valueobject.ums.UmsRole;

public class UmsRoleDaoImpl extends BaseDaoImpl implements UmsRoleDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8612422297118270359L;
	
	private static final String INSERT_ALL = "INSERT INTO UMS_ROLE (ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_LAST_ROLE_ID = "SELECT MAX(ROLE_ID) AS ROLE_ID FROM UMS_ROLE";
	private static final String SELECT_ALL = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE";

	private static final String UPDATE_ALL_BY_ROLE_ID = "UPDATE UMS_ROLE SET ROLE_NAME = ?, ROLE_DESCRIPTION = ?, ROLE_AREA = ?, ROLE_STATUS = ?, ADDITIONAL_ID = ?, ROLE_UPDATED_BY = ? WHERE ROLE_ID = ?";
	private static final String DELETE_BY_ROLE_ID = "DELETE FROM UMS_ROLE WHERE ROLE_ID = ?";

	private static final String SELECT_BY_ROLE_ID = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE WHERE ROLE_ID = ?";

	private static final String SELECT_APP_ROLES = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE WHERE ROLE_AREA = 1";


	/*

	ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY

	ROLE_ID				INT NOT NULL AUTO_INCREMENT,
	ROLE_NAME			VARCHAR(50) NOT NULL,
	ROLE_DESCRIPTION	VARCHAR(500),
	ROLE_AREA			INT(2) NOT NULL,
	ROLE_STATUS			INT(2) NOT NULL,
	ADDITIONAL_ID		VARCHAR(100),
	ROLE_CREATION_TIME	DATETIME NOT NULL,
	ROLE_CREATED_BY		INT NOT NULL,
	ROLE_UPDATED_TIME	DATETIME NOT NULL,
	ROLE_UPDATED_BY		INT NOT NULL,

	 */

	public UmsRoleDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public int insert(UmsRole umsRole) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsRole.getRoleName(),
				umsRole.getRoleDescription(), umsRole.getRoleArea()
						.getAreaSpecifierValue(), umsRole.getRoleStatus()
						.getRoleStatusValue(), umsRole.getAdditionalId(),
				umsRole.getRoleCreation(), umsRole.getRoleCreatedBy(), umsRole
						.getRoleUpdated(), umsRole.getRoleUpdatedBy());
	}

	@Override
	public int insertAndGetRoleId(UmsRole umsRole) throws DbException {
		int count = insert(umsRole);
		if (count == 1) {
			return getLastRoleId();
		}
		return -1;
	}

	public int getLastRoleId() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_LAST_ROLE_ID);

		if (dataSet.getRowCount() > 0) {
			return dataSet.getIntValue(0, "ROLE_ID");
		}
		return -1;
	}

	@Override
	public int update(UmsRole object) throws DbException {
		return dbSession.executeUpdate(UPDATE_ALL_BY_ROLE_ID, object
				.getRoleName(), object.getRoleDescription(), object
				.getRoleArea().getAreaSpecifierValue(), object
				.getRoleStatus().getRoleStatusValue(),
				object.getAdditionalId(), object.getRoleUpdatedBy(), object
						.getRoleId());
	}

	@Override
	public List<UmsRole> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);
		List<UmsRole> umsRole = null;
		if (dataSet.getRowCount() > 0) {
			umsRole = new ArrayList<UmsRole>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsRole.add(getSingleRow(dataSet, i));
			}
		}
		return umsRole;
	}

	@Override
	public int delete(UmsRole object) throws DbException {
		return dbSession.executeUpdate(DELETE_BY_ROLE_ID, object.getRoleId());
	}
	
	@Override
	public UmsRole getSingleRow(DataSet dataSet, int rowNum) {
		UmsRole umsRole = new UmsRole();
		
		umsRole.setRoleId(dataSet.getIntValue(rowNum, "ROLE_ID"));
		umsRole.setRoleName(dataSet.getStringValue(rowNum, "ROLE_NAME"));
		umsRole.setRoleDescription(dataSet.getStringValue(rowNum,
				"ROLE_DESCRIPTION"));
		umsRole.setRoleArea(AreaSpecifier.getAreaSpecifier(dataSet
				.getIntValue(rowNum, "ROLE_AREA")));
		umsRole.setRoleStatus(RoleStatus.getRoleStatus(dataSet.getIntValue(
				rowNum, "ROLE_STATUS")));
		umsRole.setAdditionalId(dataSet.getStringValue(rowNum, "ADDITIONAL_ID"));
		umsRole.setRoleCreation(dataSet.getDateValue(rowNum,
				"ROLE_CREATION_TIME"));
		umsRole.setRoleCreatedBy(dataSet.getIntValue(rowNum, "ROLE_CREATED_BY"));
		umsRole.setRoleUpdated(dataSet.getDateValue(rowNum,
				"ROLE_UPDATED_TIME"));
		umsRole.setRoleUpdatedBy(dataSet.getIntValue(rowNum, "ROLE_UPDATED_BY"));

		return umsRole;
	}

	@Override
	public List<UmsRole> search(Integer roleArea, Integer roleId, String roleName)
			throws DbException {
		String query = generateSearchQuery(roleArea, roleId, roleName);

		DataSet dataSet = dbSession.executeQuery(query);
		List<UmsRole> umsRoles = null;
		if (dataSet.getRowCount() > 0) {
			umsRoles = new ArrayList<UmsRole>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsRoles.add(getSingleRow(dataSet, i));
			}
		}
		return umsRoles;
	}
	
	private String generateSearchQuery(Integer roleArea, Integer roleId, String roleName) {

		StringBuilder query = new StringBuilder();

		query.append(SELECT_ALL);

		boolean hasOccured = false;

		if (StringUtil.hasText(StringUtil.getStringValue(roleArea))) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("ROLE_AREA",
					StringUtil.getStringValue(roleArea), SearchType.EQUALS));
			hasOccured = true;
		}

		if (StringUtil.hasText(StringUtil.getStringValue(roleId))) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("ROLE_ID",
					StringUtil.getStringValue(roleId), SearchType.CONTAINS));
			hasOccured = true;
		}

		if (StringUtil.hasText(roleName)) {
			query.append(getWhereOrAnd(hasOccured));
			query.append(getCriteriaString("ROLE_NAME", roleName,
					SearchType.CONTAINS));
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

	@Override
	public UmsRole selectByRoleId(int roleId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_ROLE_ID,
				roleId);
		if (dataSet.getRowCount() > 0) {
			return getSingleRow(dataSet, 0);
		}
		return null;
	}
	
	@Override
	public List<UmsRole> selectAppRoles() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_APP_ROLES);
		List<UmsRole> umsRole = null;
		if (dataSet.getRowCount() > 0) {
			umsRole = new ArrayList<UmsRole>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsRole.add(getSingleRow(dataSet, i));
			}
		}
		return umsRole;
	}
}