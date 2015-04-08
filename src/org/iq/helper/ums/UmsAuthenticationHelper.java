package org.iq.helper.ums;

import java.util.Date;

import org.iq.UmsConstants.SessionStatus;
import org.iq.cache.regions.UserRegion;
import org.iq.db.dao.ums.UmsLoginDetailsDao;
import org.iq.db.dao.ums.UmsSessionDetailsDao;
import org.iq.db.dao.ums.UmsUserDao;
import org.iq.db.dao.ums.UmsUserDetailsDao;
import org.iq.db.dao.ums.UmsUserRoleMapDao;
import org.iq.db.dao.ums.impl.UmsLoginDetailsDaoImpl;
import org.iq.db.dao.ums.impl.UmsSessionDetailsDaoImpl;
import org.iq.db.dao.ums.impl.UmsUserDaoImpl;
import org.iq.db.dao.ums.impl.UmsUserDetailsDaoImpl;
import org.iq.db.dao.ums.impl.UmsUserRoleMapDaoImpl;
import org.iq.exception.BusinessException;
import org.iq.exception.CacheException;
import org.iq.exception.DbException;
import org.iq.exception.UmsException;
import org.iq.helper.BaseHelper;
import org.iq.logger.LocalLogger;
import org.iq.ui.useragents.UserAgent;
import org.iq.ums.security.UmsSecurity;
import org.iq.util.ums.UmsDbProvider;
import org.iq.util.ums.UmsKeyGenerator;
import org.iq.valueobject.ums.UmsLoginDetails;
import org.iq.valueobject.ums.UmsSession;
import org.iq.valueobject.ums.UmsSessionDetails;
import org.iq.valueobject.ums.UmsUser;
import org.iq.valueobject.ums.UmsUserDetails;
import org.iq.valueobject.ums.UmsUserRoleMap;

/**
 * @author Sam
 *
 */
public class UmsAuthenticationHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4558785891174003558L;

	/**
	 * @throws BusinessException 
	 * 
	 */
	public UmsAuthenticationHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

	/**
	 * @param username
	 * @param password
	 * @param jSessionId
	 * @param accessIp
	 * @param accessPort
	 * @param accessGateway
	 * @param actualAccessIP
	 * @param userAgentString
	 * @return UmsSession
	 */
	public UmsSession authenticate(String username, String password,
			String jSessionId, String accessIp, String accessPort,
			String accessGateway, String actualAccessIP, String userAgentString) {

		UmsSecurity umsSecurity = UmsSecurity.getUmsSecurityInstance();

		UmsUser user = umsSecurity.authenticate(username, password.toCharArray());

		UmsSession umsSession = new UmsSession();
		if (user != null) {
			UmsUserDetails userDetails = new UmsUserDetails();
			UmsLoginDetails lastLoginDetails = new UmsLoginDetails();

			try {
				//Fetching user details
				UmsUserDetailsDao umsUserDetailsDao = new UmsUserDetailsDaoImpl(dbSession);
				userDetails = umsUserDetailsDao.getUserDetailsByUserId(user.getUserId());
				
				//Fetching user role mapping
				UmsUserRoleMapDao umsUserRoleMapDao = new UmsUserRoleMapDaoImpl(dbSession);
				UmsUserRoleMap userRoleMap  = umsUserRoleMapDao.selectByUserId(user.getUserId());
				
				//Fetching last login details
				UmsLoginDetailsDao umsLoginDetailsDao = new UmsLoginDetailsDaoImpl(dbSession);
				lastLoginDetails = umsLoginDetailsDao.getLoginDetailsByUserId(user.getUserId());
				
				String systemSessionId = UmsKeyGenerator.getRandomKey();
				String nativeToken = umsSecurity.createNativeToken(username);
				
				//Preparing current session details
				UmsSessionDetails currSessionDetails = new UmsSessionDetails();
				currSessionDetails.setUserId(user.getUserId());
				currSessionDetails.setSystemSessionId(systemSessionId);
				currSessionDetails.setNativeToken(nativeToken);
				currSessionDetails.setSessionStatus(SessionStatus.VALID);
				
				//Inserting current session details
				UmsSessionDetailsDao umsSessionDetailsDao = new UmsSessionDetailsDaoImpl(dbSession);
				umsSessionDetailsDao.insert(currSessionDetails);

				//Preparing current login details
				UmsLoginDetails currLoginDetails = new UmsLoginDetails();
				currLoginDetails.setUserId(user.getUserId());
				currLoginDetails.setSystemSessionId(systemSessionId);
				currLoginDetails.setNativeToken(nativeToken);
				currLoginDetails.setLoginTime(new Date());
				currLoginDetails.setAccessIP(accessIp);
				currLoginDetails.setAccessPort(accessPort);
				currLoginDetails.setAccessGateway(accessGateway);
				currLoginDetails.setActualAccessIP(actualAccessIP);
				
				UserAgent userAgent = new UserAgent(userAgentString);

				currLoginDetails.setDeviceType(userAgent.getOperatingSystem().getDeviceType().getName());
				currLoginDetails.setOperatingSystem(userAgent.getOperatingSystem().getName());
				currLoginDetails.setOperatingSystemManufacturer(userAgent.getOperatingSystem().getManufacturer().getName());
				currLoginDetails.setBrowserName(userAgent.getBrowser().getName());
				currLoginDetails.setBrowserVersion(userAgent.getBrowserVersion().toString());
				currLoginDetails.setBrowserManufacturer(userAgent.getBrowser().getManufacturer().getName());
				currLoginDetails.setBrowserType(userAgent.getBrowser().getBrowserType().getName());
				currLoginDetails.setBrowserRenderingEngine(userAgent.getBrowser().getRenderingEngine().getName());


				//Inserting current login details
				umsLoginDetailsDao.insert(currLoginDetails);

				
				umsSession.setAdditionalId(user.getAdditionalId());
				umsSession.setInvalidMessage(null);
				umsSession.setLastLoginDetails(lastLoginDetails);
				umsSession.setNativeToken(nativeToken);
				umsSession.setRoleId(userRoleMap.getRoleId());
				umsSession.setSessionValid(true);
				umsSession.setSystemSessionId(systemSessionId);
				umsSession.setUserAccessKey(user.getUserAccessKey());
				umsSession.setUserDetails(userDetails);
				umsSession.setUserId(userDetails.getUserId());
				umsSession.setUsername(username);
				
				
				if (cache.isRegionExists("UMS", "UMS_SESSIONS") == false) {
					cache.addRegionType("UMS", UserRegion.class);
					cache.addRegion("UMS", "UMS_SESSIONS", new UserRegion(
							"UMS_SESSIONS"));
				} else {
					LocalLogger.logDebug("UMS_SESSIONS" + " Region Exists.");
				}

				cache.addElement("UMS", "UMS_SESSIONS", jSessionId, umsSession);
				
			} catch (DbException e) {
				LocalLogger.logSevere(e);
			} catch (CacheException e) {
				LocalLogger.logSevere(e);
			}
		} else {
			umsSession.setSessionValid(false);
		}
		
		return umsSession;
	}

	/**
	 * @param userName
	 * @param password
	 * @param newPassword
	 * @return
	 * @throws DbException
	 */
	public int changePassword(String userAccessKey, String password) throws DbException {
		UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
		return umsUserDao.updatePassword(userAccessKey, password);
	}

	public boolean isTicketValid(String ticket) throws UmsException {
		System.out.println("isTicketValid called...");
		return true;
	}
}