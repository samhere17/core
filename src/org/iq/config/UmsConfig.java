package org.iq.config;

import org.iq.db.DbSession;
import org.iq.exception.ConfigException;
import org.iq.util.StringUtil;
import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 */
final public class UmsConfig extends BaseConfig {
	private static final long	serialVersionUID	= -8595191746954249989L;

	private static final String	UMS_CONFIG_NAME		= "ums";

	private String				umsDbSessionClassName;
	private String				umsDbHost;
	private Short				umsDbPort;
	private String				umsDbUser;
	private String				umsDbPass;
	private String				umsDbName;
	private String				umsAnnexSecurityClass;

	private String				registerSuccessRedirectUrl;
	private String				registerFailureRedirectUrl;

	private String				loginSuccessRedirectUrl;
	private String				loginFailureRedirectUrl;

	private String				logoutSuccessRedirectUrl;
	private String				logoutFailureRedirectUrl;

	/* For new users */
	private int					newlyRegisteredDefaultRole;

	public UmsConfig() throws ConfigException {
		super(UMS_CONFIG_NAME);
	}

	class UmsConfigHandler extends PropertiesHandler<UmsConfig> {

		private static final String	UMS_DB_TYPE_KEY							= "iq.ums.db.type";
		private static final String	UMS_DB_HOST_KEY							= "iq.ums.db.host";
		private static final String	UMS_DB_PORT_KEY							= "iq.ums.db.port";
		private static final String	UMS_DB_USER_KEY							= "iq.ums.db.user";
		private static final String	UMS_DB_PASS_KEY							= "iq.ums.db.pass";
		private static final String	UMS_DB_NAME_KEY							= "iq.ums.db.name";
		private static final String	UMS_ANNEX_SECURITY_CLASS_KEY			= "iq.ums.annex.security.class";

		private static final String	UMS_REGISTER_SUCCESS_REDIRECT_URL_KEY	= "register.success.redirect.url";
		private static final String	UMS_REGISTER_FAILURE_REDIRECT_URL_KEY	= "register.failure.redirect.url";

		private static final String	UMS_LOGIN_SUCCESS_REDIRECT_URL_KEY		= "existinguser.login.success.redirect.url";
		private static final String	UMS_LOGIN_FAILURE_REDIRECT_URL_KEY		= "existinguser.login.failure.redirect.url";

		private static final String	UMS_LOGOUT_SUCCESS_REDIRECT_URL_KEY		= "logout.success.redirect.url";
		private static final String	UMS_LOGOUT_FAILURE_REDIRECT_URL_KEY		= "logout.failure.redirect.url";

		private static final String	NEWLY_REGISTERED_DEFAULT_ROLE			= "newuser.registration.default.role.id";

		public UmsConfigHandler() {
			super(confInputStream);
		}

		@Override
		public void setLocalData() {
			setUmsDbSessionClassName(DbSession.getDbSessionClassname(properties.getProperty(UMS_DB_TYPE_KEY)));

			setUmsDbHost(properties.getProperty(UMS_DB_HOST_KEY));

			String portStr = StringUtil.getStringValue(properties.getProperty(UMS_DB_PORT_KEY));
			setUmsDbPort(Short.valueOf(StringUtil.isEmpty(portStr) ? "-1" : portStr));

			setUmsDbUser(properties.getProperty(UMS_DB_USER_KEY));
			setUmsDbPass(properties.getProperty(UMS_DB_PASS_KEY));
			setUmsDbName(properties.getProperty(UMS_DB_NAME_KEY));

			setUmsAnnexSecurityClass(properties.getProperty(UMS_ANNEX_SECURITY_CLASS_KEY));

			setRegisterSuccessRedirectUrl(properties.getProperty(UMS_REGISTER_SUCCESS_REDIRECT_URL_KEY));
			setRegisterFailureRedirectUrl(properties.getProperty(UMS_REGISTER_FAILURE_REDIRECT_URL_KEY));

			setLoginSuccessRedirectUrl(properties.getProperty(UMS_LOGIN_SUCCESS_REDIRECT_URL_KEY));
			setLoginFailureRedirectUrl(properties.getProperty(UMS_LOGIN_FAILURE_REDIRECT_URL_KEY));

			setLogoutSuccessRedirectUrl(properties.getProperty(UMS_LOGOUT_SUCCESS_REDIRECT_URL_KEY));
			setLogoutFailureRedirectUrl(properties.getProperty(UMS_LOGOUT_FAILURE_REDIRECT_URL_KEY));

			setNewlyRegisteredDefaultRole(Integer.valueOf(properties.getProperty(NEWLY_REGISTERED_DEFAULT_ROLE)));
		}

