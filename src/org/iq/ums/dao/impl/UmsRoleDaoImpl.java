package org.iq.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.impl.SearchCriterion;
import org.iq.db.dao.impl.SearchType;
import org.iq.exception.DbException;
import org.iq.ums.UmsConstants.AreaSpecifier;
import org.iq.ums.UmsConstants.RoleStatus;
import org.iq.ums.dao.UmsRoleDao;
import org.iq.ums.vo.UmsRole;

public class UmsRoleDaoImpl extends BaseDaoImpl<UmsRole> implements UmsRoleDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8612422297118270359L;

	private static final String INSERT_ALL = "INSERT INTO UMS_ROLE (ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_LAST_ROLE_ID = "SELECT MAX(ROLE_ID) AS ROLE_ID FROM UMS_ROLE";
	private static final String SELECT_ALL = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE";

	private static final String UPDATE_ALL_BY_ROLE_ID = "UPDATE UMS_ROLE SET ROLE_NAME = ?, ROLE_DESCRIPTION = ?, ROLE_AREA = ?, ROLE_STATUS = ?, ADDITIONAL_ID = ?, ROLE_UPDATED_TIME = ?, ROLE_UPDATED_BY = ? WHERE ROLE_ID = ?";
	private static final String MARK_DELETE_BY_ID = "UPDATE UMS_ROLE SET ROLE_STATUS = "
			+ RoleStatus.DELETED.getRoleStatusValue()
			+ ", ROLE_UPDATED_TIME = ?, ROLE_UPDATED_BY = ?  WHERE ROLE_ID = ?";

	private static final String SELECT_BY_ROLE_ID = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE WHERE ROLE_ID = ?";

	private static final String SELECT_APP_ROLES = "SELECT ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS, ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME, ROLE_UPDATED_BY FROM UMS_ROLE WHERE ROLE_AREA = "
			+ AreaSpecifier.APPLICATION.getAreaSpecifierValue();

	/*
	 * 
	 * ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION, ROLE_AREA, ROLE_STATUS,
	 * ADDITIONAL_ID, ROLE_CREATION_TIME, ROLE_CREATED_BY, ROLE_UPDATED_TIME,
	 * ROLE_UPDATED_BY
	 * 
	 * ROLE_ID INT NOT NULL AUTO_INCREMENT, ROLE_NAME VARCHAR(50) NOT NULL,
	 * ROLE_DESCRIPTION VARCHAR(500), ROLE_AREA INT(2) NOT NULL, ROLE_STATUS
	 * INT(2) NOT NULL, ADDITIONAL_ID VARCHAR(100), ROLE_CREATION_TIME DATETIME
	 * NOT NULL, ROLE_CREATED_BY INT NOT NULL, ROLE_UPDATED_TIME DATETIME NOT
	 * NULL, ROLE_UPDATED_BY INT NOT NULL,
	 * 
	 */

	public UmsRoleDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public int insert(UmsRole umsRole) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsRole.getRoleName(), umsRole.getRoleDescription(),
				umsRole.getRoleArea().getAreaSpecifierValue(), umsRole.getRoleStatus().getRoleStatusValue(),
				umsRole.getAdditionalId(), umsRole.getRoleCreation(), umsRole.getRoleCreatedBy(),
				umsRole.getRoleUpdated(), umsRole.getRoleUpdatedBy());
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
		return dbSession.executeUpdate(UPDATE_ALL_BY_ROLE_ID, object.getRoleName(), object.getRoleDescription(),
				object.getRoleArea().getAreaSpecifierValue(), object.getRoleStatus().getRoleStatusValue(),
				object.getAdditionalId(), object.getRoleUpdated(), object.getRoleUpdatedBy(), object.getRoleId());
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
	public UmsRole getSingleRow(DataSet dataSet, int rowNum) {
		UmsRole umsRole = new UmsRole();

		umsRole.setRoleId(dataSet.getIntValue(rowNum, "ROLE_ID"));
		umsRole.setRoleName(dataSet.getStringValue(rowNum, "ROLE_NAME"));
		umsRole.setRoleDescription(dataSet.getStringValue(rowNum, "ROLE_DESCRIPTION"));
		umsRole.setRoleArea(AreaSpecifier.getAreaSpecifier(dataSet.getIntValue(rowNum, "ROLE_AREA")));
		umsRole.setRoleStatus(RoleStatus.getRoleStatus(dataSet.getIntValue(rowNum, "ROLE_STATUS")));
		umsRole.setAdditionalId(dataSet.getStringValue(rowNum, "ADDITIONAL_ID"));
		umsRole.setRoleCreation(dataSet.getDateValue(rowNum, "ROLE_CREATION_TIME"));
		umsRole.setRoleCreatedBy(dataSet.getIntValue(rowNum, "ROLE_CREATED_BY"));
		umsRole.setRoleUpdated(dataSet.getDateValue(rowNum, "ROLE_UPDATED_TIME"));
		umsRole.setRoleUpdatedBy(dataSet.getIntValue(rowNum, "ROLE_UPDATED_BY"));

		return umsRole;
	}

	//@Override
	/*public List<UmsRole> search(Integer roleArea, Integer roleId, String roleName) throws DbException {
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
	}*/

	@Override
	public List<UmsRole> search(UmsRole umsRole) throws DbException {
		List<SearchCriterion> searchCriteria = new ArrayList<SearchCriterion>();
		
		searchCriteria.add(new SearchCriterion("ROLE_NAME", umsRole.getRoleName(), SearchType.CONTAINS));
		
		return executeSearch(SELECT_ALL,searchCriteria);
	}

	@Override
	public UmsRole selectByRoleId(int roleId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_ROLE_ID, roleId);
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

	@Override
	public int softDelete(UmsRole umsRole) throws DbException {
		return dbSession.executeUpdate(MARK_DELETE_BY_ID, umsRole.getRoleUpdated(), umsRole.getRoleUpdatedBy(),
				umsRole.getRoleId());
	}

	@Override
	public int hardDelete(UmsRole t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}
}