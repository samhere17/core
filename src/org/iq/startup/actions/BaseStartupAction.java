package org.iq.startup.actions;

import java.util.HashMap;
import java.util.Map;

import org.iq.exception.CoreException;

/**
 * @author Sam
 *
 */
public abstract class BaseStartupAction {

	protected Map<String, Object> returnMap = new HashMap<String, Object>();

	/**
   * 
   */
	public abstract Map<String, Object> execute() throws CoreException;

}