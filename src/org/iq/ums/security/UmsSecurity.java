package org.iq.ums.security;

import org.iq.config.ConfigFactory;
import org.iq.logger.LocalLogger;
import org.iq.ums.config.UmsConfig;
import org.iq.ums.vo.UmsUser;
import org.iq.util.StringUtil;

public abstract class UmsSecurity {

	public abstract UmsUser authenticate(String userName, char[] password);

	public abstract String createNativeToken(String userName);

	public abstract boolean isTokenValid(String token);

	/**
	 * @return UmsSecurity
	 */
	public static UmsSecurity getUmsSecurityInstance() {
		
		UmsConfig umsConfig = (UmsConfig) ConfigFactory.getConfig("org.iq.config.UmsConfig");
		if (StringUtil.isEmpty(umsConfig.getUmsSecurityCallbackClass())) {
			return new UmsSecurityCallback();
		} else {
			try {
				Class<?> classDefinition = Class.forName(umsConfig
						.getUmsSecurityCallbackClass());
				return (UmsSecurity) classDefinition.newInstance();
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				LocalLogger.logSevere(e);
				return new UmsSecurityCallback();
			}
		}
	}
}