		@Override
		public void loadPropertiesError() {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * @return the umsDbSessionClassName
	 */
	public String getUmsDbSessionClassName() {
		return umsDbSessionClassName;
	}

	/**
	 * @return the umsDbHost
	 */
	public String getUmsDbHost() {
		return umsDbHost;
	}

	/**
	 * @return the umsDbPort
	 */
	public Short getUmsDbPort() {
		return umsDbPort;
	}

	/**
	 * @return the umsDbUser
	 */
	public String getUmsDbUser() {
		return umsDbUser;
	}

	/**
	 * @return the umsDbPass
	 */
	public String getUmsDbPass() {
		return umsDbPass;
	}

	/**
	 * @return the umsDbName
	 */
	public String getUmsDbName() {
		return umsDbName;
	}

	/**
	 * @return the umsSecurityCallbackClass
	 */
	public String getUmsAnnexSecurityClass() {
		return umsAnnexSecurityClass;
	}

	/**
	 * @return the logoutSuccessRedirectUrl
	 */
	public String getLogoutSuccessRedirectUrl() {
		return logoutSuccessRedirectUrl;
	}

	/**
	 * @return the logoutFailureRedirectUrl
	 */
	public String getLogoutFailureRedirectUrl() {
		return logoutFailureRedirectUrl;
	}

	/**
	 * @param umsDbSessionClassName
	 *            the umsDbSessionClassName to set
	 */
	private void setUmsDbSessionClassName(String umsDbSessionClassName) {
		this.umsDbSessionClassName = umsDbSessionClassName;
	}

	/**
	 * @param umsDbHost
	 *            the umsDbHost to set
	 */
	private void setUmsDbHost(String umsDbHost) {
		this.umsDbHost = umsDbHost;
	}

	/**
	 * @param umsDbPort
	 *            the umsDbPort to set
	 */
	private void setUmsDbPort(Short umsDbPort) {
		this.umsDbPort = umsDbPort;
	}

	/**
	 * @param umsDbUser
	 *            the umsDbUser to set
	 */
	private void setUmsDbUser(String umsDbUser) {
		this.umsDbUser = umsDbUser;
	}

	/**
	 * @param umsDbPass
	 *            the umsDbPass to set
	 */
	private void setUmsDbPass(String umsDbPass) {
		this.umsDbPass = umsDbPass;
	}

	/**
	 * @param umsDbName
	 *            the umsDbName to set
	 */
	private void setUmsDbName(String umsDbName) {
		this.umsDbName = umsDbName;
	}

	/**
	 * @param umsAnnexSecurityClass
	 *            the umsAnnexSecurityClass to set
	 */
	private void setUmsAnnexSecurityClass(String umsAnnexSecurityClass) {
		this.umsAnnexSecurityClass = umsAnnexSecurityClass;
	}

	/**
	 * @param loginSuccessRedirectUrl
	 *            the loginSuccessRedirectUrl to set
	 */
	private void setRegisterSuccessRedirectUrl(String registerSuccessRedirectUrl) {
		this.registerSuccessRedirectUrl = registerSuccessRedirectUrl;
	}

	/**
	 * @param loginFailureRedirectUrl
	 *            the loginFailureRedirectUrl to set
	 */
	private void setRegisterFailureRedirectUrl(String registerFailureRedirectUrl) {
		this.registerFailureRedirectUrl = registerFailureRedirectUrl;
	}

	/**
	 * @param logoutSuccessRedirectUrl
	 *            the logoutSuccessRedirectUrl to set
	 */
	private void setLogoutSuccessRedirectUrl(String logoutSuccessRedirectUrl) {
		this.logoutSuccessRedirectUrl = logoutSuccessRedirectUrl;
	}

	/**
	 * @param logoutFailureRedirectUrl
	 *            the logoutFailureRedirectUrl to set
	 */
	private void setLogoutFailureRedirectUrl(String logoutFailureRedirectUrl) {
		this.logoutFailureRedirectUrl = logoutFailureRedirectUrl;
	}

	public String getRegisterSuccessRedirectUrl() {
		return registerSuccessRedirectUrl;
	}

	public String getRegisterFailureRedirectUrl() {
		return registerFailureRedirectUrl;
	}

	public int getNewlyRegisteredDefaultRole() {
		return newlyRegisteredDefaultRole;
	}

	public void setNewlyRegisteredDefaultRole(int newlyRegisteredDefaultRole) {
		this.newlyRegisteredDefaultRole = newlyRegisteredDefaultRole;
	}

	public String getLoginSuccessRedirectUrl() {
		return loginSuccessRedirectUrl;
	}

	public void setLoginSuccessRedirectUrl(String loginSuccessRedirectUrl) {
		this.loginSuccessRedirectUrl = loginSuccessRedirectUrl;
	}

	public String getLoginFailureRedirectUrl() {
		return loginFailureRedirectUrl;
	}

	public void setLoginFailureRedirectUrl(String loginFailureRedirectUrl) {
		this.loginFailureRedirectUrl = loginFailureRedirectUrl;
	}

}
