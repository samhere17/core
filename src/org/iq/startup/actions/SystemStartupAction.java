package org.iq.startup.actions;

import org.iq.SystemContext;
import org.iq.exception.ConfigException;
import org.iq.exception.CoreException;
import org.iq.service.ServicesDefinitions;

/**
 * @author Sam
 */
public class SystemStartupAction extends StartupAction {

	@Override
	public void init() throws CoreException {
		System.out.println("STARTING SYSTEM...");

		// Initializing system context
		try {
			SystemContext.initialize();
		} catch (ConfigException e) {
			throw new CoreException(e);
		}
		
		// Loading Services Definitions
		ServicesDefinitions.load();

		System.out.println("SYSTEM STARTED SUCCESSFULLY");
	}

	@Override
	public void destroy() {
		System.out.println("STOPING SYSTEM...");
		// TODO Auto-generated method stub

		System.out.println("SYSTEM STOPPED SUCCESSFULLY");
	}
}