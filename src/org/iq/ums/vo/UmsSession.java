package org.iq.ums.vo;

import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

/**
 * @author Sam
 */
public class UmsSession extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3397149819284537051L;
	
	private int userId;
	private String userAccessKey;
	private String username;
	private String additionalId;
	private int roleId;
	private boolean sessionValid;
	private String systemSessionId;
	private String nativeToken;
	private UmsUserDetails userDetails;
	private UmsLoginDetails lastLoginDetails;
	private String invalidMessage;

	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the additionalId
	 */
	public String getAdditionalId() {
		return additionalId;
	}

	/**
	 * @param additionalId the additionalId to set
	 */
	public void setAdditionalId(String additionalId) {
		this.additionalId = additionalId;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the sessionValid
	 */
	public boolean isSessionValid() {
		return sessionValid;
	}

	/**
	 * @param sessionValid
	 *            the sessionValid to set
	 */
	public void setSessionValid(boolean sessionValid) {
		this.sessionValid = sessionValid;
	}

	/**
	 * @return the systemSessionId
	 */
	public String getSystemSessionId() {
		return systemSessionId;
	}

	/**
	 * @param systemSessionId
	 *            the systemSessionId to set
	 */
	public void setSystemSessionId(String systemSessionId) {
		this.systemSessionId = systemSessionId;
	}

	/**
	 * @return the userAccessKey
	 */
	public String getUserAccessKey() {
		return userAccessKey;
	}

	/**
	 * @param userAccessKey
	 *            the userAccessKey to set
	 */
	public void setUserAccessKey(String userAccessKey) {
		this.userAccessKey = userAccessKey;
	}

	/**
	 * @return the nativeToken
	 */
	public String getNativeToken() {
		return nativeToken;
	}

	/**
	 * @param nativeToken
	 *            the nativeToken to set
	 */
	public void setNativeToken(String nativeToken) {
		this.nativeToken = nativeToken;
	}

	/**
	 * @return the invalidMessage
	 */
	public String getInvalidMessage() {
		return invalidMessage;
	}

	/**
	 * @param invalidMessage
	 *            the invalidMessage to set
	 */
	public void setInvalidMessage(String invalidMessage) {
		this.invalidMessage = invalidMessage;
	}

	/**
	 * @return the userDetails
	 */
	public UmsUserDetails getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails the userDetails to set
	 */
	public void setUserDetails(UmsUserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the lastLoginDetails
	 */
	public UmsLoginDetails getLastLoginDetails() {
		return lastLoginDetails;
	}

	/**
	 * @param lastLoginDetails the lastLoginDetails to set
	 */
	public void setLastLoginDetails(UmsLoginDetails lastLoginDetails) {
		this.lastLoginDetails = lastLoginDetails;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.user.valueobjects.BaseVO#toString()
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsSession = [");
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    userId = ").append(userId);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    userAccessKey = ").append(userAccessKey);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    username = ").append(username);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    additionalId = ").append(additionalId);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    roleId = ").append(roleId);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    sessionValid = ").append(sessionValid);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    systemSessionId = ").append(systemSessionId);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    nativeToken = ").append(nativeToken);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    invalidMessage = ").append(invalidMessage);
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    userDetails = ").append(userDetails != null ? userDetails.toString() : "null");
		buffer.append(StringUtil.lineSeparator);
		buffer.append("    lastLoginDetails = ").append(lastLoginDetails != null ? lastLoginDetails.toString() : "null");
		buffer.append(StringUtil.lineSeparator);
		buffer.append("]");
		return buffer.toString();
	}

}