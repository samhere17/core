package org.iq.cache;

import org.iq.valueobject.BaseVO;

public class CacheVO extends BaseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4612862289803134749L;

	/**
	 * 
	 */
	private String regionName = null;
	
	/**
	 * 
	 */
	private CacheRegionDataVO[] cacheRegionDataVOs = null;
	
	/**
	 * @return
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * @param regionName
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * @return
	 */
	public CacheRegionDataVO[] getCacheRegionDataVOs() {
		return cacheRegionDataVOs;
	}

	/**
	 * @param cacheRegionDataVOs
	 */
	public void setCacheRegionDataVOs(CacheRegionDataVO[] cacheRegionDataVOs) {
		this.cacheRegionDataVOs = cacheRegionDataVOs;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
