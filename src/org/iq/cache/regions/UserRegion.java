package org.iq.cache.regions;

import java.util.Date;

import org.iq.cache.CacheConstants;

public class UserRegion extends Region {

  /**
   * 
   */
  private static final long serialVersionUID = 7936994247951131886L;
  protected boolean evictionAllowed;
  protected boolean userClearRegionAllowed;
  protected boolean userClearElementAllowed;
  protected boolean cleaningRequired;
  protected Date lastAccessTime = new Date();
  protected int evictionInterval = 0;

  /**
   * 
   */
  public UserRegion(String regionName) {
    super(regionName, CacheConstants.DEFAULT_USER_REGION_TYPE, null);
  }

  public UserRegion(String regionName, String regionType,
      String description, boolean evictionAllowed,
      boolean userClearRegionAllowed, boolean userClearElementAllowed,
      boolean cleaningRequired) {
    super(regionName, regionType, description);
    this.evictionAllowed = evictionAllowed;
    this.userClearRegionAllowed = userClearRegionAllowed;
    this.userClearElementAllowed = userClearElementAllowed;
    this.cleaningRequired = cleaningRequired;
  }

  /**
   * @param key
   */
  public synchronized void deleteElement(Object key) {
    if (evictionAllowed) {
      regionCache.remove(key);
    }
  }
  
  /**
   * 
   */
  public synchronized void deleteAllElement() {
	  if (evictionAllowed) {
		  regionCache.clear();
	  }
  }


  /**
   * 
   */
  public synchronized void clean() {
    if (evictionAllowed) {
      regionCache.clear();
    }
  }

  /**
   * @return the toBeDeleted
   */
  public boolean isEvictionAllowed() {
    return evictionAllowed;
  }

  /**
   * @return the userClearAllowed
   */
  public boolean isUserClearRegionAllowed() {
    return userClearRegionAllowed;
  }

  /**
   * @return the userClearAllowed
   */
  public boolean isUserClearElementAllowed() {
    return userClearElementAllowed;
  }

  /**
   * @return the cleaningRequired
   */
  public boolean isCleaningRequired() {
    return cleaningRequired;
  }

  /**
   * @param cleaningRequired
   *          the cleaningRequired to set
   */
  public void setCleaningRequired(boolean cleaningRequired) {
    this.cleaningRequired = cleaningRequired;
  }
  
  /**
   * @return int
   */
  public int getEvictionInterval() {
    return evictionInterval;
  }

  /**
   * @param evictionInterval
   */
  public void setEvictionInterval(int evictionInterval) {
    this.evictionInterval = evictionInterval;
  }

}