package org.iq.service.ums;

import java.util.HashMap;

import org.iq.cache.Cache;
import org.iq.cache.regions.UserRegion;
import org.iq.exception.CacheException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
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

			Cache cache = new Cache();

			if (cache.isRegionExists("UMS", "UMS_SESSIONS") == false) {
				cache.addRegionType("UMS", UserRegion.class);
				cache.addRegion("UMS", "UMS_SESSIONS", new UserRegion(
						"UMS_SESSIONS"));
			} else {
				LocalLogger.logDebug("UMS_SESSIONS" + " Region Exists.");
			}

			cache.removeElement("UMS_SESSIONS~UMS", jSessionId);
		} catch (CacheException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "index.jsp";
	}
}