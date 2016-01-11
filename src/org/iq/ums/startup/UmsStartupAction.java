package org.iq.ums.startup;

import org.iq.cache.CacheHelper;
import org.iq.exception.CacheException;
import org.iq.exception.ConfigException;
import org.iq.exception.CoreException;
import org.iq.startup.actions.StartupAction;
import org.iq.ums.UmsContext;

/**
 * @author Sam
 */
public class UmsStartupAction extends StartupAction {

	@Override
	public void init() throws CoreException {
		System.out.println("STARTING UMS...");

		// Initializing ums context
		try {
			UmsContext.initialize();
			CacheHelper cacheHelper = new CacheHelper();
			cacheHelper.addRegion("UMS_SESSIONS", "Region to store user session details", true);
		} catch (ConfigException e) {
			throw new CoreException(e);
		} catch (CacheException e) {
			throw new CoreException(e);
		}
	

		System.out.println("UMS STARTED SUCCESSFULLY");
	}

	@Override
	public void destroy() {
		System.out.println("STOPING UMS...");
		// TODO Auto-generated method stub

		System.out.println("UMS STOPPED SUCCESSFULLY");
	}
}