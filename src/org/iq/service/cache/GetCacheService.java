package org.iq.service.cache;

import java.util.HashMap;
import java.util.Set;

import org.iq.cache.CacheHelper;
import org.iq.cache.CacheRegionDataVO;
import org.iq.cache.CacheVO;
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
		HashMap<String, Object> regionMap = new HashMap<>();
		CacheVO[] cacheVOs = null;
		
		try {
			CacheHelper cacheHelper = new CacheHelper();
			Set<String> regionNames = cacheHelper.getAllUserRegionNames();
			cacheVOs = new CacheVO[regionNames.size()];
			int i=0;
			for (String regionName : regionNames) {
				cacheVOs[i] = new CacheVO();
				cacheVOs[i].setRegionName(regionName);
				CacheRegion cacheRegion = cacheHelper.getUserRegion(regionName);
				Set<String> keys = cacheHelper.getKeySet(cacheRegion.getRegionName());
				CacheRegionDataVO[] cacheRegionDataVOs = new CacheRegionDataVO[keys.size()];
				int j=0;
				regionMap.put(regionName, cacheRegion);
				for (String key : keys) {
					cacheRegionDataVOs[j] = new CacheRegionDataVO();
					cacheRegionDataVOs[j].setKey(key);
					Object object = cacheHelper.getElement(cacheRegion.getRegionName(), key);
					if (object != null) {
						cacheRegionDataVOs[j].setValue(object.toString());
					}
					j++;
				}
				cacheVOs[i].setCacheRegionDataVOs(cacheRegionDataVOs);
				i++;
			}
		} catch (CacheException e) {
			throw new ServiceException(e);
		}
		resultAttributes.put("RegionDataList", cacheVOs);
		redirectUrl = "__sys/dev/cache/view.jsp";
		LocalLogger.logMethodEnd();
	}

}
