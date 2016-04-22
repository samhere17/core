/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.config;

import org.iq.db.DbSession;
import org.iq.exception.ConfigException;
import org.iq.util.StringUtil;
import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 */
final public class SystemConfig extends BaseConfig {

	private static final long serialVersionUID = 4783743661393220069L;

	private static final String SYSTEM_CONFIG_NAME = "system";

	private String applicationName;
	private String applicationAlias;
	private boolean userStartupActionsEnabled;

	private String dbSessionClassname;
	private String dbHost;
	private Short dbPort;
	private String dbUser;
	private String dbPass;
	private String dbName;

	private String textGuruSource;
	private String textGuruUsername;
	private String textGuruPassword;

	private String mailUsername;
	private String mailPassword;
	private String mailSmtpAuthFlag;
	private String mailSmtpTLSEnableFlag;
	private String mailSmtpHost;
	private String mailSmtpPort;
	
	private String webContextRoot;

	public SystemConfig() throws ConfigException {
		super(SYSTEM_CONFIG_NAME);
	}

	class SystemConfigHandler extends PropertiesHandler<SystemConfig> {

		private static final String APPLICATION_NAME_PARAM_KEY = "application.name";
		private static final String APPLICATION_ALIAS_PARAM_KEY = "application.alias";
		private static final String USER_STARTUP_ACTIONS_ENABLED_PARAM_KEY = "user.startup.actions.enabled";

		private static final String DB_TYPE_PARAM_KEY = "db.type";
		private static final String DB_HOST_PARAM_KEY = "db.host";
		private static final String DB_PORT_PARAM_KEY = "db.port";
		private static final String DB_USER_PARAM_KEY = "db.user";
		private static final String DB_PASS_PARAM_KEY = "db.pass";
		private static final String DB_NAME_PARAM_KEY = "db.name";

		private static final String TEXTGURU_SOURCE = "textguru.source";
		private static final String TEXTGURU_USERNAME = "textguru.username";
		private static final String TEXTGURU_PASSWORD = "textguru.password";

		private static final String MAIL_USERNAME = "mail.username";
		private static final String MAIL_PASSWORD = "mail.password";
		private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
		private static final String MAIL_SMTP_TLS_ENABLE = "mail.smtp.starttls.enable";
		private static final String MAIL_SMTP_HOST = "mail.smtp.host";
		private static final String MAIL_SMTP_PORT = "mail.smtp.port";

		private static final String DEFAULT_APPLICATION_NAME = "Core Application::iquesters";
		private static final String DEFAULT_USER_STARTUP_ACTIONS_ENABLED = "false";
		
		private static final String WEB_CONTEXT_ROOT = "web.context.root"; 

