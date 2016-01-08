package org.iq.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.exception.DbException;
import org.iq.ums.dao.UmsOptionDao;
import org.iq.ums.dao.UmsRoleOptionMapDao;
import org.iq.ums.vo.UmsOption;
import org.iq.ums.vo.UmsRoleOptionMap;
import org.iq.util.StringUtil;

public class UmsRoleOptionMapDaoImpl extends BaseDaoImpl<UmsRoleOptionMap> implements UmsRoleOptionMapDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5894304235014205942L;
	private static final String INSERT_ALL = "INSERT INTO UMS_ROLE_OPTION_MAP (ROLE_ID, OPTION_ID, ENABLE) VALUES (?, ?, ?)";
	private static final String UPDATE_ALL_BY_ROLE_ID = "UPDATE UMS_ROLE_OPTION_MAP SET ENABLE = ? WHERE ROLE_ID = ? AND OPTION_ID = ?";
	private static final String SELECT_ALL = "SELECT ROLE_ID, OPTION_ID, ENABLE FROM UMS_ROLE_OPTION_MAP";
	private static final String SELECT_ALL_BY_ROLE_ID = "SELECT ROLE_ID, OPTION_ID, ENABLE FROM UMS_ROLE_OPTION_MAP WHERE ROLE_ID = ?";
	private static final String DELETE_BY_ROLE_ID = "DELETE FROM UMS_ROLE_OPTION_MAP WHERE ROLE_ID = ?";

	/*
	 * 
	 * ROLE_ID, OPTION_ID, ENABLE
	 * 
	 * ROLE_ID INT NOT NULL, OPTION_ID INT NOT NULL, ENABLE TINYINT(1) NOT NULL
	 * 
	 */

	public UmsRoleOptionMapDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public int insert(UmsRoleOptionMap umsRoleOptionMap) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsRoleOptionMap.getRoleId(), umsRoleOptionMap.getOptionId(),
				umsRoleOptionMap.isEnabled());
	}

	@Override
	public int insertMultiple(int roleId, Map<Integer, Boolean> optionsMap) throws DbException {

		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO UMS_ROLE_OPTION_MAP (ROLE_ID, OPTION_ID, ENABLE) VALUES ");

		// Getting all options from ums option table
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		List<UmsOption> umsOptions = umsOptionDao.select();

		if (umsOptions != null && umsOptions.size() > 0) {
			boolean first = true;
			for (UmsOption umsOption : umsOptions) {
				if (!first) {
					query.append(",");
				}
				query.append("(");
				query.append(roleId);
				query.append(",");
				query.append(umsOption.getOptionId());
				query.append(",");
				if (optionsMap.get(umsOption.getOptionId()) != null && optionsMap.get(umsOption.getOptionId())) {
					query.append(1);
				} else {
					query.append(0);
				}
				query.append(")");
				first = false;
			}
		}
		return dbSession.executeUpdate(query.toString());
	}

	@Override
	public int update(UmsRoleOptionMap umsRoleOptionMap) throws DbException {
		return dbSession.executeUpdate(UPDATE_ALL_BY_ROLE_ID, umsRoleOptionMap.isEnabled(),
				umsRoleOptionMap.getRoleId(), umsRoleOptionMap.getOptionId());
	}

	@Override
	public int updateMultiple(int roleId, Map<Integer, Boolean> optionsMap) throws DbException {
		StringBuilder trueForIn = new StringBuilder();
		StringBuilder falseForIn = new StringBuilder();

		// Getting all options from ums option table
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		List<UmsOption> umsOptions = umsOptionDao.select();

		if (umsOptions != null && umsOptions.size() > 0) {
			boolean firstTrue = true;
			boolean firstFalse = true;
			for (UmsOption umsOption : umsOptions) {
				if (optionsMap.get(umsOption.getOptionId()) != null && optionsMap.get(umsOption.getOptionId())) {
					if (!firstTrue) {
						trueForIn.append(",");
					}
					trueForIn.append(umsOption.getOptionId());
					firstTrue = false;
				} else {
					if (!firstFalse) {
						falseForIn.append(",");
					}
					falseForIn.append(umsOption.getOptionId());
					firstFalse = false;
				}
			}
		}

		int count = 0;
		StringBuilder query = new StringBuilder();

		// Updating true values
		if (StringUtil.isEmpty(trueForIn.toString()) == false) {
			query.append("UPDATE UMS_ROLE_OPTION_MAP SET ENABLE = 1 WHERE ROLE_ID = ");
			query.append(roleId);
			query.append(" AND OPTION_ID IN (");
			query.append(trueForIn);
			query.append(")");

			count = dbSession.executeUpdate(query.toString());
		}

		// Updating false values
		if (StringUtil.isEmpty(falseForIn.toString()) == false) {
			query = new StringBuilder();
			query.append("UPDATE UMS_ROLE_OPTION_MAP SET ENABLE = 0 WHERE ROLE_ID = ");
			query.append(roleId);
			query.append(" AND OPTION_ID IN (");
			query.append(falseForIn);
			query.append(")");

			count += dbSession.executeUpdate(query.toString());
		}

		return count;
	}

	@Override
	public List<UmsRoleOptionMap> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);
		List<UmsRoleOptionMap> umsRoleOptionMapList = null;
		if (dataSet.getRowCount() > 0) {
			umsRoleOptionMapList = new ArrayList<UmsRoleOptionMap>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsRoleOptionMapList.add(getSingleRow(dataSet, i));
			}
		}
		return umsRoleOptionMapList;
	}

	@Override
	public UmsRoleOptionMap getSingleRow(DataSet dataSet, int rowNum) {
		UmsRoleOptionMap umsRoleOptionMap = new UmsRoleOptionMap();

		umsRoleOptionMap.setRoleId(dataSet.getIntValue(rowNum, "ROLE_ID"));
		umsRoleOptionMap.setOptionId(dataSet.getIntValue(rowNum, "OPTION_ID"));
		umsRoleOptionMap.setEnabled(dataSet.getBooleanValue(rowNum, "ENABLE"));

		return umsRoleOptionMap;
	}

	@Override
	public List<UmsRoleOptionMap> selectOptionsByRoleId(int roleId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL_BY_ROLE_ID, roleId);
		List<UmsRoleOptionMap> umsRoleOptionMapList = null;
		if (dataSet.getRowCount() > 0) {
			umsRoleOptionMapList = new ArrayList<UmsRoleOptionMap>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsRoleOptionMapList.add(getSingleRow(dataSet, i));
			}
		}
		return umsRoleOptionMapList;
	}

	@Override
	public int softDelete(UmsRoleOptionMap t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hardDelete(UmsRoleOptionMap umsRoleOptionMap) throws DbException {
		return dbSession.executeUpdate(DELETE_BY_ROLE_ID, umsRoleOptionMap.getRoleId());
	}
}