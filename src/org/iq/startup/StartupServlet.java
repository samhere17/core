package org.iq.startup;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.iq.config.ConfigFactory;
import org.iq.config.SystemConfig;
import org.iq.exception.CoreException;
import org.iq.logger.LocalLogger;
import org.iq.startup.actions.CacheStartupAction;
import org.iq.startup.actions.LoggerStartupAction;
import org.iq.startup.actions.StartupAction;
import org.iq.startup.actions.UserStartupActions;
import org.iq.ums.startup.UmsStartupAction;

/**
 * @author Sam
 */
@WebServlet(value = "/", loadOnStartup = 0)
public class StartupServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 375299886649118252L;

	private static SystemConfig systemConfig = null;
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
		systemConfig = (SystemConfig) ConfigFactory
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
			
			if (systemConfig.isUserStartupActionsEnabled()) {
				/*
				 * Starting user actions if any
				 */
				UserStartupActions.initialize();
			}

		} catch (CoreException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		System.out.println("APPLICATION STARTED SUCCESSFULLY");
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

		if (systemConfig.isUserStartupActionsEnabled()) {
		/*
		 * Stopping user actions if any
		 */
		UserStartupActions.destroy();
		}

		LocalLogger.logDebug("APPLICATION STOPPED SUCCESSFULLY");
	}
}