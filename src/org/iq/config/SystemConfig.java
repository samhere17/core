/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.config;

import org.iq.exception.ConfigException;
import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 */
final public class SystemConfig extends BaseConfig {

	private static final long serialVersionUID = 4783743661393220069L;

	private static final String SYSTEM_CONFIG_DIR = "__sys/";
	private static final String SYSTEM_CONFIG_NAME = "system";

	private String applicationName;
	private boolean userStartupActionsEnabled;
//	private String userStartupActionsClasses;
	
	public SystemConfig() throws ConfigException {
		super(SYSTEM_CONFIG_DIR + SYSTEM_CONFIG_NAME);
	}


	
	class SystemConfigHandler extends PropertiesHandler<SystemConfig> {

		private static final String APPLICATION_NAME_PARAM_KEY = "application.name";
		private static final String USER_STARTUP_ACTIONS_ENABLED_PARAM_KEY = "user.startup.actions.enabled";
//		private static final String USER_STARTUP_ACTIONS_CLASSES_PARAM_KEY = "user.startup.actions.classes";
		
		private static final String DEFAULT_APPLICATION_NAME = "Core Application::iquesters";
		private static final String DEFAULT_USER_STARTUP_ACTIONS_ENABLED = "false";


		public SystemConfigHandler() {
			super(confInputStream);
		}

		/* (non-Javadoc)
		 * @see org.iq.util.handlers.PropertiesHandler#setLocalData()
		 */
		@Override
		public void setLocalData() {
			setApplicationName(properties.getProperty(APPLICATION_NAME_PARAM_KEY,DEFAULT_APPLICATION_NAME));
			setUserStartupActionsEnabled(Boolean.parseBoolean(properties
					.getProperty(USER_STARTUP_ACTIONS_ENABLED_PARAM_KEY,
							DEFAULT_USER_STARTUP_ACTIONS_ENABLED)));
//			setUserStartupActionsClasses(properties.getProperty(USER_STARTUP_ACTIONS_CLASSES_PARAM_KEY));
		}


		/* (non-Javadoc)
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
	 * @param applicationName
	 *            the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the userStartupActionsEnabled
	 */
	public boolean isUserStartupActionsEnabled() {
		return userStartupActionsEnabled;
	}

	/**
	 * @param userStartupActionsEnabled
	 *            the userStartupActionsEnabled to set
	 */
	public void setUserStartupActionsEnabled(boolean userStartupActionsEnabled) {
		this.userStartupActionsEnabled = userStartupActionsEnabled;
	}

	/**
	 * @return the userStartupActionsClasses
	 */
	/*public String getUserStartupActionsClasses() {
		return userStartupActionsClasses;
	}*/

	/**
	 * @param userStartupActionsClasses
	 *            the userStartupActionsClasses to set
	 */
	/*public void setUserStartupActionsClasses(String userStartupActionsClasses) {
		this.userStartupActionsClasses = userStartupActionsClasses;
	}*/
}