/**
 * 
 */
package org.iq.valueobject.ums;

import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

/**
 * @author Sam
 * 
 */
public class UmsUserRoleMap extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4825232621167632316L;

	private int userId;
	private int roleId;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.valueobject.BaseVO#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsUserRoleMap = [" + StringUtil.lineSeparator);
		buffer.append("    userID = " + userId + StringUtil.lineSeparator);
		buffer.append("    roleId = " + roleId + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}

}
