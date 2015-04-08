package org.iq.valueobject.ums;

import java.util.Date;

import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsLoginDetails extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9083319797162777118L;

	private int userId;
	private String systemSessionId;
	private String nativeToken;
	private Date loginTime;
	private String accessIP;
	private String accessPort;
	private String accessGateway;
	private String actualAccessIP;
	private String deviceType;
	private String operatingSystem;
	private String operatingSystemManufacturer;
	private String browserName;
	private String browserVersion;
	private String browserManufacturer;
	private String browserType;
	private String browserRenderingEngine;

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
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime
	 *            the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the accessIP
	 */
	public String getAccessIP() {
		return accessIP;
	}

	/**
	 * @param accessIP
	 *            the accessIP to set
	 */
	public void setAccessIP(String accessIP) {
		this.accessIP = accessIP;
	}

	/**
	 * @return the accessPort
	 */
	public String getAccessPort() {
		return accessPort;
	}

	/**
	 * @param accessPort
	 *            the accessPort to set
	 */
	public void setAccessPort(String accessPort) {
		this.accessPort = accessPort;
	}

	/**
	 * @return the accessGateway
	 */
	public String getAccessGateway() {
		return accessGateway;
	}

	/**
	 * @param accessGateway
	 *            the accessGateway to set
	 */
	public void setAccessGateway(String accessGateway) {
		this.accessGateway = accessGateway;
	}

	/**
	 * @return the actualAccessIP
	 */
	public String getActualAccessIP() {
		return actualAccessIP;
	}

	/**
	 * @param actualAccessIP
	 *            the actualAccessIP to set
	 */
	public void setActualAccessIP(String actualAccessIP) {
		this.actualAccessIP = actualAccessIP;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType
	 *            the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem
	 *            the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the operatingSystemManufacturer
	 */
	public String getOperatingSystemManufacturer() {
		return operatingSystemManufacturer;
	}

	/**
	 * @param operatingSystemManufacturer
	 *            the operatingSystemManufacturer to set
	 */
	public void setOperatingSystemManufacturer(
			String operatingSystemManufacturer) {
		this.operatingSystemManufacturer = operatingSystemManufacturer;
	}

	/**
	 * @return the browserName
	 */
	public String getBrowserName() {
		return browserName;
	}

	/**
	 * @param browserName
	 *            the browserName to set
	 */
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	/**
	 * @return the browserVersion
	 */
	public String getBrowserVersion() {
		return browserVersion;
	}

	/**
	 * @param browserVersion
	 *            the browserVersion to set
	 */
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	/**
	 * @return the browserManufacturer
	 */
	public String getBrowserManufacturer() {
		return browserManufacturer;
	}

	/**
	 * @param browserManufacturer
	 *            the browserManufacturer to set
	 */
	public void setBrowserManufacturer(String browserManufacturer) {
		this.browserManufacturer = browserManufacturer;
	}

	/**
	 * @return the browserType
	 */
	public String getBrowserType() {
		return browserType;
	}

	/**
	 * @param browserType
	 *            the browserType to set
	 */
	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	/**
	 * @return the browserRenderingEngine
	 */
	public String getBrowserRenderingEngine() {
		return browserRenderingEngine;
	}

	/**
	 * @param browserRenderingEngine
	 *            the browserRenderingEngine to set
	 */
	public void setBrowserRenderingEngine(String browserRenderingEngine) {
		this.browserRenderingEngine = browserRenderingEngine;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsLoginDetails=[" + StringUtil.lineSeparator);
		buffer.append("    userId=" + userId + StringUtil.lineSeparator);
		buffer.append("    systemSessionId=" + systemSessionId + StringUtil.lineSeparator);
		buffer.append("    nativeToken=" + nativeToken + StringUtil.lineSeparator);
		buffer.append("    loginTime=" + loginTime + StringUtil.lineSeparator);
		buffer.append("    accessIP=" + accessIP + StringUtil.lineSeparator);
		buffer.append("    accessPort=" + accessPort + StringUtil.lineSeparator);
		buffer.append("    accessGateway=" + accessGateway + StringUtil.lineSeparator);
		buffer.append("    actualAccessIP=" + actualAccessIP + StringUtil.lineSeparator);
		buffer.append("    deviceType=" + deviceType + StringUtil.lineSeparator);
		buffer.append("    operatingSystem=" + operatingSystem + StringUtil.lineSeparator);
		buffer.append("    operatingSystemManufacturer=" + operatingSystemManufacturer + StringUtil.lineSeparator);
		buffer.append("    browserName=" + browserName + StringUtil.lineSeparator);
		buffer.append("    browserVersion=" + browserVersion + StringUtil.lineSeparator);
		buffer.append("    browserManufacturer=" + browserManufacturer + StringUtil.lineSeparator);
		buffer.append("    browserType=" + browserType + StringUtil.lineSeparator);
		buffer.append("    browserRenderingEngine=" + browserRenderingEngine + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}