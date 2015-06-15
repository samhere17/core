package org.iq.startup.actions;

import org.iq.exception.CoreException;

/**
 * @author Sam
 * 
 */
public abstract class StartupAction {
	
	/**
	 * 
	 */
	public abstract void init() throws CoreException;

	/**
	 * 
	 */
	public abstract void destroy();
}