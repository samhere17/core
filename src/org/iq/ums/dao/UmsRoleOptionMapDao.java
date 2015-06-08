package org.iq.ums.dao;

import java.util.List;
import java.util.Map;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.ums.vo.UmsRoleOptionMap;

/**
 * @author Sam
 * 
 */
public interface UmsRoleOptionMapDao extends BaseDao<UmsRoleOptionMap> {

	List<UmsRoleOptionMap> selectOptionsByRoleId(int roleId) throws DbException;

	int insertMultiple(int roleId, Map<Integer, Boolean> optionsMap)
			throws DbException;

	int updateMultiple(int roleId, Map<Integer, Boolean> optionsMap)
			throws DbException;
	
}