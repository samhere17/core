package org.iq.valueobject.ums;

import org.iq.UmsConstants.SessionStatus;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsSessionDetails extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083319797162777118L;

	private int userId;
	private String systemSessionId;
	private String nativeToken;
	private SessionStatus sessionStatus;

	

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
	 * @return the sessionStatus
	 */
	public SessionStatus getSessionStatus() {
		return sessionStatus;
	}

	/**
	 * @return the sessionStatus
	 */
	public String getSessionStatusString() {
		return sessionStatus.toString();
	}

	/**
	 * @param sessionStatus
	 *            the sessionStatus to set
	 */
	public void setSessionStatus(SessionStatus sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	/**
	 * @param sessionStatus
	 *            the sessionStatus value to set
	 */
	public void setSessionStatusValue(int sessionStatusValue) {
		this.sessionStatus = SessionStatus.getSessionStatus(sessionStatusValue);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsSessionDetails=[" + StringUtil.lineSeparator);
		buffer.append("    userId =" + userId + StringUtil.lineSeparator);
		buffer.append("    systemSessionId=" + systemSessionId + StringUtil.lineSeparator);
		buffer.append("    nativeToken=" + nativeToken + StringUtil.lineSeparator);
		buffer.append("    sessionStatus=" + sessionStatus.toString() + "(Value:" + sessionStatus.getSessionStatusValue() + ")" + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}