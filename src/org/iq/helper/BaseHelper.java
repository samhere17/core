package org.iq.helper;

import org.iq.Base;
import org.iq.cache.CacheHelper;
import org.iq.db.DbSession;

/**
 * @author Sam
 */
public abstract class BaseHelper extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6278427302277154017L;

	protected CacheHelper cacheHelper = new CacheHelper();

	/**
	 * @param dbSession
	 */
	public BaseHelper(DbSession dbSession) {
		super(dbSession);
	}
}