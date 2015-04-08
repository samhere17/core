package org.iq.startup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.iq.cache.CacheCleaner;
import org.iq.cache.CacheEvictor;
import org.iq.cache.SystemCache;
import org.iq.config.ConfigFactory;
import org.iq.config.SystemConfig;
import org.iq.logger.LocalLogger;
import org.iq.startup.actions.BaseStartupAction;
import org.iq.util.StringUtil;

/**
 * @author Sam
 */
public class StartupServlet extends GenericServlet {

	/**
   * 
   */
	private static final long serialVersionUID = 375299886649118252L;

	// private ServletContext servletContext = null;
	// private ServletConfig servletConfig = null;
	// private String applicationName = null;

	// private Boolean enableQueue = null;

//	private Boolean enableUserStartupActions = null;
	private String[] userStartupActionClassNames = null;
	private HashMap<String, Object> startupAttributeMap = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("INITIALIZING APPLICATION...");
		
//		new SystemContext(getServletContext().getRealPath("/"));

		System.out.println(getServletContext().getContextPath());

		// Loading configuration files
		SystemConfig systemConfig = (SystemConfig) ConfigFactory.getConfig("org.iq.config.SystemConfig");
		// DatabaseConfig databaseConfig = (DatabaseConfig)
		// ConfigFactory.getConfig("DatabaseConfig","core");

		System.out.println("Application Name = "
				+ systemConfig.getApplicationName());

		// LocalLogger.logDebug("Application Name = " +
		// systemConfig.getApplicationName());

		// servletContext = getServletContext();
		// servletConfig = getServletConfig();
		// applicationName =
		// servletContext.getInitParameter(APPLICATION_NAME_PARAM_KEY);
		// System.out.println("Application Name = " + applicationName);
		//
		// applicationRoot = servletContext.getRealPath("/");
		// System.out.println("##### = " + applicationRoot);

		// enableQueue =
		// Boolean.valueOf(servletConfig
		// .getInitParameter(ENABLE_QUEUE_PARAM_KEY));
		// System.out.println("enableQueue = " + enableQueue);

		// if (enableQueue) {
		// QueueMaster.startQueueService();
		// }

		/*
		 * enableUserStartupActions = Boolean.valueOf(systemConfig
		 * .getInitParameter(ENABLE_USER_STARTUP_ACTIONS_PARAM_KEY));
		 * System.out.println("enableUserStartupActions = " +
		 * enableUserStartupActions);
		 */
		if (systemConfig.isUserStartupActionsEnabled()) {
			System.out.println("User Startup Actions Enabled");

			String classNamesStr = systemConfig.getUserStartupActionsClasses();
			if (StringUtil.isEmpty(classNamesStr) == false) {
				userStartupActionClassNames = classNamesStr.split(",");
				if (userStartupActionClassNames != null
						&& userStartupActionClassNames.length > 0) {
					startupAttributeMap = new HashMap<String, Object>();
					for (String startupActionClassName : userStartupActionClassNames) {
						BaseStartupAction startupAction = getActionClassInstance(startupActionClassName);
						if (startupAction != null) {
							Map<String, Object> returnMap;
							try {
								returnMap = startupAction.execute();
								if(returnMap != null && returnMap.isEmpty() == false){
									startupAttributeMap.putAll(returnMap);
								}
							} catch (/*Core*/Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("Startup Action: "+ startupAction.getClass().getName()+ " executed successfully.");
						}
					}
				}
			}
		}
		
		SystemCache.initialize();
	    try {

	       CacheEvictor.getEvictorInstance();
	       CacheCleaner.getCacheCleanerInstance();
	    }
	    catch (Exception e) {
	    	// TODO Auto-generated catch block
			e.printStackTrace();
	    }

		LocalLogger.logDebug("APPLICATION STARTED SUCCESSFULLY");
	}

	/**
   * 
   */
	private BaseStartupAction getActionClassInstance(String actionName) {
		if (StringUtil.isEmpty(actionName) == false) {
			try {
				Class<?> actionClass = Class.forName(actionName);
				if (actionClass != null
						&& BaseStartupAction.class
								.isAssignableFrom(actionClass)) {
					return (BaseStartupAction) actionClass.newInstance();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
		// QueueMaster.stopQueueService();
	}
}