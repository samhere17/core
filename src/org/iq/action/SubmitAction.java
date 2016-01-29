/**
 * 
 */
package org.iq.action;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sam
 *
 */
public abstract class SubmitAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1193667392286754698L;
	
	private String serviceName;
	private Map<String, BaseAction> actionMap;

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
	public final Map<String, BaseAction> getActionMap() {
		return actionMap;
	}

	public final BaseAction getAction(String actionKey) {
		if (actionMap != null) {
			BaseAction requestedAction = actionMap.get(actionKey);
			if (requestedAction instanceof RedirectAction) {
				return (RedirectAction) requestedAction;
			} else if (requestedAction instanceof LaunchAction) {
				return (LaunchAction) requestedAction;
			}
		}
		return null;
	}

	/**
	 * @param actionKey
	 * @param launchAction
	 */
	protected final void addLaunchAction(String actionKey, LaunchAction launchAction) {
		if (actionMap == null) {
			actionMap = new HashMap<String, BaseAction>();
		}
		actionMap.put(actionKey, launchAction);
	}

	/**
	 * @param actionKey
	 * @param redirectAction
	 */
	protected final void addRedirectAction(String actionKey, RedirectAction redirectAction) {
		if (actionMap == null) {
			actionMap = new HashMap<String, BaseAction>();
		}
		actionMap.put(actionKey, redirectAction);
	}
}