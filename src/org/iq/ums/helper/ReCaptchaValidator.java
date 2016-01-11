package org.iq.ums.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.iq.ums.exception.UmsException;
import org.iq.util.StringUtil;

public class ReCaptchaValidator {

	private static final String CHARACTER_ENCODING_UTF_8 = "UTF-8";
	private static final String END_OF_INPUT = "\\Z";

	private static final String VERIFY_URL = "http://api-verify.recaptcha.net/verify?";

	private String privateKey = null;

	//for testing from office
	private String proxyHost = "proxy.techm";
	private String proxyPort = "80";

	/**
	 * 
	 */
	public ReCaptchaValidator() {
		//for testing from office
		if (StringUtil.isEmpty(proxyHost) == false) {
			System.setProperty("http.proxyHost", proxyHost);
		}
		//for testing from office
		if (StringUtil.isEmpty(proxyPort) == false) {
			System.setProperty("http.proxyPort", proxyPort);
		}
	}

	/**
	 * @param privateKey
	 */
	public ReCaptchaValidator(String privateKey) {
		this();
		this.privateKey = privateKey;
	}

	/**
	 * @param reCaptchaRequest
	 * @return ReCaptchaResponse
	 * @throws UmsException
	 */
	public ReCaptchaResponse validateReCaptcha(ReCaptchaRequest reCaptchaRequest)
			throws UmsException {

		if (StringUtil.isEmpty(privateKey)) {
			throw new UmsException("reCaptcha private key is null or blank");
		}

		if (StringUtil.isEmpty(reCaptchaRequest.getUserRemoteAddress())) {
			throw new UmsException("Remote address is null or blank");
		}

		if (StringUtil.isEmpty(reCaptchaRequest.getCaptchaChallengeCode())) {
			throw new UmsException("reCaptcha challenge code is null or blank");
		}

		if (StringUtil.isEmpty(reCaptchaRequest.getCaptchaUserResponse())) {
			throw new UmsException("reCaptcha response is null or blank");
		}

		String postParameters = getPostParametersString(privateKey,
				reCaptchaRequest.getUserRemoteAddress(),
				reCaptchaRequest.getCaptchaChallengeCode(),
				reCaptchaRequest.getCaptchaUserResponse());
		if (StringUtil.isEmpty(postParameters)) {
			throw new UmsException("Error encoding post parameters");
		}

		String postUrl = VERIFY_URL + postParameters;

		String resultString = null;
		try {
			URL url = new URL(postUrl);
			URLConnection connection = null;
			connection = url.openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter(END_OF_INPUT);
			resultString = scanner.next();
			scanner.close();
		} catch (MalformedURLException e) {
			throw new UmsException(e);
		} catch (IOException e) {
			throw new UmsException(e);
		}

		if (resultString == null) {
			return new ReCaptchaResponse(false,
					"Null returned from reCaptcha server.");
		}

		String[] a = resultString.split("\r?\n");
		if (a.length < 1) {
			return new ReCaptchaResponse(false,
					"No answer returned from reCaptcha server: " + resultString);
		}
		
		boolean valid = "true".equals(a[0]);
		String errorMessage = null;
		if (!valid) {
			if (a.length > 1)
				errorMessage = a[1];
			else
				errorMessage = "recaptcha4j-missing-error-message";
		}

		return new ReCaptchaResponse(valid, errorMessage);
	}

	/**
	 * @param privateKey
	 * @param remoteAddr
	 * @param challenge
	 * @param response
	 * @return String
	 */
	private String getPostParametersString(String privateKey,
			String remoteAddr, String challenge, String response) {
		try {
			return "privatekey="
					+ URLEncoder.encode(privateKey, CHARACTER_ENCODING_UTF_8)
					+ "&remoteip="
					+ URLEncoder.encode(remoteAddr, CHARACTER_ENCODING_UTF_8)
					+ "&challenge="
					+ URLEncoder.encode(challenge, CHARACTER_ENCODING_UTF_8)
					+ "&response="
					+ URLEncoder.encode(response, CHARACTER_ENCODING_UTF_8);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * @param privateKey
	 *            the privateKey to set
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * @param proxyHost
	 *            the proxyHost to set
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * @param proxyPort
	 *            the proxyPort to set
	 */
	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}
}