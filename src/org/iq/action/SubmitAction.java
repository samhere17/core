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
	private Map<String, LaunchAction> launchActionMap;

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
	 * @return the launchActionMap
	 */
	public final Map<String, LaunchAction> getLaunchActionMap() {
		return launchActionMap;
	}

	public final LaunchAction getLaunchAction(String actionKey) {
		if (launchActionMap != null) {
			return launchActionMap.get(actionKey);
		}
		return null;
	}

	/**
	 * @param actionKey
	 * @param launchAction
	 */
	protected final void addLaunchAction(String actionKey, LaunchAction launchAction) {
		if (launchActionMap == null) {
			launchActionMap = new HashMap<String, LaunchAction>();
		}
		launchActionMap.put(actionKey, launchAction);
	}
}