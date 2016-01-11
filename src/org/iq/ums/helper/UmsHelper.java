package org.iq.ums.helper;

import java.util.Date;
import java.util.List;

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
import org.iq.ums.vo.UmsUser;
import org.iq.ums.vo.UmsUserDetails;
import org.iq.ums.vo.UmsUserRoleMap;
import org.iq.util.StringUtil;

public class UmsHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3725430657335455971L;

	public UmsHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

	public boolean isAdminUserConfigured() throws BusinessException {
		UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
		List<UmsUser> umsUserList = null;
		try {
			umsUserList = umsUserDao.getSystemUsers();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
		if (umsUserList != null && umsUserList.size() > 0) {
			return true;
		}
		return false;
	}

	public List<UmsUserDetails> getSearchedUsers(String additionalId, String userId, String username, String firstname,
			String lastname, String phone, String email, Integer roleId) throws BusinessException {
		UmsUserDetailsDao userDetailsDao = new UmsUserDetailsDaoImpl(dbSession);
		try {
			return userDetailsDao.search(additionalId, userId, username, firstname, lastname, phone, email, roleId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public UmsUser getUser(int userId) throws BusinessException {
		try {
			return new UmsUserDaoImpl(dbSession).getUserByUserId(userId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public UmsUserDetails getUserDetails(int userId) throws BusinessException {
		try {
			return new UmsUserDetailsDaoImpl(dbSession).getUserDetailsByUserId(userId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
	
	public UmsUser createUser(String firstname,String lastname, String alias, String address, String phone, String email,
			String altPhone, String altEmail, int gender, Date birthday, Date anniversary,
			String username, String password, String cpassword, String additionalId, int roleId,
			int userUpdatedBy) throws BusinessException {
		UmsUser umsUser = insertUser(username, cpassword, Integer.valueOf(UserType.APPLICATION_USER.getUerTypeValue()),
				Integer.valueOf(UserStatus.NEW.getUserStatusValue()), additionalId, userUpdatedBy);
		
		insertUserDetails(umsUser.getUserId(), firstname, lastname, alias,
				address, phone, email, altPhone, altEmail, gender, birthday, anniversary);
		
		insertUserRoleMapping(umsUser.getUserId(), roleId);
		
		return umsUser;

	}
	

	public UmsUser insertUser(String username, String password, Integer userType, Integer userStatus,
			String additionalId, Integer userUpdatedById) throws BusinessException {
		// preparing data before hitting UmsUser DAO layer
		UmsUser umsUser = new UmsUser();

		umsUser.setUserAccessKey(UmsKeyGenerator.getRandomKey());
		umsUser.setUsername(username);
		umsUser.setPassword(UmsPasswordEncryptor.encrypt(password));
		umsUser.setUserType(UserType.getUserType(userType));
		umsUser.setUserStatus(UserStatus.getUserStatus(userStatus));
		umsUser.setAdditionalId(additionalId);

		umsUser.setUserCreationTime(new Date());
		umsUser.setUserUpdatedTime(new Date());
		if (StringUtil.isEmpty(StringUtil.getStringValue(userUpdatedById))==false) {
			umsUser.setUserCreatedBy(userUpdatedById);
			umsUser.setUserUpdatedBy(userUpdatedById);
		}

		// hitting UmsUser DAO layer
		UmsUserDao umsUserDao = new UmsUserDaoImpl(dbSession);
		try {
			umsUser.setUserId(umsUserDao.insertAndGetUserId(umsUser));
		} catch (DbException e) {
			throw new BusinessException(e);
		}
		return umsUser;
	}

	public UmsUserDetails insertUserDetails(Integer userId, String firstName, String lastName, String alias,
			String address, String phone, String email, String altPhone, String altEmail, Integer gender, Date birthDay,
			Date anniversary) throws BusinessException {
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
		UmsUserDetailsDao umsUserDetailsDao = new UmsUserDetailsDaoImpl(dbSession);
		try {
			umsUserDetailsDao.insert(umsUserDetails);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
		return umsUserDetails;
	}

	public void insertUserRoleMapping(Integer userId, Integer roleId) throws BusinessException {
		// preparing data before hitting UmsUserRoleMap DAO layer
		UmsUserRoleMap umsUserRoleMap = new UmsUserRoleMap();
		umsUserRoleMap.setUserId(userId);
		umsUserRoleMap.setRoleId(roleId);

		// hitting UmsUserRoleMap DAO layer
		UmsUserRoleMapDao umsUserRoleMapDao = new UmsUserRoleMapDaoImpl(dbSession);
		try {
			umsUserRoleMapDao.insert(umsUserRoleMap);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public int delete(String userAccessKey) throws BusinessException {
		try {
			UmsUser umsUser = new UmsUser();
			umsUser.setUserAccessKey(userAccessKey);

			return new UmsUserDaoImpl(dbSession).softDelete(umsUser);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}