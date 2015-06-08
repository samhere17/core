package org.iq.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.exception.DbException;
import org.iq.ums.dao.UmsUserRoleMapDao;
import org.iq.ums.vo.UmsUserRoleMap;

public class UmsUserRoleMapDaoImpl extends BaseDaoImpl implements
		UmsUserRoleMapDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4393889684241471651L;
	private static final String SELECT_ALL = "SELECT USER_ID, ROLE_ID FROM UMS_USER_ROLE_MAP";
	private static final String SELECT_BY_USER_ID = "SELECT USER_ID, ROLE_ID FROM UMS_USER_ROLE_MAP WHERE USER_ID = ?";
	private static final String INSERT_ALL = "INSERT INTO UMS_USER_ROLE_MAP (USER_ID, ROLE_ID) VALUES (?, ?)";
//	private static final String DELETE_BY_USER_ID = "DELETE FROM UMS_USER_ROLE_MAP WHERE USER_ID = ?";
//	private static final String DELETE_BY_ROLE_ID = "DELETE FROM UMS_USER_ROLE_MAP WHERE ROLE_ID = ?";

	/*

	USER_ID, ROLE_ID

	USER_ID			INT NOT NULL,
	ROLE_ID			INT NOT NULL,

	 */


	public UmsUserRoleMapDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public int insert(UmsUserRoleMap umsUserRoleMap) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsUserRoleMap.getUserId(),
				umsUserRoleMap.getRoleId());
	}

	@Override
	public int update(UmsUserRoleMap object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UmsUserRoleMap> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);
		List<UmsUserRoleMap> umsUserRoleMap = null;
		if (dataSet.getRowCount() > 0) {
			umsUserRoleMap = new ArrayList<UmsUserRoleMap>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsUserRoleMap.add(getSingleRow(dataSet, i));
			}
		}
		return umsUserRoleMap;
	}

	@Override
	public UmsUserRoleMap selectByUserId(int userId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_USER_ID, userId);
		return getSingleRow(dataSet, 0);
	}

	@Override
	public int delete(UmsUserRoleMap object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UmsUserRoleMap getSingleRow(DataSet dataSet, int rowNum) {
		UmsUserRoleMap umsUserRoleMap = new UmsUserRoleMap();

		umsUserRoleMap.setUserId(dataSet.getIntValue(rowNum, "USER_ID"));
		umsUserRoleMap.setRoleId(dataSet.getIntValue(rowNum, "ROLE_ID"));
		
		return umsUserRoleMap;
	}
}