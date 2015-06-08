package org.iq.ums.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.iq.util.StringUtil;

public class ReCaptchaResponse {

	private static final String UNKNOWN_ERR_MSG = new String(
			"Unknown error returned from reCaptcha server");
	private static Properties errMsgProperties = new Properties();

	static {
		InputStream localInputStream = ReCaptchaResponse.class
				.getResourceAsStream("reCaptcha-messages_en_US.properties");
		if (localInputStream != null) {
			try {
				errMsgProperties.load(localInputStream);
			} catch (IOException localIOException) {
				System.err
						.println("Could not read reCaptcha-messages_en_US.properties: "
								+ localIOException);
			}
		}
	}

	private boolean valid;
	private String reCaptchaErrMsg;
	private String userFriendlyErrMsg;

	/**
	 * @param valid
	 * @param errorMessage
	 */
	ReCaptchaResponse(boolean valid, String errorMessage) {
		this.valid = valid;
		if (StringUtil.isEmpty(errorMessage) == false) {
			this.reCaptchaErrMsg = errorMessage;
			this.userFriendlyErrMsg = errMsgProperties.getProperty(
					errorMessage, UNKNOWN_ERR_MSG);
		}
	}

	/**
	 * True if captcha is "passed".
	 * 
	 * @return boolean
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * The reCaptcha error message. invalid-site-public-key
	 * invalid-site-private-key invalid-request-cookie incorrect-captcha-sol
	 * verify-params-incorrect recaptcha-not-reachable
	 * 
	 * @return the reCaptchaErrMsg
	 */
	public String getReCaptchaErrMsg() {
		return reCaptchaErrMsg;
	}

	/**
	 * @return the userFriendlyErrMsg
	 */
	public String getUserFriendlyErrMsg() {
		return userFriendlyErrMsg;
	}
}
