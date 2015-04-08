package org.iq.db.dao.ums;

import java.util.List;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsUserDetails;

/**
 * @author Sam
 * 
 */
public interface UmsUserDetailsDao extends BaseDao<UmsUserDetails> {

	/**
	 * @param email
	 * @return UmsUserDetails
	 * @throws DbException
	 */
	UmsUserDetails getUserDetailsByEmail(String email)
			throws DbException;
	
	/**
	 * @param userId
	 * @return
	 * @throws DbException
	 */
	UmsUserDetails getUserDetailsByUserId(int userId) throws DbException;

	List<UmsUserDetails> search(String additionalId, String userId,
			String username, String firstname, String lastname, String phone,
			String email, Integer roleId) throws DbException;

}