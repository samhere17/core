package org.iq.service.system;

import java.io.Serializable;
import java.util.HashMap;

import org.iq.db.DbSession;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.ums.vo.UmsSession;

/**
 * @author Sam
 */
public abstract class BaseSystemService implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386897242285580131L;

//	public static final String SUCCESS_URL_KEY = "success-url";
//	public static final String ERROR_URL_KEY = "error-url";

	private HashMap<String, Object> resultMap = new HashMap<String, Object>();
	protected HashMap<String, Object> resultAttributes = new HashMap<String, Object>();
	protected DbSession dbSession = null;
	protected UmsSession umsSession = null;
	protected LocalLogger logger = null;

	/**
	 * 
	 */
	public BaseSystemService() {
//		dbSession = DbSessionFactory.getDbSession();
	}

	/**
	 * 
	 */
	public BaseSystemService(DbSession dbSession) {
		this.dbSession = dbSession;
	}
	
	/**
	 * @param umsSession the umsSession to set
	 */
	public void setUmsSession(UmsSession umsSession) {
		this.umsSession = umsSession;
	}

	/**
	 * @param input
	 * @return HashMap
	 * @throws AmspServiceException
	 */
	public abstract void execute(HashMap<String, Object> input)
			throws ServiceException;

	/**
	 * @param input
	 * @return HashMap
	 * @throws AmspServiceException
	 */
	public HashMap<String, Object> executeService(HashMap<String, Object> input)
			throws ServiceException {
		init(input);
		execute(input);
		resultMap.putAll(resultAttributes);
		return resultMap;
	}

	/**
	 * @param input
	 * @throws AmspServiceException
	 */
	public void init(HashMap<String, Object> input) throws ServiceException {
//		dbSession = DbSessionFactory.getDbSession();
	}
}