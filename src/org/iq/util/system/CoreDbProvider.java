package org.iq.util.system;

import org.iq.config.ConfigFactory;
import org.iq.config.DatabaseConfig;
import org.iq.db.DbSession;
import org.iq.db.DbSessionFactory;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;

public class CoreDbProvider {

	private static final String CORE_DB_CONFIG_NAME = "core";

	public static DbSession getDbSession() throws BusinessException {
		DatabaseConfig databaseConfig = (DatabaseConfig) ConfigFactory
				.getConfig("org.iq.config.DatabaseConfig", CORE_DB_CONFIG_NAME);
		try {
			return DbSessionFactory.getDbSession(
					databaseConfig.getDbSessionClassname(),
					databaseConfig.getDbHost(), databaseConfig.getDbPort(),
					databaseConfig.getDbName(), databaseConfig.getDbUser(),
					databaseConfig.getDbPass());
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}