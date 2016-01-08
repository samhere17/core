package org.iq.util.system;

import org.iq.SystemContext;
import org.iq.db.DbSession;
import org.iq.db.DbSessionFactory;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;

public class DbProvider {

	public static DbSession getDbSession() throws BusinessException {
		try {
			return DbSessionFactory.getDbSession(SystemContext.systemConfig.getDbSessionClassname(),
					SystemContext.systemConfig.getDbHost(), SystemContext.systemConfig.getDbPort(),
					SystemContext.systemConfig.getDbName(), SystemContext.systemConfig.getDbUser(),
					SystemContext.systemConfig.getDbPass());
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}