package org.iq.ums.util;

import org.iq.db.DbSession;
import org.iq.db.DbSessionFactory;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.ums.UmsContext;

public class UmsDbProvider {

	public static DbSession getDbSession() throws BusinessException {
		try {
			return DbSessionFactory.getDbSession(UmsContext.umsConfig.getUmsDbSessionClassName(),
					UmsContext.umsConfig.getUmsDbHost(), UmsContext.umsConfig.getUmsDbPort(),
					UmsContext.umsConfig.getUmsDbName(), UmsContext.umsConfig.getUmsDbUser(),
					UmsContext.umsConfig.getUmsDbPass());
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}