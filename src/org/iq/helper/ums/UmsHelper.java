package org.iq.helper.ums;

import java.util.List;

import org.iq.db.dao.ums.UmsUserDao;
import org.iq.db.dao.ums.UmsUserDetailsDao;
import org.iq.db.dao.ums.impl.UmsUserDaoImpl;
import org.iq.db.dao.ums.impl.UmsUserDetailsDaoImpl;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.util.ums.UmsDbProvider;
import org.iq.valueobject.ums.UmsUser;
import org.iq.valueobject.ums.UmsUserDetails;

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

	public List<UmsUserDetails> getSearchedUsers(String additionalId, String userId,
			String username, String firstname, String lastname, String phone,
			String email, Integer roleId) throws BusinessException {
		UmsUserDetailsDao userDetailsDao = new UmsUserDetailsDaoImpl(dbSession);
		try {
			return userDetailsDao.search(additionalId, userId, username,
					firstname, lastname, phone, email, roleId);
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
			return new UmsUserDetailsDaoImpl(dbSession)
					.getUserDetailsByUserId(userId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}