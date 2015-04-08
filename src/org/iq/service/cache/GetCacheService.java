package org.iq.service.cache;

import java.util.HashMap;
import java.util.Set;

import org.iq.cache.Cache;
import org.iq.cache.regions.UserRegion;
import org.iq.exception.CacheException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;

@Service(name="GetCache")
public class GetCacheService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -541414717100821833L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {

		LocalLogger.logMethodStart();
		
		
		try {
			Cache cache = new Cache();
			Set<String> regionIds = cache.getAllUserRegionIds();

			for (String regionId : regionIds) {
				UserRegion userRegion = cache.getUserRegion(regionId);
				Set<String> keys = cache.getKeySet("UMS",
						userRegion.getRegionName());

				for (String key : keys) {
					Object object = cache.getElement(
							"UMS",
							userRegion.getRegionName(), key);
				}
			}
		} catch (CacheException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}

}
