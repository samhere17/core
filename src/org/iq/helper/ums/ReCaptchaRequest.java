package org.iq.helper.ums;

public class ReCaptchaRequest {

	private String userRemoteAddress;
	private String captchaChallengeCode;
	private String captchaUserResponse;
	
	public ReCaptchaRequest(String userRemoteAddress,
			String captchaChallengeCode, String captchaUserResponse) {
		this.userRemoteAddress = userRemoteAddress;
		this.captchaChallengeCode = captchaChallengeCode;
		this.captchaUserResponse = captchaUserResponse;
	}

	/**
	 * @return the userRemoteAddress
	 */
	public String getUserRemoteAddress() {
		return userRemoteAddress;
	}

	/**
	 * @param userRemoteAddress
	 *            the userRemoteAddress to set
	 */
	public void setUserRemoteAddress(String userRemoteAddress) {
		this.userRemoteAddress = userRemoteAddress;
	}

	/**
	 * @return the captchaChallengeCode
	 */
	public String getCaptchaChallengeCode() {
		return captchaChallengeCode;
	}

	/**
	 * @param captchaChallengeCode
	 *            the captchaChallengeCode to set
	 */
	public void setCaptchaChallengeCode(String captchaChallengeCode) {
		this.captchaChallengeCode = captchaChallengeCode;
	}

	/**
	 * @return the captchaUserResponse
	 */
	public String getCaptchaUserResponse() {
		return captchaUserResponse;
	}

	/**
	 * @param captchaUserResponse
	 *            the captchaUserResponse to set
	 */
	public void setCaptchaUserResponse(String captchaUserResponse) {
		this.captchaUserResponse = captchaUserResponse;
	}
}