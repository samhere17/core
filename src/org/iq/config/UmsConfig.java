package org.iq.config;

import org.iq.db.DbSession;
import org.iq.exception.ConfigException;
import org.iq.util.StringUtil;
import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 */
final public class UmsConfig extends BaseConfig {

	private static final long serialVersionUID = -8595191746954249989L;

	private static final String UMS_CONFIG_NAME = "ums";
	private static final String UMS_CONFIG_DIR = "ums/";

	private String umsDbSessionClassName;
	private String umsDbHost;
	private Short umsDbPort;
	private String umsDbUser;
	private String umsDbPass;
	private String umsDbName;
	private String umsSecurityCallbackClass;

	public UmsConfig() throws ConfigException {
		super(UMS_CONFIG_DIR + UMS_CONFIG_NAME);
	}

	class UmsConfigHandler extends PropertiesHandler<UmsConfig> {

		private static final String UMS_DB_TYPE_KEY = "iq.ums.db.type";
		private static final String UMS_DB_HOST_KEY = "iq.ums.db.host";
		private static final String UMS_DB_PORT_KEY = "iq.ums.db.port";
		private static final String UMS_DB_USER_KEY = "iq.ums.db.user";
		private static final String UMS_DB_PASS_KEY = "iq.ums.db.pass";
		private static final String UMS_DB_NAME_KEY = "iq.ums.db.name";
		private static final String UMS_CUSTOM_SECURITY_CALLBACK_CLASS_KEY = "iq.ums.security.callback.class";

		public UmsConfigHandler() {
			super(confInputStream);
		}

		@Override
		public void setLocalData() {
			setUmsDbSessionClassName(DbSession.getDbSessionClassname(properties
					.getProperty(UMS_DB_TYPE_KEY)));

			setUmsDbHost(properties.getProperty(UMS_DB_HOST_KEY));

			String portStr = StringUtil.getStringValue(properties
					.getProperty(UMS_DB_PORT_KEY));
			setUmsDbPort(Short.valueOf(StringUtil.isEmpty(portStr) ? "-1"
					: portStr));

			setUmsDbUser(properties.getProperty(UMS_DB_USER_KEY));
			setUmsDbPass(properties.getProperty(UMS_DB_PASS_KEY));
			setUmsDbName(properties.getProperty(UMS_DB_NAME_KEY));

			setUmsSecurityCallbackClass(properties
					.getProperty(UMS_CUSTOM_SECURITY_CALLBACK_CLASS_KEY));
		}

		@Override
		public void loadPropertiesError() {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * @return the umsDbHost
	 */
	public String getUmsDbHost() {
		return umsDbHost;
	}

	/**
	 * @param umsDbHost
	 *            the umsDbHost to set
	 */
	public void setUmsDbHost(String umsDbHost) {
		this.umsDbHost = umsDbHost;
	}

	/**
	 * @return the umsDbPort
	 */
	public Short getUmsDbPort() {
		return umsDbPort;
	}

	/**
	 * @param umsDbPort
	 *            the umsDbPort to set
	 */
	public void setUmsDbPort(Short umsDbPort) {
		this.umsDbPort = umsDbPort;
	}

	/**
	 * @return the umsDbUser
	 */
	public String getUmsDbUser() {
		return umsDbUser;
	}

	/**
	 * @param umsDbUser
	 *            the umsDbUser to set
	 */
	public void setUmsDbUser(String umsDbUser) {
		this.umsDbUser = umsDbUser;
	}

	/**
	 * @return the umsDbPass
	 */
	public String getUmsDbPass() {
		return umsDbPass;
	}

	/**
	 * @param umsDbPass
	 *            the umsDbPass to set
	 */
	public void setUmsDbPass(String umsDbPass) {
		this.umsDbPass = umsDbPass;
	}

	/**
	 * @return the umsSecurityCallbackClass
	 */
	public String getUmsSecurityCallbackClass() {
		return umsSecurityCallbackClass;
	}

	/**
	 * @param umsSecurityCallbackClass
	 *            the umsSecurityCallbackClass to set
	 */
	public void setUmsSecurityCallbackClass(String umsSecurityCallbackClass) {
		this.umsSecurityCallbackClass = umsSecurityCallbackClass;
	}

	/**
	 * @return the umsDbName
	 */
	public String getUmsDbName() {
		return umsDbName;
	}

	/**
	 * @param umsDbName
	 *            the umsDbName to set
	 */
	public void setUmsDbName(String umsDbName) {
		this.umsDbName = umsDbName;
	}

	/**
	 * @return the umsDbSessionClassName
	 */
	public String getUmsDbSessionClassName() {
		return umsDbSessionClassName;
	}

	/**
	 * @param umsDbSessionClassName
	 *            the umsDbSessionClassName to set
	 */
	public void setUmsDbSessionClassName(String umsDbSessionClassName) {
		this.umsDbSessionClassName = umsDbSessionClassName;
	}
}