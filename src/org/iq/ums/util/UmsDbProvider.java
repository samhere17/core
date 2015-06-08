package org.iq.ums.util;

import org.iq.config.ConfigFactory;
import org.iq.db.DbSession;
import org.iq.db.DbSessionFactory;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.ums.config.UmsConfig;

public class UmsDbProvider {

	public static DbSession getDbSession() throws BusinessException {
		UmsConfig umsConfig = (UmsConfig) ConfigFactory
				.getConfig("org.iq.config.UmsConfig");
		try {
			return DbSessionFactory.getDbSession(
					umsConfig.getUmsDbSessionClassName(),
					umsConfig.getUmsDbHost(), umsConfig.getUmsDbPort(),
					umsConfig.getUmsDbName(), umsConfig.getUmsDbUser(),
					umsConfig.getUmsDbPass());
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}