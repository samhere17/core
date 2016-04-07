/**
 * 
 */
package org.iq.action;

import java.util.List;

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
//	private Map<String, String> launchActionIdMap;
	private List<String> launchActionIdList;

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
	 * @return the launchActionIdList
	 */
	public final List<String> getLaunchActionIdList() {
		return launchActionIdList;
	}

	/**
	 * @param launchActionIdList the launchActionIdList to set
	 */
	protected final void setLaunchActionIdList(List<String> launchActionIdList) {
		this.launchActionIdList = launchActionIdList;
	}

	/**
	 * @return the launchActionMap
	 */
	/*public final Map<String, String> getLaunchActionIdMap() {
		return launchActionIdMap;
	}

	public final String getLaunchActionId(String actionKey) {
		if (launchActionIdMap != null) {
			return launchActionIdMap.get(actionKey);
		}
		return null;
	}*/

	/**
	 * @param actionKey
	 * @param launchAction
	 */
	/*protected final void addLaunchActionId(String actionKey, String actionId) {
		if (launchActionIdMap == null) {
			launchActionIdMap = new HashMap<String, String>();
		}
		launchActionIdMap.put(actionKey, actionId);
	}*/
}