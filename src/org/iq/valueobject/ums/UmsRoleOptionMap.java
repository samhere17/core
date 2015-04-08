package org.iq.valueobject.ums;

import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsRoleOptionMap extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4634396180723180513L;

	private int roleId;
	private int optionId;
	private boolean enabled;

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the optionId
	 */
	public int getOptionId() {
		return optionId;
	}

	/**
	 * @param optionId
	 *            the optionId to set
	 */
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 *            the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsRoleOptionMap=[" + StringUtil.lineSeparator);
		buffer.append("    roleId=" + roleId + StringUtil.lineSeparator);
		buffer.append("    optionId=" + optionId + StringUtil.lineSeparator);
		buffer.append("    enabled=" + enabled + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}