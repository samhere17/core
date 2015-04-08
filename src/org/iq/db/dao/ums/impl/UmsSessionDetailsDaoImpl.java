package org.iq.db.dao.ums.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.ums.UmsSessionDetailsDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsSessionDetails;

public class UmsSessionDetailsDaoImpl extends BaseDaoImpl implements
		UmsSessionDetailsDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2322410548569150203L;

	private static final String UMS_SESSION_DETAILS_SELECT_ALL = "SELECT USER_ID, SYSTEM_SESSION_ID, SESSION_STATUS, NATIVE_TOKEN FROM UMS_SESSION_DETAILS";

	private static final String UMS_SESSION_DETAILS_SELECT_BY_USER_ID = "SELECT USER_ID, SYSTEM_SESSION_ID, SESSION_STATUS, NATIVE_TOKEN FROM UMS_SESSION_DETAILS WHERE USER_ID = ?";

	private static final String UMS_SESSION_DETAILS_INSERT_ALL = "INSERT INTO UMS_SESSION_DETAILS (USER_ID, SYSTEM_SESSION_ID, SESSION_STATUS, NATIVE_TOKEN ) VALUES (?, ?, ?, ?)";

/*	
	USER_ID, SYSTEM_SESSION_ID, SESSION_STATUS, NATIVE_TOKEN

	USER_ID				INT NOT NULL,
	SYSTEM_SESSION_ID	VARCHAR(50) NOT NULL,
	SESSION_STATUS		INT(2) NOT NULL,
	NATIVE_TOKEN		VARCHAR(100),

*/
	/**
	 * @param dbSession
	 */
	public UmsSessionDetailsDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public UmsSessionDetails getSessionDetailsByUserId(
			int userId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				UMS_SESSION_DETAILS_SELECT_BY_USER_ID, userId);

		UmsSessionDetails sessionDetails = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			sessionDetails = getSingleRow(dataSet, 0);
		}

		return sessionDetails;
	}

	@Override
	public int insert(UmsSessionDetails umsSessionDetails) throws DbException {
		
		return dbSession.executeUpdate(UMS_SESSION_DETAILS_INSERT_ALL,
				umsSessionDetails.getUserId(),
				umsSessionDetails.getSystemSessionId(),
				umsSessionDetails.getSessionStatus().getSessionStatusValue(),
				umsSessionDetails.getNativeToken());
	}

	@Override
	public int update(UmsSessionDetails object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UmsSessionDetails> select() throws DbException {
		DataSet dataSet = dbSession
				.executeQuery(UMS_SESSION_DETAILS_SELECT_ALL);

		List<UmsSessionDetails> sessionDetails = null;
		if (dataSet.getRowCount() > 0) {
			sessionDetails = new ArrayList<UmsSessionDetails>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				sessionDetails.add(getSingleRow(dataSet, i));
			}
		}
		return sessionDetails;
	}

	@Override
	public int delete(UmsSessionDetails object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UmsSessionDetails getSingleRow(DataSet dataSet, int rowNum) {
		
		UmsSessionDetails sessionDetails = new UmsSessionDetails();
		sessionDetails.setUserId(dataSet.getIntValue(rowNum,
				"USER_ACCESS_KEY"));
		sessionDetails.setSystemSessionId(dataSet.getStringValue(rowNum,
				"SYSTEM_SESSION_ID"));
		sessionDetails.setNativeToken(dataSet.getStringValue(rowNum,
				"NATIVE_TOKEN"));
		sessionDetails.setSessionStatusValue(dataSet.getIntValue(rowNum,
				"SESSION_STATUS"));
		
		return sessionDetails ;
	}


}