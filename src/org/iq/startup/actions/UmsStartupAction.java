package org.iq.startup.actions;

import java.util.Map;

import org.iq.exception.CoreException;
import org.iq.logger.LocalLogger;


/**
 * @author Sam
 */
public class UmsStartupAction extends BaseStartupAction {

	@Override
	public Map<String, Object> execute() throws CoreException {
		LocalLogger.logDebug("STARTING UMS...");
		/*UmsHelper umsHelper = new UmsHelper();
		try {
			if (umsHelper.isAdminUserConfigured()) {
				returnMap.put("adminUserConfigured", true);
			} else {
				returnMap.put("adminUserConfigured", false);
			}
		} catch (BusinessException e) {
			throw new CoreException(e);
		}*/

		LocalLogger.logDebug("UMS STARTED SUCCESSFULLY");
		
		return returnMap;
	}
}