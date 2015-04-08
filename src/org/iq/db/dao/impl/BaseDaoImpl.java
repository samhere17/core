package org.iq.db.dao.impl;

import org.iq.Base;
import org.iq.db.DbSession;

public abstract class BaseDaoImpl extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6917368018392556478L;

	public BaseDaoImpl(DbSession dbSession) {
		super(dbSession);
	}
}