		public SystemConfigHandler() {
			super(confInputStream);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.iq.util.handlers.PropertiesHandler#setLocalData()
		 */
		@Override
		public void setLocalData() {
			/*
			 * Setting system level configurations
			 */
			setApplicationName(properties.getProperty(APPLICATION_NAME_PARAM_KEY, DEFAULT_APPLICATION_NAME));
			setApplicationAlias(properties.getProperty(APPLICATION_ALIAS_PARAM_KEY, DEFAULT_APPLICATION_NAME));
			setUserStartupActionsEnabled(Boolean.parseBoolean(properties
					.getProperty(USER_STARTUP_ACTIONS_ENABLED_PARAM_KEY, DEFAULT_USER_STARTUP_ACTIONS_ENABLED)));

			/*
			 * Setting configurations for the database connectivity
			 */
			setDbSessionClassname(DbSession.getDbSessionClassname(properties.getProperty(DB_TYPE_PARAM_KEY)));
			setDbHost(properties.getProperty(DB_HOST_PARAM_KEY));

			String portStr = StringUtil.getStringValue(properties.getProperty(DB_PORT_PARAM_KEY));
			setDbPort(Short.valueOf(StringUtil.isEmpty(portStr) ? "-1" : portStr));

			setDbUser(properties.getProperty(DB_USER_PARAM_KEY));
			setDbPass(properties.getProperty(DB_PASS_PARAM_KEY));
			setDbName(properties.getProperty(DB_NAME_PARAM_KEY));

			/*
			 * Setting configurations for the SMS communications
			 */
			setTextGuruSource(properties.getProperty(TEXTGURU_SOURCE));
			setTextGuruUsername(properties.getProperty(TEXTGURU_USERNAME));
			setTextGuruPassword(properties.getProperty(TEXTGURU_PASSWORD));

			/*
			 * Setting configurations for the email communications
			 */
			setMailUsername(properties.getProperty(MAIL_USERNAME));
			setMailPassword(properties.getProperty(MAIL_PASSWORD));
			setMailSmtpAuthFlag(properties.getProperty(MAIL_SMTP_AUTH));
			setMailSmtpTLSEnableFlag(properties.getProperty(MAIL_SMTP_TLS_ENABLE));
			setMailSmtpHost(properties.getProperty(MAIL_SMTP_HOST));
			setMailSmtpPort(properties.getProperty(MAIL_SMTP_PORT));
			
			setWebContextRoot(properties.getProperty(WEB_CONTEXT_ROOT));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.iq.util.handlers.PropertiesHandler#loadPropertiesError()
		 */
		@Override
		public void loadPropertiesError() {
			// TODO Auto-generated method stub
		}
	}
	
	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @return the applicationAlias
	 */
	public String getApplicationAlias() {
		return applicationAlias;
	}

	/**
	 * @return the userStartupActionsEnabled
	 */
	public boolean isUserStartupActionsEnabled() {
		return userStartupActionsEnabled;
	}

	/**
	 * @return the dbSessionClassname
	 */
	public String getDbSessionClassname() {
		return dbSessionClassname;
	}

	/**
	 * @return the dbHost
	 */
	public String getDbHost() {
		return dbHost;
	}

	/**
	 * @return the dbPort
	 */
	public Short getDbPort() {
		return dbPort;
	}

	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @return the dbPass
	 */
	public String getDbPass() {
		return dbPass;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @return the textGuruSource
	 */
	public String getTextGuruSource() {
		return textGuruSource;
	}

	/**
	 * @return the textGuruUsername
	 */
	public String getTextGuruUsername() {
		return textGuruUsername;
	}

	/**
	 * @return the textGuruPassword
	 */
	public String getTextGuruPassword() {
		return textGuruPassword;
	}

	/**
	 * @return the mailUsername
	 */
	public String getMailUsername() {
		return mailUsername;
	}

	/**
	 * @return the mailPassword
	 */
	public String getMailPassword() {
		return mailPassword;
	}

	/**
	 * @return the mailSmtpAuthFlag
	 */
	public String getMailSmtpAuthFlag() {
		return mailSmtpAuthFlag;
	}

	/**
	 * @return the mailSmtpTLSEnableFlag
	 */
	public String getMailSmtpTLSEnableFlag() {
		return mailSmtpTLSEnableFlag;
	}

	/**
	 * @return the mailSmtpHost
	 */
	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	/**
	 * @return the mailSmtpPort
	 */
	public String getMailSmtpPort() {
		return mailSmtpPort;
	}

	/**
	 * @return the webContextRoot
	 */
	public String getWebContextRoot() {
		return webContextRoot;
	}

	/**
	 * @param applicationName
	 *            the applicationName to set
	 */
	private void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @param applicationAlias the applicationAlias to set
	 */
	private void setApplicationAlias(String applicationAlias) {
		this.applicationAlias = applicationAlias;
	}

	/**
	 * @param userStartupActionsEnabled
	 *            the userStartupActionsEnabled to set
	 */
	private void setUserStartupActionsEnabled(boolean userStartupActionsEnabled) {
		this.userStartupActionsEnabled = userStartupActionsEnabled;
	}

	/**
	 * @param dbSessionClassname
	 *            the dbSessionClassname to set
	 */
	private void setDbSessionClassname(String dbSessionClassname) {
		this.dbSessionClassname = dbSessionClassname;
	}

	/**
	 * @param dbHost
	 *            the dbHost to set
	 */
	private void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	/**
	 * @param dbPort
	 *            the dbPort to set
	 */
	private void setDbPort(Short dbPort) {
		this.dbPort = dbPort;
	}

	/**
	 * @param dbUser
	 *            the dbUser to set
	 */
	private void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	/**
	 * @param dbPass
	 *            the dbPass to set
	 */
	private void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	/**
	 * @param dbName
	 *            the dbName to set
	 */
	private void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @param textGuruSource
	 *            the textGuruSource to set
	 */
	private void setTextGuruSource(String textGuruSource) {
		this.textGuruSource = textGuruSource;
	}

	/**
	 * @param textGuruUsername
	 *            the textGuruUsername to set
	 */
	private void setTextGuruUsername(String textGuruUsername) {
		this.textGuruUsername = textGuruUsername;
	}

	/**
	 * @param textGuruPassword
	 *            the textGuruPassword to set
	 */
	private void setTextGuruPassword(String textGuruPassword) {
		this.textGuruPassword = textGuruPassword;
	}

	/**
	 * @param mailUsername
	 *            the mailUsername to set
	 */
	private void setMailUsername(String mailUsername) {
		this.mailUsername = mailUsername;
	}

	/**
	 * @param mailPassword
	 *            the mailPassword to set
	 */
	private void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	/**
	 * @param mailSmtpAuthFlag
	 *            the mailSmtpAuthFlag to set
	 */
	private void setMailSmtpAuthFlag(String mailSmtpAuthFlag) {
		this.mailSmtpAuthFlag = mailSmtpAuthFlag;
	}

	/**
	 * @param mailSmtpTLSEnableFlag
	 *            the mailSmtpTLSEnableFlag to set
	 */
	private void setMailSmtpTLSEnableFlag(String mailSmtpTLSEnableFlag) {
		this.mailSmtpTLSEnableFlag = mailSmtpTLSEnableFlag;
	}

	/**
	 * @param mailSmtpHost
	 *            the mailSmtpHost to set
	 */
	private void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}

	/**
	 * @param mailSmtpPort
	 *            the mailSmtpPort to set
	 */
	private void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}

	/**
	 * @param webContextRoot the webContextRoot to set
	 */
	private void setWebContextRoot(String webContextRoot) {
		this.webContextRoot = webContextRoot;
	}
}