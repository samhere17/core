package org.iq.db.dao.ums;

import java.util.List;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsRole;

/**
 * @author Sam
 * 
 */
public interface UmsRoleDao extends BaseDao<UmsRole> {

	UmsRole selectByRoleId(int roleId) throws DbException;

	int insertAndGetRoleId(UmsRole umsRole) throws DbException;

	List<UmsRole> selectAppRoles() throws DbException;

	List<UmsRole> search(Integer roleArea, Integer roleId, String roleName) throws DbException;

}