package org.iq.db;

public class OpenshiftMySqlSession extends DbSession {

	private static final String OPENSHIFT_MYSQL_DB_HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	private static final Short OPENSHIFT_MYSQL_DB_PORT = Short.valueOf(System.getenv("OPENSHIFT_MYSQL_DB_PORT"));
	private static final String OPENSHIFT_MYSQL_DB_USERNAME = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	private static final String OPENSHIFT_MYSQL_DB_PASSWORD = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");

	public OpenshiftMySqlSession(String hostname, Short port,
			String databaseName, String username, String password) {
		super(OPENSHIFT_MYSQL_DB_HOST, OPENSHIFT_MYSQL_DB_PORT, databaseName,
				OPENSHIFT_MYSQL_DB_USERNAME, OPENSHIFT_MYSQL_DB_PASSWORD);
		this.driverQualifiedName = "com.mysql.jdbc.Driver";
		this.urlPattern = URL_PREFIX + "//" + HOSTNAME + ":" + PORT + "/"
				+ DB_NAME;
		this.urlPrefix = "jdbc:mysql:";
	}

}
