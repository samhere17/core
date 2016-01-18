package org.iq.ums.helper;

import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;
import org.iq.config.UmsConfig;
import org.iq.exception.BusinessException;
import org.iq.exception.ConfigException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.ums.UmsConstants.Gender;
import org.iq.ums.UmsConstants.UserStatus;
import org.iq.ums.UmsConstants.UserType;
import org.iq.ums.dao.UmsUserDao;
import org.iq.ums.dao.UmsUserDetailsDao;
import org.iq.ums.dao.impl.UmsUserDaoImpl;
import org.iq.ums.dao.impl.UmsUserDetailsDaoImpl;
import org.iq.ums.exception.UmsException;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.vo.UmsRegistrationResult;
import org.iq.ums.vo.UmsUser;
import org.iq.ums.vo.UmsUserDetails;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public class UmsRegistrationHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long	serialVersionUID		= -1097659036364398475L;

	private static final String	RECAPTCHA_PRIVATE_KEY	= "6LdqJ_oSAAAAAJlARbVfq4JxgZPvbHNROFxiM7Ui";
	public static final String	RECAPTCHA_PUBLIC_KEY	= "6LdqJ_oSAAAAAAFxkVuPZAOOmSQ6kqo5zsIeV5FN";

	private static final int	USERNAME_MAX_LENGTH		= 50;
	private static final int	EMAIL_MAX_LENGTH		= 100;

	/**
	 * @throws BusinessException
	 * 
	 */
	public UmsRegistrationHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

	public UmsRegistrationResult register(String firstname, String lastname, String username, String password,
			String cpassword, Date birthday, int gender, String email, String mobile, String remoteAddr,
			String captchaChallenge, String captchaResponse) throws BusinessException {

		// Validation of inputs
		UmsRegistrationResult umsRegistrationResult = validateInput(firstname, lastname, username, password, cpassword,
				birthday, gender, email, mobile, RECAPTCHA_PRIVATE_KEY, remoteAddr, captchaChallenge, captchaResponse);

		// if isRegistrationSuccess is true, it means no validation error
		// occurred
		if(umsRegistrationResult.isRegistrationSuccess()) {
			UmsHelper umsHelper = new UmsHelper();

			UmsUser umsUser = umsHelper.insertUser(username, cpassword, UserType.APPLICATION_USER.getUerTypeValue(),
					UserStatus.NEW.getUserStatusValue(), null, null);

			UmsUserDetails umsUserDetails = umsHelper.insertUserDetails(umsUser.getUserId(), firstname, lastname, null,
					null, mobile, email, null, null, gender, birthday, null);

			// TODO email and mobile verification

			// putting success parameters
			umsRegistrationResult.setRegistrationSuccess(true);
			umsRegistrationResult.setSuccessMessage("Registration is succesful. Welcome " + firstname);
			umsRegistrationResult.setUmsUserDetails(umsUserDetails);

			try {
				UmsConfig umsConfig = new UmsConfig();

				int roleId = umsConfig.getNewlyRegisteredDefaultRole();

				if(roleId != 0) {
					umsHelper.insertUserRoleMapping(umsUser.getUserId(), roleId);
				}
			} catch(ConfigException e) {
				throw new BusinessException(e);
			}

		}

		return umsRegistrationResult;

	}

	private UmsRegistrationResult validateInput(String firstname, String lastname, String username, String password,
			String cpassword, Date birthday, int gender, String email, String mobile, String reCaptchaPrivateKey,
			String remoteAddr, String captchaChallenge, String captchaResponse) {

		UmsRegistrationResult umsRegistrationResult = new UmsRegistrationResult();
		umsRegistrationResult.setRegistrationSuccess(true);

		String validationMessage = validateFirstname(firstname);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setFirstnameValidationError(validationMessage);
		}

		validationMessage = validateLastname(lastname);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setLastnameValidationError(validationMessage);
		}

		validationMessage = validateUsername(username);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setUsernameValidationError(validationMessage);
		}

		validationMessage = validatePassword(password);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setPasswordValidationError(validationMessage);
		}

		validationMessage = validateConfirmPassword(password, cpassword);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setConfirmPasswordValidationError(validationMessage);
		}

		validationMessage = validateDateOfBirth(birthday);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setDateOfBirthValidationError(validationMessage);
		}

		validationMessage = validateGender(gender);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setGenderValidationError(validationMessage);
		}

		validationMessage = validateEmail(email);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setEmailValidationError(validationMessage);
		}

		validationMessage = validatePhone(mobile);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setPhoneValidationError(validationMessage);
		}

		validationMessage = validateCaptcha(reCaptchaPrivateKey, remoteAddr, captchaChallenge, captchaResponse);
		if(StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setCaptchaValidationError(validationMessage);
		}

		return umsRegistrationResult;
	}

	/**
	 * @param firstName
	 * @return String
	 */
	private String validateFirstname(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param lastName
	 * @return String
	 */
	private String validateLastname(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param username
	 * @return String
	 */
	private String validateUsername(String username) {
		String validationMessage = "";

		if(StringUtil.isEmpty(username)) {
			validationMessage = "Username is null or blank";
		} else if(username.length() > USERNAME_MAX_LENGTH) {
			validationMessage = "Maximum " + USERNAME_MAX_LENGTH + " characters allowed";
		} else if(isUsernameExists(username)) {
			// checking for existing user name user already exists
			validationMessage = "Username not available";
		}

		return validationMessage;
	}

	private boolean isUsernameExists(String username) {
		UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
		boolean ret = false;
		try {
			ret = umsUserDao.getUserByUsername(username) != null;
		} catch(DbException e) {
			// swallow
		}
		return ret;
	}

	/**
	 * @param password
	 * @return String
	 */
	private String validatePassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param cpassword
	 * @param cpassword2
	 * @return String
	 */
	private String validateConfirmPassword(String password, String cpassword) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param dateOfBirth
	 * @return String
	 */
	private String validateDateOfBirth(Date dateOfBirth) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param gender
	 * @return String
	 */
	private String validateGender(int gender) {
		String validationMessage = "";
		if(gender > Gender.OTHER.getGenderValue()) {
			validationMessage = "Not a valid gender";
		}

		return validationMessage;
	}

	/**
	 * @param email
	 * @return String
	 */
	private String validateEmail(String email) {
		String validationMessage = "";

		if(StringUtil.isEmpty(email)) {
			validationMessage = "Email address is null or blank";
		} else if(email.length() > EMAIL_MAX_LENGTH) {
			validationMessage = "Maximum " + EMAIL_MAX_LENGTH + " characters allowed";
		} else if(isEmailValid(email) == false) {
			validationMessage = "Not a valid email address";
		} else if(isEmailExists(email)) {
			// checking for existing email user details already exists
			validationMessage = "Email already exists, try forgot password instead";
		}

		return validationMessage;
	}

	private boolean isEmailValid(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	private boolean isEmailExists(String email) {
		UmsUserDetailsDao umsUserDetailsDao = new UmsUserDetailsDaoImpl(dbSession);
		boolean ret = false;
		try {
			ret = umsUserDetailsDao.getUserDetailsByEmail(email) != null;
		} catch(DbException e) {
			// swallow
		}
		return ret;
	}

	/**
	 * @param mobile
	 * @return String
	 */
	private String validatePhone(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param reCaptchaPrivateKey
	 * @param remoteAddr
	 * @param captchaChallenge
	 * @param captchaResponse
	 * @return String
	 */
	private String validateCaptcha(String reCaptchaPrivateKey, String remoteAddr, String captchaChallenge,
			String captchaResponse) {

		String validationMessage = "";

		if(StringUtil.isEmpty(reCaptchaPrivateKey) || StringUtil.isEmpty(remoteAddr)
				|| StringUtil.isEmpty(captchaChallenge) || StringUtil.isEmpty(captchaResponse)) {
			validationMessage = "Insufficient captcha input";
		}

		// if validationMessage is still null, it means that inputs are correct
		if(StringUtil.isEmpty(validationMessage)) {
			ReCaptchaValidator reCaptchaValidator = new ReCaptchaValidator(reCaptchaPrivateKey);
			ReCaptchaResponse reCaptchaResponse = null;
			ReCaptchaRequest reCaptchaRequest = new ReCaptchaRequest(remoteAddr, captchaChallenge, captchaResponse);
			try {
				reCaptchaResponse = reCaptchaValidator.validateReCaptcha(reCaptchaRequest);
				if(reCaptchaResponse != null && reCaptchaResponse.isValid() == false) {
					validationMessage = reCaptchaResponse.getUserFriendlyErrMsg();
				}
			} catch(UmsException e) {
				validationMessage = e.getMessage();
			}
		}
		return validationMessage;
	}
}
