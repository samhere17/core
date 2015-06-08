package org.iq.ums.helper;

import java.util.Date;

import org.apache.commons.validator.routines.EmailValidator;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.ums.UmsConstants.Gender;
import org.iq.ums.UmsConstants.UserStatus;
import org.iq.ums.UmsConstants.UserType;
import org.iq.ums.dao.UmsUserDao;
import org.iq.ums.dao.UmsUserDetailsDao;
import org.iq.ums.dao.UmsUserRoleMapDao;
import org.iq.ums.dao.impl.UmsUserDaoImpl;
import org.iq.ums.dao.impl.UmsUserDetailsDaoImpl;
import org.iq.ums.dao.impl.UmsUserRoleMapDaoImpl;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.util.UmsKeyGenerator;
import org.iq.ums.util.UmsPasswordEncryptor;
import org.iq.ums.vo.UmsRegistrationResult;
import org.iq.ums.vo.UmsUser;
import org.iq.ums.vo.UmsUserDetails;
import org.iq.ums.vo.UmsUserRoleMap;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
public class UmsRegistrationHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1097659036364398475L;
	private static final int USERNAME_MAX_LENGTH = 50;
	private static final int EMAIL_MAX_LENGTH = 100;

	/**
	 * @throws BusinessException 
	 * 
	 */
	public UmsRegistrationHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

	public UmsRegistrationResult register(String firstName, String lastName,
			String alias, String address, String phone, String email,
			String altPhone, String altEmail, Integer gender, Date birthDay,
			Date anniversary, String username, String password, String cpassword) {
		return register(true, firstName, lastName, alias, address, phone,
				email, altPhone, altEmail, gender, birthDay, anniversary,
				username, password, cpassword, new String("0"), new Integer(1),
				new Integer(0));
	}

	public UmsRegistrationResult register(String firstName, String lastName,
			String alias, String address, String phone, String email,
			String altPhone, String altEmail, Integer gender, Date birthDay,
			Date anniversary, String username, String password,
			String cpassword, String additionalId, Integer roleId,
			Integer userUpdatedById) {
		return register(false, firstName, lastName, alias, address, phone,
				email, altPhone, altEmail, gender, birthDay, anniversary,
				username, password, cpassword, additionalId, roleId,
				userUpdatedById);
	}

	private UmsRegistrationResult register(boolean systemRegistration,
			String firstName, String lastName, String alias, String address,
			String phone, String email, String altPhone, String altEmail,
			Integer gender, Date birthDay, Date anniversary, String username,
			String password, String cpassword, String additionalId,
			Integer roleId, Integer userUpdatedById) {

		// Validation of inputs
		UmsRegistrationResult umsRegistrationResult = validateInput(firstName,
				lastName, alias, address, phone, email, altPhone, altEmail,
				gender, birthDay, anniversary, username, password, cpassword,
				roleId);

		// if isRegistrationSuccess is true, it means no validation error
		// occurred
		if (umsRegistrationResult.isRegistrationSuccess()) {

			// preparing data before hitting UmsUser DAO layer
			UmsUser umsUser = new UmsUser();
			umsUser.setUserAccessKey(UmsKeyGenerator.getRandomKey());
			umsUser.setUsername(username);
			umsUser.setPassword(UmsPasswordEncryptor.encrypt(password));

			if (systemRegistration) {
				umsUser.setUserType(UserType.SYSTEM_USER);
				umsUser.setUserStatus(UserStatus.ACTIVE);
			} else {
				umsUser.setUserType(UserType.APPLICATION_USER);
				umsUser.setUserStatus(UserStatus.NEW);
			}

			umsUser.setAdditionalId(additionalId);
			umsUser.setUserUpdatedBy(userUpdatedById);

			umsUser.setUserCreationTime(new Date());
			umsUser.setUserUpdatedTime(new Date());

			int userId = -1;

			// hitting UmsUser DAO layer
			UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
			try {
				userId = umsUserDao.insertAndGetUserId(umsUser);
			} catch (DbException e) {
				umsRegistrationResult.setRegistrationSuccess(false);
				umsRegistrationResult
						.setErrorMessage("Error saving users credentials");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// preparing data before hitting UmsUserDetails DAO layer
			UmsUserDetails umsUserDetails = new UmsUserDetails();
			umsUserDetails.setUserId(userId);
			umsUserDetails.setUserFirstName(firstName);
			umsUserDetails.setUserLastName(lastName);
			umsUserDetails.setUserAlias(alias);
			umsUserDetails.setAddress(address);
			umsUserDetails.setPrimaryPhone(phone);
			umsUserDetails.setPrimaryEmail(email);
			umsUserDetails.setAlternatePhone(altPhone);
			umsUserDetails.setAlternateEmail(altEmail);
			umsUserDetails.setGender(Gender.getGender(Integer.valueOf(gender)));
			umsUserDetails.setDateOfBirth(birthDay);
			umsUserDetails.setAnniversary(anniversary);

			// hitting UmsUserDetails DAO layer
			UmsUserDetailsDao umsUserDetailsDao = new UmsUserDetailsDaoImpl(
					dbSession);
			try {
				umsUserDetailsDao.insert(umsUserDetails);
			} catch (DbException e) {
				umsRegistrationResult.setRegistrationSuccess(false);
				umsRegistrationResult
						.setErrorMessage("Error saving users details");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// preparing data before hitting UmsUserRoleMap DAO layer
			UmsUserRoleMap umsUserRoleMap = new UmsUserRoleMap();
			umsUserRoleMap.setUserId(userId);
			umsUserRoleMap.setRoleId(roleId);
			
			// hitting UmsUserRoleMap DAO layer
			UmsUserRoleMapDao umsUserRoleMapDao = new UmsUserRoleMapDaoImpl(
					dbSession);
			try {
				umsUserRoleMapDao.insert(umsUserRoleMap);
			} catch (DbException e) {
				umsRegistrationResult.setRegistrationSuccess(false);
				umsRegistrationResult
						.setErrorMessage("Error saving role mapping");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			// TODO email and mobile verification

			// putting success parameters
			umsRegistrationResult.setRegistrationSuccess(true);
			umsRegistrationResult
					.setSuccessMessage("Registration is succesful. Welcome "
							+ firstName);
			umsRegistrationResult.setUmsUserDetails(umsUserDetails);
		}
		return umsRegistrationResult;
	}

	private UmsRegistrationResult validateInput(String firstName,
			String lastName, String alias, String address, String phone,
			String email, String altPhone, String altEmail, Integer gender,
			Date birthDay, Date anniversary, String username, String password,
			String cpassword, Integer roleId) {

		UmsRegistrationResult umsRegistrationResult = new UmsRegistrationResult();
		umsRegistrationResult.setRegistrationSuccess(true);

		String validationMessage = validateFirstname(firstName);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult
					.setFirstnameValidationError(validationMessage);
		}

		validationMessage = validateLastname(lastName);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setLastnameValidationError(validationMessage);
		}

		validationMessage = validateUsername(username);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setUsernameValidationError(validationMessage);
		}

		validationMessage = validatePassword(password);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setPasswordValidationError(validationMessage);
		}

		validationMessage = validateConfirmPassword(password, cpassword);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult
					.setConfirmPasswordValidationError(validationMessage);
		}

		validationMessage = validateDateOfBirth(birthDay);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult
					.setDateOfBirthValidationError(validationMessage);
		}

		validationMessage = validateGender(gender);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setGenderValidationError(validationMessage);
		}

		validationMessage = validateEmail(email);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setEmailValidationError(validationMessage);
		}

		validationMessage = validatePhone(phone);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult.setPhoneValidationError(validationMessage);
		}

		validationMessage = validatePhone(altPhone);
		if (StringUtil.isEmpty(validationMessage) == false) {
			umsRegistrationResult.setRegistrationSuccess(false);
			umsRegistrationResult
					.setAlternatePhoneValidationError(validationMessage);
		}

		if (StringUtil.isEmpty(altEmail) == false) {
			validationMessage = validateEmail(altEmail);
			if (StringUtil.isEmpty(validationMessage) == false) {
				umsRegistrationResult.setRegistrationSuccess(false);
				umsRegistrationResult
						.setAlternateEmailValidationError(validationMessage);
			}
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

		if (StringUtil.isEmpty(username)) {
			validationMessage = "Username is null or blank";
		} else if (username.length() > USERNAME_MAX_LENGTH) {
			validationMessage = "Maximum " + USERNAME_MAX_LENGTH
					+ " characters allowed";
		} else if (isUsernameExists(username)) {
			// checking for existing user name
			// user already exists
			validationMessage = "Username not available";
		}

		return validationMessage;
	}

	private boolean isUsernameExists(String username) {
		UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
		boolean ret = false;
		try {
			ret = umsUserDao.getUserByUsername(username) != null;
		} catch (DbException e) {
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
		if (gender > Gender.OTHER.getGenderValue()) {
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

		if (StringUtil.isEmpty(email)) {
			validationMessage = "Email address is null or blank";
		} else if (email.length() > EMAIL_MAX_LENGTH) {
			validationMessage = "Maximum " + EMAIL_MAX_LENGTH
					+ " characters allowed";
		} else if (isEmailValid(email) == false) {
			validationMessage = "Not a valid email address";
		} else if (isEmailExists(email)) {
			// checking for existing email user details already exists
			validationMessage = "Email already exists, try forgot password instead";
		}

		return validationMessage;
	}

	private boolean isEmailValid(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

	private boolean isEmailExists(String email) {
		UmsUserDetailsDao umsUserDetailsDao = new UmsUserDetailsDaoImpl(
				dbSession);
		boolean ret = false;
		try {
			ret = umsUserDetailsDao.getUserDetailsByEmail(email) != null;
		} catch (DbException e) {
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
}