package org.iq.service.ums;

import java.util.HashMap;

import org.iq.UmsConstants.SessionStatus;
import org.iq.cache.CacheHelper;
import org.iq.db.dao.ums.UmsSessionDetailsDao;
import org.iq.db.dao.ums.impl.UmsSessionDetailsDaoImpl;
import org.iq.exception.BusinessException;
import org.iq.exception.CacheException;
import org.iq.exception.DbException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;
import org.iq.util.system.CoreDbProvider;
import org.iq.valueobject.ums.UmsSession;
import org.iq.valueobject.ums.UmsSessionDetails;

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
			
			UmsSessionDetailsDao umsSessionDetailsDao = new UmsSessionDetailsDaoImpl(CoreDbProvider.getDbSession());
			UmsSession umsSession = (UmsSession)cacheHelper.getElement("UMS_SESSIONS", jSessionId);
			UmsSessionDetails currSessionDetails = new UmsSessionDetails();
			currSessionDetails.setUserId(umsSession.getUserId());
			currSessionDetails.setSystemSessionId(umsSession.getSystemSessionId());
			currSessionDetails.setNativeToken(umsSession.getNativeToken());
			currSessionDetails.setSessionStatus(SessionStatus.VALID);
			umsSessionDetailsDao.delete(currSessionDetails);

			cacheHelper.removeElement("UMS_SESSIONS", jSessionId);
		} catch (CacheException e) {
			throw new ServiceException(e);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		} catch (DbException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "index.jsp";
	}
}