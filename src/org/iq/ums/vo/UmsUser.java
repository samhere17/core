package org.iq.ums.vo;

import java.util.Date;

import org.iq.ums.UmsConstants.UserStatus;
import org.iq.ums.UmsConstants.UserType;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsUser extends BaseVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -986492540343581311L;

	private int userId;
	private String userAccessKey;
	private String username;
	private String password;
	private String decryptedPassword;
	private UserType userType;
	private UserStatus userStatus;
	private String additionalId;
	private Date userCreationTime;
	private Date userUpdatedTime;
	private int userUpdatedBy;

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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userType
	 */
	public UserType getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus
	 *            the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the additionalId
	 */
	public String getAdditionalId() {
		return additionalId;
	}

	/**
	 * @param additionalId
	 *            the additionalId to set
	 */
	public void setAdditionalId(String additionalId) {
		this.additionalId = additionalId;
	}

	/**
	 * @return the userCreationTime
	 */
	public Date getUserCreationTime() {
		return userCreationTime;
	}

	/**
	 * @param userCreationTime
	 *            the userCreationTime to set
	 */
	public void setUserCreationTime(Date userCreationTime) {
		this.userCreationTime = userCreationTime;
	}

	/**
	 * @return the userUpdatedTime
	 */
	public Date getUserUpdatedTime() {
		return userUpdatedTime;
	}

	/**
	 * @param userUpdatedTime
	 *            the userUpdatedTime to set
	 */
	public void setUserUpdatedTime(Date userUpdatedTime) {
		this.userUpdatedTime = userUpdatedTime;
	}

	/**
	 * @return the userUpdatedBy
	 */
	public int getUserUpdatedBy() {
		return userUpdatedBy;
	}

	/**
	 * @param userUpdatedBy
	 *            the userUpdatedBy to set
	 */
	public void setUserUpdatedBy(int userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	/**
	 * @return the decryptedPassword
	 */
	public String getDecryptedPassword() {
		return decryptedPassword;
	}

	/**
	 * @param decryptedPassword the decryptedPassword to set
	 */
	public void setDecryptedPassword(String decryptedPassword) {
		this.decryptedPassword = decryptedPassword;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsUser = [" + StringUtil.lineSeparator);
		buffer.append("    userID = " + userId + StringUtil.lineSeparator);
		buffer.append("    userAccessKey = " + userAccessKey
				+ StringUtil.lineSeparator);
		buffer.append("    username = " + username + StringUtil.lineSeparator);
		buffer.append("    password = " + StringUtil.mask(password)
				+ StringUtil.lineSeparator);
		buffer.append("    userType = " + userType + "(Value:"
				+ userType.getUerTypeValue() + StringUtil.lineSeparator);
		buffer.append("    userStatus = " + userStatus + "(Value:"
				+ userStatus.getUserStatusValue() + StringUtil.lineSeparator);
		buffer.append("    additionalId =" + additionalId
				+ StringUtil.lineSeparator);
		buffer.append("    userCreationTime =" + userCreationTime
				+ StringUtil.lineSeparator);
		buffer.append("    userUpdatedTime =" + userUpdatedTime
				+ StringUtil.lineSeparator);
		buffer.append("    userUpdatedBy =" + userUpdatedBy
				+ StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}

}