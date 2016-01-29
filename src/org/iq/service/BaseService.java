package org.iq.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

import org.iq.ServiceConstants;
import org.iq.db.DbSession;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.ums.vo.UmsSession;
import org.iq.util.StringUtil;

/**
 * @author Sam
 */
public abstract class BaseService implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386897242285580131L;

//	public static final String SUCCESS_URL_KEY = "success-url";
//	public static final String ERROR_URL_KEY = "error-url";

	private HashMap<String, Object> resultMap = new HashMap<String, Object>();
	protected HashMap<String, Object> resultAttributes = new HashMap<String, Object>();
	protected String redirectUrl = null;
	protected String redirectUrlKey = null;
//	protected DbSession dbSession = null;
	protected UmsSession umsSession = null;
	protected LocalLogger logger = null;

	/**
	 * 
	 */
	public BaseService() {
//		dbSession = DbSessionFactory.getDbSession();
	}

	/**
	 * 
	 */
	public BaseService(DbSession dbSession) {
//		this.dbSession = dbSession;
	}
	
	/**
	 * @param umsSession the umsSession to set
	 */
	public void setUmsSession(UmsSession umsSession) {
		this.umsSession = umsSession;
	}
	
	/**
	 * @return the redirectUrlKey
	 */
	public final String getRedirectUrlKey() {
		return redirectUrlKey;
	}

	/**
	 * @param redirectUrlKey
	 *            the redirectUrlKey to set
	 */
	protected final void setRedirectUrlKey(String redirectUrlKey) {
		this.redirectUrlKey = redirectUrlKey;
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
		// validateAllInput(input);
		execute(input);
		resultMap.putAll(resultAttributes);
//		resultMap.put(ServiceConstants.RESULT_ATTRIBUTES, resultAttributes);
		resultMap.put(ServiceConstants.REDIRECT_URL, redirectUrl);
		return resultMap;
	}

	/**
	 * @param input
	 * @throws AmspServiceException
	 */
	public void init(HashMap<String, Object> input) throws ServiceException {
//		dbSession = DbSessionFactory.getDbSession();
	}

	/**
	 * @param input
	 * @param key
	 * @throws AmspServiceException
	 */
	protected void validateInput(HashMap<String, Object> input, String key)
			throws ServiceException {
		Object data = input.get(key);
		if (StringUtil.isEmpty(StringUtil.getStringValue(data))) {
			throw new ServiceException("Input Field : " + key
					+ " is null or blank.");
		}
	}

	/**
	 * @param input
	 * @throws AmspServiceException
	 */
	protected void validateAllInput(HashMap<String, Object> input)
			throws ServiceException {
		Set<String> keys = input.keySet();
		for (String thisKey : keys) {
			Object data = input.get(thisKey);
			if (StringUtil.isEmpty(StringUtil.getStringValue(data))) {
				throw new ServiceException("Input Field : " + thisKey
						+ " is null or blank.");
			}
		}
	}
}