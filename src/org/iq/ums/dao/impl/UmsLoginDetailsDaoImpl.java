package org.iq.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.exception.DbException;
import org.iq.ums.dao.UmsLoginDetailsDao;
import org.iq.ums.vo.UmsLoginDetails;

/**
 * @author Sam
 * 
 */
public class UmsLoginDetailsDaoImpl extends BaseDaoImpl implements
		UmsLoginDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1151970649995789768L;

	private static final String UMS_LOGIN_DETAILS_SELECT_ALL = "SELECT USER_ID, SYSTEM_SESSION_ID, NATIVE_TOKEN, LOGIN_TIME, ACCESS_IP, ACCESS_PORT, ACCESS_GATEWAY, ACTUAL_ACCESS_IP, DEVICE_TYPE, OPERATING_SYSTEM, OPERATING_SYSTEM_MANUFACTURER, BROWSER_NAME, BROWSER_VERSION, BROWSER_MANUFACTURER, BROWSER_TYPE, BROWSER_RENDERING_ENGINE FROM UMS_LOGIN_DETAILS";
	
	private static final String UMS_LOGIN_DETAILS_SELECT_BY_USER_ID = "SELECT USER_ID, SYSTEM_SESSION_ID, NATIVE_TOKEN, LOGIN_TIME, ACCESS_IP, ACCESS_PORT, ACCESS_GATEWAY, ACTUAL_ACCESS_IP, DEVICE_TYPE, OPERATING_SYSTEM, OPERATING_SYSTEM_MANUFACTURER, BROWSER_NAME, BROWSER_VERSION, BROWSER_MANUFACTURER, BROWSER_TYPE, BROWSER_RENDERING_ENGINE FROM UMS_LOGIN_DETAILS WHERE USER_ID = ?";

	private static final String UMS_LAST_LOGIN_DETAILS_SELECT_BY_USER_ID = "SELECT USER_ID, SYSTEM_SESSION_ID, NATIVE_TOKEN, LOGIN_TIME, ACCESS_IP, ACCESS_PORT, ACCESS_GATEWAY, ACTUAL_ACCESS_IP, DEVICE_TYPE, OPERATING_SYSTEM, OPERATING_SYSTEM_MANUFACTURER, BROWSER_NAME, BROWSER_VERSION, BROWSER_MANUFACTURER, BROWSER_TYPE, BROWSER_RENDERING_ENGINE FROM UMS_LOGIN_DETAILS WHERE USER_ID = ? ORDER BY LOGIN_TIME DESC";

	private static final String UMS_LOGIN_DETAILS_INSERT_ALL = "INSERT INTO UMS_LOGIN_DETAILS (USER_ID, SYSTEM_SESSION_ID, NATIVE_TOKEN, LOGIN_TIME, ACCESS_IP, ACCESS_PORT, ACCESS_GATEWAY, ACTUAL_ACCESS_IP, DEVICE_TYPE, OPERATING_SYSTEM, OPERATING_SYSTEM_MANUFACTURER, BROWSER_NAME, BROWSER_VERSION, BROWSER_MANUFACTURER, BROWSER_TYPE, BROWSER_RENDERING_ENGINE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/*

	USER_ID, SYSTEM_SESSION_ID, NATIVE_TOKEN, LOGIN_TIME, ACCESS_IP, ACCESS_PORT, ACCESS_GATEWAY, ACTUAL_ACCESS_IP, DEVICE_TYPE, OPERATING_SYSTEM, OPERATING_SYSTEM_MANUFACTURER, BROWSER_NAME, BROWSER_VERSION, BROWSER_MANUFACTURER, BROWSER_TYPE, BROWSER_RENDERING_ENGINE
	 
	USER_ID							INT NOT NULL,
	SYSTEM_SESSION_ID				VARCHAR(50) NOT NULL,
	NATIVE_TOKEN					VARCHAR(100),
	LOGIN_TIME						DATETIME NOT NULL,
	ACCESS_IP						VARCHAR(45),
	ACCESS_PORT						VARCHAR(5),
	ACCESS_GATEWAY					VARCHAR(45),
	ACTUAL_ACCESS_IP				VARCHAR(45),
	DEVICE_TYPE						VARCHAR(100),
	OPERATING_SYSTEM				VARCHAR(100),
	OPERATING_SYSTEM_MANUFACTURER	VARCHAR(100),
	BROWSER_NAME					VARCHAR(100),
	BROWSER_VERSION					VARCHAR(100),
	BROWSER_MANUFACTURER			VARCHAR(100),
	BROWSER_TYPE					VARCHAR(100),
	BROWSER_RENDERING_ENGINE		VARCHAR(100),
	 
	 */

	/**
	 * @param dbSession
	 */
	public UmsLoginDetailsDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public UmsLoginDetails getLastLoginDetailsByUserId(int userId)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				UMS_LAST_LOGIN_DETAILS_SELECT_BY_USER_ID, userId);

		UmsLoginDetails loginDetails = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			loginDetails = getSingleRow(dataSet, 0);
		}

		return loginDetails;
	}

	@Override
	public UmsLoginDetails getLoginDetailsByUserId(int userId)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				UMS_LOGIN_DETAILS_SELECT_BY_USER_ID, userId);

		UmsLoginDetails loginDetails = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			loginDetails = getSingleRow(dataSet, 0);
		}

		return loginDetails;
	}

	@Override
	public int insert(UmsLoginDetails umsLoginDetails) throws DbException {
		return dbSession.executeUpdate(UMS_LOGIN_DETAILS_INSERT_ALL,
				umsLoginDetails.getUserId(),
				umsLoginDetails.getSystemSessionId(),
				umsLoginDetails.getNativeToken(),
				umsLoginDetails.getLoginTime(), umsLoginDetails.getAccessIP(),
				umsLoginDetails.getAccessPort(),
				umsLoginDetails.getAccessGateway(),
				umsLoginDetails.getActualAccessIP(),
				umsLoginDetails.getDeviceType(),
				umsLoginDetails.getOperatingSystem(),
				umsLoginDetails.getOperatingSystemManufacturer(),
				umsLoginDetails.getBrowserName(),
				umsLoginDetails.getBrowserVersion(),
				umsLoginDetails.getBrowserManufacturer(),
				umsLoginDetails.getBrowserType(),
				umsLoginDetails.getBrowserRenderingEngine());
	}

	@Override
	public int update(UmsLoginDetails object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UmsLoginDetails> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(UMS_LOGIN_DETAILS_SELECT_ALL);

		List<UmsLoginDetails> umsLoginDetails = null;
		if (dataSet.getRowCount() > 0) {
			umsLoginDetails = new ArrayList<UmsLoginDetails>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsLoginDetails.add(getSingleRow(dataSet, i));
			}
		}
		return umsLoginDetails;
	}

	@Override
	public int delete(UmsLoginDetails object) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UmsLoginDetails getSingleRow(DataSet dataSet, int rowNum) {

		UmsLoginDetails loginDetails = new UmsLoginDetails();
		loginDetails.setUserId(dataSet.getIntValue(rowNum, "USER_ID"));
		loginDetails.setSystemSessionId(dataSet.getStringValue(rowNum, "SYSTEM_SESSION_ID"));
		loginDetails.setNativeToken(dataSet.getStringValue(rowNum, "NATIVE_TOKEN"));
		loginDetails.setLoginTime(dataSet.getDateValue(rowNum, "LOGIN_TIME"));
		loginDetails.setAccessIP(dataSet.getStringValue(rowNum, "ACCESS_IP"));
		loginDetails.setAccessPort(dataSet.getStringValue(rowNum, "ACCESS_PORT"));
		loginDetails.setAccessGateway(dataSet.getStringValue(rowNum, "ACCESS_GATEWAY"));
		loginDetails.setActualAccessIP(dataSet.getStringValue(rowNum, "ACTUAL_ACCESS_IP"));
		loginDetails.setDeviceType(dataSet.getStringValue(rowNum, "DEVICE_TYPE"));
		loginDetails.setOperatingSystem(dataSet.getStringValue(rowNum, "OPERATING_SYSTEM"));
		loginDetails.setOperatingSystemManufacturer(dataSet.getStringValue(rowNum, "OPERATING_SYSTEM_MANUFACTURER"));
		loginDetails.setBrowserName(dataSet.getStringValue(rowNum, "BROWSER_NAME"));
		loginDetails.setBrowserVersion(dataSet.getStringValue(rowNum, "BROWSER_VERSION"));
		loginDetails.setBrowserManufacturer(dataSet.getStringValue(rowNum, "BROWSER_MANUFACTURER"));
		loginDetails.setBrowserType(dataSet.getStringValue(rowNum, "BROWSER_TYPE"));
		loginDetails.setBrowserRenderingEngine(dataSet.getStringValue(rowNum, "BROWSER_RENDERING_ENGINE"));

		return loginDetails;
	}

}