package org.iq;

import java.io.Serializable;

import org.iq.db.DbSession;

/**
 * @author Sam
 *
 */
public abstract class Base implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5447689037671607468L;

	protected DbSession dbSession = null;
	
	/**
	 * 
	 */
	public Base(DbSession dbSession) {
		this.dbSession = dbSession;
	}
}