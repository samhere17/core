package org.iq.ums.security;

import org.iq.db.dao.ums.UmsUserDao;
import org.iq.db.dao.ums.impl.UmsUserDaoImpl;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.util.ums.UmsDbProvider;
import org.iq.util.ums.UmsPasswordEncryptor;
import org.iq.valueobject.ums.UmsUser;

public class UmsSecurityCallback extends UmsSecurity {

	@Override
	public UmsUser authenticate(String userName, char[] password) {
		UmsUser user = null;
		try {
			UmsUserDao userDao = new UmsUserDaoImpl(UmsDbProvider.getDbSession());
			user = userDao.getUserByUsername(userName);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user != null) {
			String decryptedPassword = UmsPasswordEncryptor.decrypt(user.getPassword());
			boolean authenticateUser = decryptedPassword.equals(new String(password));
			if (authenticateUser) {
				return user;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public String createNativeToken(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValid(String token) {
		// TODO Auto-generated method stub
		return false;
	}
}