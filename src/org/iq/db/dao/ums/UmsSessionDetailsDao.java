package org.iq.db.dao.ums;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsSessionDetails;

public interface UmsSessionDetailsDao extends BaseDao<UmsSessionDetails> {

	/**
	 * @param userAccessKey
	 * @return UmsSessionDetails
	 * @throws DbException
	 */
	public UmsSessionDetails getSessionDetailsByUserId(
			int userId) throws DbException;

}
