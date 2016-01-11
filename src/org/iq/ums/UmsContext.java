/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.ums;

import org.iq.config.ConfigFactory;
import org.iq.config.UmsConfig;
import org.iq.exception.ConfigException;
import org.iq.logger.LocalLogger;
import org.iq.ums.security.annex.UmsAnnexSecurity;
import org.iq.util.StringUtil;

/**
 * @author Sam
 */
public final class UmsContext {

	public static UmsConfig umsConfig = null;
	public static UmsAnnexSecurity umsAnnexSecurity = null;

	public static void initialize() throws ConfigException {
		// Loading ums configuration files
		umsConfig = (UmsConfig) ConfigFactory.getConfig("org.iq.config.UmsConfig");

		// Resolving ums annex security instance
		umsAnnexSecurity = getAnnexSecurityInstance();

	}

	private static UmsAnnexSecurity getAnnexSecurityInstance() {
		if (StringUtil.isEmpty(umsConfig.getUmsAnnexSecurityClass())) {
			return new UmsAnnexSecurity();
		} else {
			try {
				Class<?> classDefinition = Class.forName(umsConfig.getUmsAnnexSecurityClass());
				return (UmsAnnexSecurity) classDefinition.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				LocalLogger.logSevere(e);
				return new UmsAnnexSecurity();
			}
		}
	}
}