package org.iq.db;

/**
 * @author Sam
 */
public class MySqlSession extends DbSession {
	// "jdbc:mysql://hostname:port/dbname"

	/**
	 * 
	 */
	public MySqlSession(String hostname, Short port, String databaseName,
			String username, String password) {
		super(hostname, port, databaseName, username, password);
		this.driverQualifiedName = "com.mysql.jdbc.Driver";
		this.urlPattern = URL_PREFIX + "//" + HOSTNAME + ":" + PORT + "/"
				+ DB_NAME;
		this.urlPrefix = "jdbc:mysql:";
	}
}