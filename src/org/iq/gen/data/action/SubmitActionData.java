/**
 * 
 */
package org.iq.gen.data.action;

import java.util.HashMap;
import java.util.Map;

import org.iq.gen.GeneratorUtil;

/**
 * @author Sam
 *
 */
public class SubmitActionData extends ActionData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1193667392286754698L;

	private static final String CLASS_SUFFIX = "SA";
	
	private String serviceName;
	private Map<String, ActionData> actionMap;

	/**
	 * @return the serviceName
	 */
	public final String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	protected final void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	/**
	 * @return the actionMap
	 */
	public final Map<String, ActionData> getActionMap() {
		return actionMap;
	}

	public final ActionData getAction(String actionKey) {
		if (actionMap != null) {
			ActionData requestedAction = actionMap.get(actionKey);
			if (requestedAction instanceof RedirectActionData) {
				return (RedirectActionData) requestedAction;
			} else if (requestedAction instanceof LaunchActionData) {
				return (LaunchActionData) requestedAction;
			}
		}
		return null;
	}

	/**
	 * @param actionKey
	 * @param launchAction
	 */
	protected final void addLaunchAction(String actionKey, LaunchActionData launchAction) {
		if (actionMap == null) {
			actionMap = new HashMap<String, ActionData>();
		}
		actionMap.put(actionKey, launchAction);
	}

	/**
	 * @param actionKey
	 * @param redirectAction
	 */
	protected final void addRedirectAction(String actionKey, RedirectActionData redirectAction) {
		if (actionMap == null) {
			actionMap = new HashMap<String, ActionData>();
		}
		actionMap.put(actionKey, redirectAction);
	}
	/**
	 * @return String
	 */
	public String getClassName() {
		return GeneratorUtil.toCamelCase(getName()) + CLASS_SUFFIX;
	}
}