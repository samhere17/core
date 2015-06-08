package org.iq.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.iq.config.ConfigFactory;
import org.iq.config.SystemConfig;
import org.iq.exception.CoreException;
import org.iq.logger.LocalLogger;
import org.iq.service.external.rest.JerseyApplication;
import org.iq.startup.actions.CacheStartupAction;
import org.iq.startup.actions.LoggerStartupAction;
import org.iq.startup.actions.StartupAction;
import org.iq.ums.startup.UmsStartupAction;
import org.iq.util.StringUtil;

/**
 * @author Sam
 */
@WebServlet(value = "/", loadOnStartup = 0)
public class StartupServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 375299886649118252L;

	private Set<String> destroyAction = new HashSet<>();

	private String applicationName = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();

		System.out.println("INITIALIZING APPLICATION...");

		// Loading system configuration files
		SystemConfig systemConfig = (SystemConfig) ConfigFactory
				.getConfig("org.iq.config.SystemConfig");
		applicationName = systemConfig.getApplicationName();
		System.out.println("Application Name = " + applicationName);

		StartupAction startupAction = null;
		try {
			/*
			 * Starting system actions
			 */
			// STARTING LOGGER
			startupAction = new LoggerStartupAction();
			startupAction.init();

			// STARTING CACHE
			startupAction = new CacheStartupAction();
			startupAction.init();

			// STARTING UMS
			startupAction = new UmsStartupAction();
			startupAction.init();

			/*
			 * Starting user actions if any
			 */
			System.out.println("Loading startup-actions.properties...");
			Properties startupActions = new Properties();
			InputStream localInputStream = JerseyApplication.class
					.getResourceAsStream("startup-actions.properties");
			if (localInputStream != null) {
				try {
					startupActions.load(localInputStream);
					System.out
							.println("Loading startup-actions.properties... SUCCESS");
				} catch (IOException localIOException) {
					System.out
							.println("Loading startup-actions.properties... ERROR");
					System.out.println(localIOException);
				}
			}

			Set<Object> startupActionNames = startupActions.keySet();

			for (Object classNameObj : startupActionNames) {
				// STARTING USER ACTION
				String className = (String) classNameObj;
				startupAction = getActionClassInstance(className);
				startupAction.init();

				Boolean destroyRequired = (Boolean) startupActions
						.get(classNameObj);
				if (destroyRequired) {
					destroyAction.add(className);
				}
			}

		} catch (CoreException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		System.out.println("APPLICATION STARTED SUCCESSFULLY");
	}

	/**
	 * 
	 */
	private StartupAction getActionClassInstance(String actionName) {
		if (StringUtil.isEmpty(actionName) == false) {
			try {
				Class<?> actionClass = Class.forName(actionName);
				if (actionClass != null
						&& StartupAction.class.isAssignableFrom(actionClass)) {
					return (StartupAction) actionClass.newInstance();
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
		System.out.println("STOPPING APPLICATION...");
		System.out.println("Application Name = " + applicationName);

		StartupAction startupAction = null;
		/*
		 * Stopping system actions
		 */
		// STOPPING UMS
		startupAction = new UmsStartupAction();
		startupAction.destroy();

		// STOPPING CACHE
		startupAction = new CacheStartupAction();
		startupAction.destroy();

		// STOPPING LOGGER
		startupAction = new LoggerStartupAction();
		startupAction.destroy();

		/*
		 * Stopping user actions if any
		 */
		if (destroyAction != null && destroyAction.size() > 0) {
			for (String className : destroyAction) {
				startupAction = getActionClassInstance(className);
				startupAction.destroy();
			}
		}
		LocalLogger.logDebug("APPLICATION STOPPED SUCCESSFULLY");
	}
}