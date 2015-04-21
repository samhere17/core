package org.iq.db.dao.ums;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsLoginDetails;

public interface UmsLoginDetailsDao extends BaseDao<UmsLoginDetails> {

	/**
	 * @param userAccessKey
	 * @return UmsLoginDetails
	 * @throws DbException
	 */
	public UmsLoginDetails getLoginDetailsByUserId(int userId) throws DbException;

	UmsLoginDetails getLastLoginDetailsByUserId(int userId) throws DbException;
	
}
