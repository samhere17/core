package org.iq.startup.actions;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.iq.exception.CoreException;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public class UserStartupActions {
	
	private static Set<StartupAction> initActions = new HashSet<>();
	private static Set<StartupAction> destroyActions = new HashSet<>();

	
	static {
		/*
		 * Starting user actions if any
		 */
		System.out.println("Loading startup-actions.properties...");
		Properties startupActionsProps = new Properties();
		InputStream localInputStream = UserStartupActions.class.getResourceAsStream("conf/__sys/startup-actions.properties");
		if (localInputStream != null) {
			try {
				startupActionsProps.load(localInputStream);
				System.out.println("Loading startup-actions.properties... SUCCESS");
				
				Set<Object> startupActionNames = startupActionsProps.keySet();

				for (Object classNameObj : startupActionNames) {
					StartupAction startupAction = getStartupAction((String) classNameObj);
					
					initActions.add(startupAction);

					Boolean destroyRequired = (Boolean) startupActionsProps.get(classNameObj);
					if (destroyRequired) {
						destroyActions.add(startupAction);
					}
				}

			} catch (IOException localIOException) {
				System.out.println("Loading startup-actions.properties... ERROR");
				System.out.println(localIOException);
			}
		}
	}
	
	public static void initialize() throws CoreException {
		for (StartupAction startupAction : initActions) {
			startupAction.init();
		}
	}
	
	public static void destroy() {
		for (StartupAction startupAction : destroyActions) {
			startupAction.destroy();;
		}
	}

	/**
	 * 
	 */
	private static StartupAction getStartupAction(String actionName) {
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

}