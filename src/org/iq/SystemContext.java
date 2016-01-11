/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq;

import org.iq.config.ConfigFactory;
import org.iq.config.SystemConfig;
import org.iq.exception.ConfigException;

/**
 * @author Sam
 */
public class SystemContext {

	public static SystemConfig systemConfig = null;

	public static void initialize() throws ConfigException {
		// Loading system configuration files
		systemConfig = (SystemConfig) ConfigFactory.getConfig("org.iq.config.SystemConfig");
	}
}
