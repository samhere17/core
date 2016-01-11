package org.iq.ums.service;

import java.util.HashMap;

import org.iq.cache.CacheHelper;
import org.iq.exception.BusinessException;
import org.iq.exception.CacheException;
import org.iq.exception.DbException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.UmsContext;
import org.iq.ums.UmsConstants.SessionStatus;
import org.iq.ums.dao.UmsSessionDetailsDao;
import org.iq.ums.dao.impl.UmsSessionDetailsDaoImpl;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.vo.UmsSession;
import org.iq.ums.vo.UmsSessionDetails;
import org.iq.util.StringUtil;

@Service(name="Logout")
public class LogoutService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866439611362342455L;

	private static final String J_SESSION_ID_KEY = "jSessionId";

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {

		String jSessionId = StringUtil.getStringValue(input
				.get(J_SESSION_ID_KEY));
		try {

			CacheHelper cacheHelper = new CacheHelper();

			if (cacheHelper.isRegionExists("UMS_SESSIONS") == false) {
				cacheHelper.addRegion("UMS_SESSIONS", "Region to store user session details");
			} else {
				LocalLogger.logDebug("UMS_SESSIONS" + " Region Exists.");
			}
			
			UmsSessionDetailsDao umsSessionDetailsDao = new UmsSessionDetailsDaoImpl(UmsDbProvider.getDbSession());
			UmsSession umsSession = (UmsSession)cacheHelper.getElement("UMS_SESSIONS", jSessionId);
			UmsSessionDetails currSessionDetails = new UmsSessionDetails();
			currSessionDetails.setUserId(umsSession.getUserId());
			currSessionDetails.setSystemSessionId(umsSession.getSystemSessionId());
			currSessionDetails.setNativeToken(umsSession.getNativeToken());
			currSessionDetails.setSessionStatus(SessionStatus.VALID);
			umsSessionDetailsDao.hardDelete(currSessionDetails);

			cacheHelper.removeElement("UMS_SESSIONS", jSessionId);
		} catch (CacheException e) {
			throw new ServiceException(e);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		} catch (DbException e) {
			throw new ServiceException(e);
		}

		redirectUrl = UmsContext.umsConfig.getLogoutSuccessRedirectUrl();
	}
}