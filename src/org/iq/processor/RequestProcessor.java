package org.iq.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.iq.Constants;
import org.iq.ServiceConstants;
import org.iq.SystemContext;
import org.iq.action.Actions;
import org.iq.action.BaseAction;
import org.iq.action.LaunchAction;
import org.iq.action.SubmitAction;
import org.iq.cache.CacheHelper;
import org.iq.exception.BaseException;
import org.iq.exception.CacheException;
import org.iq.exception.RenderableException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.ServicesDefinitions;
import org.iq.service.system.BaseSystemService;
import org.iq.ums.exception.UmsException;
import org.iq.ums.helper.UmsAuthenticationHelper;
import org.iq.ums.vo.UmsSession;
import org.iq.util.StringUtil;

/**
 * @author Sam
 */
public class RequestProcessor extends BaseProcessor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6193888847884264953L;

	private static final String ERROR_MESSAGE_KEY = "errorMessage";
	private static final String STACK_TRACE_KEY = "stackTrace";

	private static final String ERROR_PAGE = "error.jsp";

	/**
	 * a unique identifier for each jSession
	 */
	protected String jSessionId = null;

	/**
	 * a unique identifier for each request
	 */
	protected String requestId = null;

	/**
	 * an identifier for request type
	 */
	protected RequestType requestType = null;

	
	/**
	 * requested action name
	 */
	protected String requestedActionName = null;

	/**
	 * requested service name
	 */
	protected String requestedServiceName = null;

	/**
	 * requested service
	 */
	protected BaseAction requestedAction = null;
	
	/**
	 * requested service
	 */
	protected BaseService requestedService = null;
	
	/**
	 * 
	 */
	protected UmsSession umsSession = null;

	/**
	 * 
	 */
	Map<String, Object> inputMap = null;
	
	/**
	 * 
	 */
	Map<String, Object> resultMap = null;
	
	/**
	 * 
	 */
	public RequestProcessor(String jSessionId, RequestType requestType) {
		this.jSessionId = jSessionId;
		this.requestType = requestType;
		this.requestId = "R-" + UUID.randomUUID().toString();
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @param input
	 * @return Map<String, Object>
	 */
	public Map<String, Object> processRequest(Map<String, Object> input) {
		requestedActionName = StringUtil.getStringValue(input.get(Constants.REQUESTED_ACTION_KEY));

		logParameters(input);

		inputMap = input;
		resultMap = new HashMap<String, Object>();

		try {
			prepareActionClass();
			
			if (requestedAction.isSessionRequired()) {
				CacheHelper cacheHelper = new CacheHelper();
				umsSession = (UmsSession) cacheHelper.getElement("UMS_SESSIONS", jSessionId);

				// If umsSession is not available, return to web context
				if (umsSession == null) {
					resultMap.put(ServiceConstants.REDIRECT_URL, SystemContext.systemConfig.getWebContextRoot());
					return resultMap;
				}

				// If SystemSessionId is not valid, return to web context
				if (new UmsAuthenticationHelper().isTicketValid(umsSession.getSystemSessionId()) == false) {
					resultMap.put(ServiceConstants.REDIRECT_URL, SystemContext.systemConfig.getWebContextRoot());
					return resultMap;
				}
			}
			
			switch (requestType) {
			case GET:
				if (requestedAction instanceof LaunchAction) {
					LaunchAction launchAction = (LaunchAction) requestedAction;
					processLaunchAction(launchAction);
				} else {
					throw new ServiceException("HTTP request method GET only supports Launch Actions");
				}
				break;
			case POST:
				if (requestedAction instanceof SubmitAction) {
					SubmitAction submitAction = (SubmitAction) requestedAction;
					processSubmitAction(submitAction);
				} else {
					throw new ServiceException("HTTP request method POST only supports Submit Actions");
				}
				break;
			default:
				break;
			}
		} catch(UmsException e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(ClassNotFoundException e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(InstantiationException e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(IllegalAccessException e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(RenderableException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
//			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
//			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(ServiceException e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(Exception e) {
			resultMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			resultMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			resultMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		}

		logResults(resultMap);
		
		return resultMap;
	}
	

	/**
	 * @throws ServiceException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private void prepareActionClass()
			throws ServiceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String requestedActionClassName = Actions.getActionClassName(requestedActionName);

		if (StringUtil.isEmpty(requestedActionClassName)) {
			throw new ServiceException("Class name not found for requested action = " + requestedActionName);
		}
		Class<?> actionClass = Class.forName(requestedActionClassName);
		requestedAction = (BaseAction) actionClass.newInstance();
	}

	/**
	 * @param requestedServiceName
	 * @throws ServiceException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private void prepareServiceClass(String requestedServiceName)
			throws ServiceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		this.requestedServiceName = requestedServiceName;
		String requestedServiceClassName = ServicesDefinitions.getServiceClassName(this.requestedServiceName);
		
		if (StringUtil.isEmpty(requestedServiceClassName)) {
			throw new ServiceException("Class name not found for requested service = " + this.requestedServiceName);
		}
		
		Class<?> serviceClass = Class.forName(requestedServiceClassName);
		requestedService = (BaseService) serviceClass.newInstance();
		requestedService.setUmsSession(umsSession);
	}
	
	/**
	 * @param launchAction
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws ServiceException 
	 */
	private void processLaunchAction(LaunchAction launchAction)
			throws ServiceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (launchAction != null) {
			if (StringUtils.isNotEmpty(launchAction.getServiceName())) {
				prepareServiceClass(launchAction.getServiceName());
				resultMap = executeService(inputMap);
			}
			
			/*
			 * All redirects should go to <context path>/ui with a page id as
			 * parameter. If page id is not passed system should redirect to the
			 * redirect url provided.
			 */
			String redirectUrl = null;
			
			if (StringUtils.isNotEmpty(launchAction.getPageId())) {
				redirectUrl = "ui?page="+launchAction.getPageId();
			} else if (StringUtils.isNotEmpty(launchAction.getRedirectUrl())) {
				redirectUrl = launchAction.getRedirectUrl();
			}
			
			resultMap.put(ServiceConstants.REDIRECT_URL, redirectUrl);

		} else {

			throw new ServiceException("Launch Action cannot be null");

		}
	}
	
	/**
	 * @param submitAction
	 * @throws ServiceException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private void processSubmitAction(SubmitAction submitAction)
			throws ServiceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		if (submitAction != null) {
			if (StringUtils.isNotEmpty(submitAction.getServiceName())) {

				prepareServiceClass(submitAction.getServiceName());
				resultMap = executeService(inputMap);

				processLaunchAction(submitAction.getLaunchAction(requestedService.getRedirectUrlKey()));

			} else {

				throw new ServiceException("Submit Action must have a Service Name");

			}
		} else {

			throw new ServiceException("Submit Action cannot be null");

		}
	}


	/**
	 * @param input
	 * @return Map<String, Object>
	 * @throws ServiceException
	 */
	private Map<String, Object> executeService(Map<String, Object> input) throws ServiceException {
		return requestedService.executeService((HashMap<String, Object>) input);
	}



/*	private boolean isSessionCheckRequired() {
		// Checking if service is Authentication service or Registration service
		// TODO forget password and/or any other service which do not require valid session
		return ServiceConstants.AUTHENTICATION_SERVICE_NAME.equals(requestedServiceName) == false
				&& ServiceConstants.REGISTRATION_SERVICE_NAME.equals(requestedServiceName) == false
				&& ServiceConstants.VERIFICATION_SERVICE_NAME.equals(requestedServiceName) == false;
	}
*/
	
	/**
	 * @author Sam
	 *
	 */
	public enum RequestType {
		GET(1), POST(2);

		private final int type;

		private RequestType(int type) {
			this.type = type;
		}

		public int getRequestTypeValue() {
			return type;
		}

		public static RequestType getRequestType(int type) {
			RequestType returnType = null;
			for(RequestType thisType : RequestType.values()) {
				if(thisType.getRequestTypeValue() == type) {
					returnType = thisType;
					break;
				}
			}
			return returnType;
		}

		@Override
		public String toString() {
			switch(this) {
				case GET:
					return "Get";
				case POST:
					return "Post";
				default:
					return "Unknown";
			}
		}
	}

	/**
	 * @param inputMap
	 * @return
	 */
	public Map<? extends String, ? extends Object> processSystemRequest(Map<String, Object> inputMap) {
		HashMap<String, Object> returnMap = new HashMap<String, Object>();

		try {
			// building object for Menu
			// Map<String, Object> menuInputMap = new HashMap<String, Object>();
			inputMap.put(ServiceConstants.REQUESTED_SERVICE_NAME_KEY, "GetMenu");

			CacheHelper cacheHelper = new CacheHelper();
			umsSession = (UmsSession) cacheHelper.getElement("UMS_SESSIONS", jSessionId);

			if(umsSession == null) {
				return returnMap;
			}

			returnMap.putAll(executeSystemService(inputMap));
		} catch(ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			returnMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			returnMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			returnMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			returnMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			returnMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			returnMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			returnMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			returnMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		} catch(CacheException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnMap.put(ERROR_MESSAGE_KEY, (e.getMessage() != null ? e.getMessage() : e.toString()));
			returnMap.put(STACK_TRACE_KEY, BaseException.getStackTraceForWeb(e));
			returnMap.put(ServiceConstants.REDIRECT_URL, ERROR_PAGE);
		}
		return returnMap;
	}

	private Map<String, Object> executeSystemService(Map<String, Object> input)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServiceException {

		String systemServiceName = StringUtil.getStringValue(input.get(ServiceConstants.REQUESTED_SERVICE_NAME_KEY));

		Class<?> serviceClass = Class.forName(ServicesDefinitions.getServiceClassName(systemServiceName));
		BaseSystemService systemService = (BaseSystemService) serviceClass.newInstance();
		systemService.setUmsSession(umsSession);
		return systemService.executeService((HashMap<String, Object>) input);
	}

	/**
	 * @param input
	 */
	private void logParameters(Map<String, Object> input) {
		LocalLogger.logDebug("######################################################################");
		LocalLogger.logDebug("JSESSION Id      = " + jSessionId);
		LocalLogger.logDebug("Request Id       = " + requestId);
		LocalLogger.logDebug("Request Type     = " + requestType);
		LocalLogger.logDebug("Requested Action = " + requestedActionName);
		LocalLogger.logDebug("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		Set<String> paramNames = input.keySet();
		for (String paramName : paramNames) {
			LocalLogger.logDebug("Param Name:" + paramName + " and Param Value:" + input.get(paramName));
		}
		LocalLogger.logDebug("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
	}
	
	/**
	 * @param resultMap
	 */
	private void logResults(Map<String, Object> resultMap) {
		LocalLogger.logDebug("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		LocalLogger.logDebug("Result:");
		Set<String> resultNames = resultMap.keySet();
		for(String resultName : resultNames) {
			LocalLogger.logDebug("Result Name:" + resultName + " and Result Value:" + resultMap.get(resultName));
		}
		LocalLogger.logDebug("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		LocalLogger
				.logDebug("Redirect Url: " + StringUtil.getStringValue(resultMap.get(ServiceConstants.REDIRECT_URL)));
		LocalLogger.logDebug("######################################################################");

	}
}
