package org.iq.db.dao.ums;

import java.util.List;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsUser;

/**
 * @author Sam
 * 
 */
public interface UmsUserDao extends BaseDao<UmsUser> {
	/**
	 * @return List<UmsUser>
	 * @throws DbException
	 */
	List<UmsUser> getAllUsers() throws DbException;

	/**
	 * @param userAccessKey
	 * @return UmsUser
	 * @throws DbException
	 */
	UmsUser getUserByUserAccessKey(String userAccessKey) throws DbException;

	/**
	 * @param userName
	 * @return UmsUser
	 * @throws DbException
	 */
	UmsUser getUserByUsername(String userName) throws DbException;

	
	/**
	 * @param userAccessKey
	 * @param password
	 * @return
	 * @throws DbException
	 */
	int updatePassword(String userAccessKey, String password)
			throws DbException;


	/**
	 * @return List<UmsUser>
	 * @throws DbException
	 */
	List<UmsUser> getSystemUsers() throws DbException;
	
	/**
	 * @param user
	 * @return int
	 * @throws DbException
	 */
	int insertAndGetUserId(UmsUser user) throws DbException;

	/**
	 * @return int
	 * @throws DbException
	 */
	int getLastUserId() throws DbException;

	UmsUser getUserByUserId(int userId) throws DbException;

}
