package org.iq.ums.dao;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.ums.vo.UmsUserRoleMap;

/**
 * @author Sam
 * 
 */
public interface UmsUserRoleMapDao extends BaseDao<UmsUserRoleMap> {

	UmsUserRoleMap selectByUserId(int userId) throws DbException;
	
}