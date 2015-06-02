package org.iq.startup.actions;

import org.iq.exception.CoreException;


/**
 * @author Sam
 */
public class LoggerStartupAction extends StartupAction {

	@Override
	public void init() throws CoreException {
	    System.out.println("STARTING LOGGER...");
		// TODO Auto-generated method stub
		
	    System.out.println("LOGGER STARTED SUCCESSFULLY");
	}

	@Override
	public void destroy() {
	    System.out.println("STOPING LOGGER...");
		// TODO Auto-generated method stub
		
	    System.out.println("LOGGER STOPPED SUCCESSFULLY");
	}
}