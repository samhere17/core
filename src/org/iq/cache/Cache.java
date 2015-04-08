package org.iq.cache;

import java.util.Set;

import org.iq.cache.regions.SystemRegion;
import org.iq.cache.regions.UserRegion;
import org.iq.exception.CacheException;

/**
 * @author Sam
 * 
 */
public class Cache {

  /**
   * 
   */
  public Cache() {
    if (!SystemCache.isInitialized()) {
      SystemCache.initialize();
    }
  }

  /**
   * Adds a valid region type in the Cache
   * 
   * @param regionType
   * @throws CacheException
   */
  /*public void addRegionType(String regionType) throws CacheException {
    addRegionType(regionType, null);
  }*/

  /**
   * Adds a valid region type in the Cache
   * 
   * @param regionType
   * @param regionClass
   * @throws CacheException
   */
  public void addRegionType(String regionType, Class regionClass)
      throws CacheException {
    SystemRegion systemRegion = null;
    SystemCache systemCache = SystemCache.getInstance();
    systemRegion = systemCache.get(CacheConstants.REGION_TYPES_REGION);
    if (systemRegion == null) {
      throw new CacheException("Region types region doesn't exist.");
    }
    else {
      if (systemRegion.isKeyExists(regionType)) {
        throw new CacheException("Region type already exists.");
      }
      else {
        systemRegion.addElement(regionType, regionClass);
      }
    }
  }

  /**
   * @param regionType
   * @param regionId
   * @param userRegion
   * @throws CacheException
   */
  public void addRegion(String regionType, String regionId,
      UserRegion userRegion) throws CacheException {

    SystemRegion systemRegion = null;
    synchronized (UserCache.class) {
      SystemCache systemCache = SystemCache.getInstance();
      systemRegion = systemCache.get(CacheConstants.REGION_TYPES_REGION);
    }
    if (systemRegion == null) {
      throw new CacheException("Error System Region is null");
    }
    else {
      if (!systemRegion.isKeyExists(regionType)) {
        throw new CacheException("Region type is not valid.");
      }
      else {
        synchronized (UserCache.class) {
          UserCache userCache = UserCache.getInstance();
          if (systemRegion.getElement(regionType) != null) {
            Class regionClass = (Class)systemRegion.getElement(regionType);
            if (userRegion.getClass() == regionClass) {
              userCache.put(regionId + "~" + regionType, userRegion);
            }
          }
          else {
            userCache.put(regionId + "~" + regionType, userRegion);
          }
        }
      }
    }
  }

  /**
   * @param regionId
   * @param regionType
   * @return
   */
  public boolean isRegionExists(String regionType, String regionId) {
    UserCache cache = UserCache.getInstance();
    return cache.containsKey(regionId + "~" + regionType);
  }

  public void addElement(String regionType, String regionId, String key,
      Object value) throws CacheException {
    UserCache userCache = UserCache.getInstance();
    UserRegion userRegion = userCache.get(regionId + "~" + regionType);
    if (userRegion == null) {
      /*throw new CacheException("Not a valid cache region");*/
      userRegion = new UserRegion(regionId);
      userRegion.addElement(key, value);
      userCache.put(regionId + "~" + regionType, userRegion);
    }
    userRegion.addElement(key, value);
  }

  /**
   * @param regionType
   * @param regionId
   * @param key
   * @return
   */
  public boolean isKeyExists(String regionType, String regionId, String key) {
    UserCache cache = UserCache.getInstance();
    UserRegion region = cache.get(regionId + "~" + regionType);
    if (region == null) {
      return false;
    }
    else {
      return region.isKeyExists(key);
    }
  }

  /**
   * @param regionType
   * @param regionId
   * @return
   */
  public Set getKeySet(String regionType, String regionId) {
    UserCache userCache = UserCache.getInstance();
    UserRegion region = userCache.get(regionId + "~" + regionType);
    return region.getKeySet();
  }

  /**
   * fetches the Region associated with the regionId and finds the value from
   * the Region which is associated with provided key If no Region found in
   * Cache against the regionId then <code>CacheException</code> will be
   * thrown
   * 
   * @param regionId
   *          name by which the Cache Region is associated
   * @param key
   *          the value stored in the Region is associated with this key
   * @return value fetched from the Region which is stored against provided
   *         key
   * @throws CacheException
   */
  public Object getElement(String regionType, String regionId, String key)
      throws CacheException {
    UserCache userCache = UserCache.getInstance();
    UserRegion userRegion = userCache.get(regionId + "~" + regionType);
    if (userRegion == null) {
      throw new CacheException("Not a valid cache region");
    }
    Object value = userRegion.getElement(key);
    return value;
  }

  /**
   * @return Set
   * @throws CacheException
   */
  public Set getAllUserRegionIds() throws CacheException {
    UserCache userCache = UserCache.getInstance();
    return userCache.keySet();
  }

  /**
   * @param regionId
   * @return UserRegion
   * @throws CacheException
   */
  public UserRegion getUserRegion(String regionId) throws CacheException {
    UserCache userCache = UserCache.getInstance();
    UserRegion userRegion = userCache.get(regionId);
    if (userRegion == null) {
      System.out.println("No region found with regionid::" + regionId);
      throw new CacheException("No region found with regionid::" + regionId);
    }
    return userRegion;
  }

  /**
   * @param regionId
   * @param key
   * @throws CacheException
   */
  public void removeElement(String regionId, Object key) throws CacheException {
    UserCache userCache = UserCache.getInstance();
    UserRegion userRegion = userCache.get(regionId);
    if (userRegion == null) {
      throw new CacheException("Not a valid cache region.");
    }
    userRegion.deleteElement(key);
  }
  
  /**
   * @param regionId
   * @throws CacheException
   */
  public void removeAllElement(String regionId) throws CacheException {
	  UserCache userCache = UserCache.getInstance();
	  UserRegion userRegion = userCache.get(regionId);
	  if (userRegion == null) {
		  throw new CacheException("Not a valid cache region.");
	  }
	  userRegion.deleteAllElement();
  }
}