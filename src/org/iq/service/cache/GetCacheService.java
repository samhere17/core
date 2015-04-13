package org.iq.service.cache;

import java.util.HashMap;
import java.util.Set;

import org.iq.cache.CacheHelper;
import org.iq.cache.regions.CacheRegion;
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
			CacheHelper cacheHelper = new CacheHelper();
			Set<String> regionIds = cacheHelper.getAllUserRegionNames();

			for (String regionId : regionIds) {
				CacheRegion cacheRegion = cacheHelper.getUserRegion(regionId);
				Set<String> keys = cacheHelper.getKeySet(cacheRegion.getRegionName());

				for (String key : keys) {
					Object object = cacheHelper.getElement(cacheRegion.getRegionName(), key);
				}
			}
		} catch (CacheException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}

}
