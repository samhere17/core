package org.iq.config;

import org.iq.db.DbSession;
import org.iq.exception.ConfigException;
import org.iq.util.StringUtil;
import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 */
final public class DatabaseConfig extends BaseConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7251074823540393870L;

//	private static final String DEFAULT_DB_CONFIG_NAME = "core";
	private static final String DB_CONFIG_DIR = "db/";


	private String dbSessionClassname;
	private String dbHost;
	private Short dbPort;
	private String dbUser;
	private String dbPass;
	private String dbName;


	/**
	 * @throws ConfigException 
	 * 
	 */
	/*public DatabaseConfig() throws ConfigException {
		super(DB_CONFIG_DIR + DEFAULT_DB_CONFIG_NAME);
	}*/

	/**
	 * @throws ConfigException 
	 * 
	 */
	public DatabaseConfig(String dbName) throws ConfigException {
		super(DB_CONFIG_DIR + dbName);
	}

	class DatabaseConfigHandler extends PropertiesHandler<DatabaseConfig> {

		private static final String DB_TYPE_KEY = "db.type";
		private static final String DB_HOST_KEY = "db.host";
		private static final String DB_PORT_KEY = "db.port";
		private static final String DB_USER_KEY = "db.user";
		private static final String DB_PASS_KEY = "db.pass";
		private static final String DB_NAME_KEY = "db.name";

		/**
		 * 
		 */
		public DatabaseConfigHandler() {
			super(confInputStream);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.iq.util.handlers.PropertiesHandler#setLocalData()
		 */
		@Override
		public void setLocalData() {
			setDbSessionClassname(DbSession.getDbSessionClassname(properties
					.getProperty(DB_TYPE_KEY)));

			setDbHost(properties.getProperty(DB_HOST_KEY));

			String portStr = StringUtil.getStringValue(properties
					.getProperty(DB_PORT_KEY));
			setDbPort(Short.valueOf(StringUtil.isEmpty(portStr) ? "-1"
					: portStr));

			setDbUser(properties.getProperty(DB_USER_KEY));
			setDbPass(properties.getProperty(DB_PASS_KEY));
			setDbName(properties.getProperty(DB_NAME_KEY));
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
	 * @return the dbSessionClassname
	 */
	public String getDbSessionClassname() {
		return dbSessionClassname;
	}

	/**
	 * @param dbSessionClassname
	 *            the dbSessionClassname to set
	 */
	public void setDbSessionClassname(String dbSessionClassname) {
		this.dbSessionClassname = dbSessionClassname;
	}

	/**
	 * @return the dbHost
	 */
	public String getDbHost() {
		return dbHost;
	}

	/**
	 * @param dbHost
	 *            the dbHost to set
	 */
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	/**
	 * @return the dbPort
	 */
	public Short getDbPort() {
		return dbPort;
	}

	/**
	 * @param dbPort
	 *            the dbPort to set
	 */
	public void setDbPort(Short dbPort) {
		this.dbPort = dbPort;
	}

	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @param dbUser
	 *            the dbUser to set
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	/**
	 * @return the dbPass
	 */
	public String getDbPass() {
		return dbPass;
	}

	/**
	 * @param dbPass
	 *            the dbPass to set
	 */
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName
	 *            the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

}