package org.iq.db.dao.ums;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsUserRoleMap;

/**
 * @author Sam
 * 
 */
public interface UmsUserRoleMapDao extends BaseDao<UmsUserRoleMap> {

	UmsUserRoleMap selectByUserId(int userId) throws DbException;
	
}