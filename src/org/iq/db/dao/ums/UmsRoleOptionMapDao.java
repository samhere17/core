package org.iq.db.dao.ums;

import java.util.List;
import java.util.Map;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsRoleOptionMap;

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