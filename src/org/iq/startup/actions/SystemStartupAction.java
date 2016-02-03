package org.iq.startup.actions;

import org.iq.SystemContext;
import org.iq.action.Actions;
import org.iq.exception.ConfigException;
import org.iq.exception.CoreException;
import org.iq.service.Services;

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
		
		// Loading Services
		Services.load();

		// Loading Actions
		Actions.load();

		System.out.println("SYSTEM STARTED SUCCESSFULLY");
	}

	@Override
	public void destroy() {
		System.out.println("STOPING SYSTEM...");
		// No destroy activities as of now

		System.out.println("SYSTEM STOPPED SUCCESSFULLY");
	}
}