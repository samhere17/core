package org.iq.ums.vo;

import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;


/**
 * @author Sam
 */
public class UmsRegistrationResult extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6322625231259072193L;

	private boolean registrationSuccess = false;

	private UmsUserDetails umsUserDetails = null;
	private String successMessage = null;

	private String firstnameValidationError = null;
	private String lastnameValidationError = null;
	private String usernameValidationError = null;
	private String passwordValidationError = null;
	private String confirmPasswordValidationError = null;
	private String dateOfBirthValidationError = null;
	private String genderValidationError = null;
	private String emailValidationError = null;
	private String phoneValidationError = null;
	private String captchaValidationError = null;
	private String errorMessage = null;

	/**
	 * @return the registrationSuccess
	 */
	public boolean isRegistrationSuccess() {
		return registrationSuccess;
	}

	/**
	 * @param registrationSuccess
	 *            the registrationSuccess to set
	 */
	public void setRegistrationSuccess(boolean registrationSuccess) {
		this.registrationSuccess = registrationSuccess;
	}

	/**
	 * @return the umsUserDetails
	 */
	public UmsUserDetails getUmsUserDetails() {
		return umsUserDetails;
	}

	/**
	 * @param umsUserDetails
	 *            the umsUserDetails to set
	 */
	public void setUmsUserDetails(UmsUserDetails umsUserDetails) {
		this.umsUserDetails = umsUserDetails;
	}

	/**
	 * @return the successMessage
	 */
	public String getSuccessMessage() {
		return successMessage;
	}

	/**
	 * @param successMessage
	 *            the successMessage to set
	 */
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	/**
	 * @return the firstnameValidationError
	 */
	public String getFirstnameValidationError() {
		return firstnameValidationError;
	}

	/**
	 * @param firstnameValidationError
	 *            the firstnameValidationError to set
	 */
	public void setFirstnameValidationError(String firstnameValidationError) {
		this.firstnameValidationError = firstnameValidationError;
	}

	/**
	 * @return the lastnameValidationError
	 */
	public String getLastnameValidationError() {
		return lastnameValidationError;
	}

	/**
	 * @param lastnameValidationError
	 *            the lastnameValidationError to set
	 */
	public void setLastnameValidationError(String lastnameValidationError) {
		this.lastnameValidationError = lastnameValidationError;
	}

	/**
	 * @return the usernameValidationError
	 */
	public String getUsernameValidationError() {
		return usernameValidationError;
	}

	/**
	 * @param usernameValidationError
	 *            the usernameValidationError to set
	 */
	public void setUsernameValidationError(String usernameValidationError) {
		this.usernameValidationError = usernameValidationError;
	}

	/**
	 * @return the passwordValidationError
	 */
	public String getPasswordValidationError() {
		return passwordValidationError;
	}

	/**
	 * @param passwordValidationError
	 *            the passwordValidationError to set
	 */
	public void setPasswordValidationError(String passwordValidationError) {
		this.passwordValidationError = passwordValidationError;
	}

	/**
	 * @return the confirmPasswordValidationError
	 */
	public String getConfirmPasswordValidationError() {
		return confirmPasswordValidationError;
	}

	/**
	 * @param confirmPasswordValidationError
	 *            the confirmPasswordValidationError to set
	 */
	public void setConfirmPasswordValidationError(
			String confirmPasswordValidationError) {
		this.confirmPasswordValidationError = confirmPasswordValidationError;
	}

	/**
	 * @return the dateOfBirthValidationError
	 */
	public String getDateOfBirthValidationError() {
		return dateOfBirthValidationError;
	}

	/**
	 * @param dateOfBirthValidationError
	 *            the dateOfBirthValidationError to set
	 */
	public void setDateOfBirthValidationError(String dateOfBirthValidationError) {
		this.dateOfBirthValidationError = dateOfBirthValidationError;
	}

	/**
	 * @return the genderValidationError
	 */
	public String getGenderValidationError() {
		return genderValidationError;
	}

	/**
	 * @param genderValidationError
	 *            the genderValidationError to set
	 */
	public void setGenderValidationError(String genderValidationError) {
		this.genderValidationError = genderValidationError;
	}

	/**
	 * @return the emailValidationError
	 */
	public String getEmailValidationError() {
		return emailValidationError;
	}

	/**
	 * @param emailValidationError
	 *            the emailValidationError to set
	 */
	public void setEmailValidationError(String emailValidationError) {
		this.emailValidationError = emailValidationError;
	}

	

	/**
	 * @return the phoneValidationError
	 */
	public String getPhoneValidationError() {
		return phoneValidationError;
	}

	/**
	 * @param phoneValidationError the phoneValidationError to set
	 */
	public void setPhoneValidationError(String phoneValidationError) {
		this.phoneValidationError = phoneValidationError;
	}

	/**
	 * @return the captchaValidationError
	 */
	public String getCaptchaValidationError() {
		return captchaValidationError;
	}

	/**
	 * @param captchaValidationError
	 *            the captchaValidationError to set
	 */
	public void setCaptchaValidationError(String captchaValidationError) {
		this.captchaValidationError = captchaValidationError;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.user.valueobjects.BaseVO#toString()
	 */
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("UmsRegistrationResult = [");
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    registrationSuccess = ").append(registrationSuccess);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    umsUserDetails = ").append(umsUserDetails);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    successMessage = ").append(successMessage);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    firstnameValidationError = ").append(firstnameValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    lastnameValidationError = ").append(lastnameValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    usernameValidationError = ").append(usernameValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    passwordValidationError = ").append(passwordValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    confirmPasswordValidationError = ").append(confirmPasswordValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    dateOfBirthValidationError = ").append(dateOfBirthValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    genderValidationError = ").append(genderValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    emailValidationError = ").append(emailValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    phoneValidationError = ").append(phoneValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    captchaValidationError = ").append(captchaValidationError);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("    errorMessage = ").append(errorMessage);
		stringBuffer.append(StringUtil.lineSeparator);
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
}