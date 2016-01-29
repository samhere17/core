package org.iq.ums.security.annex;

import java.util.Map;

import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.exception.RenderableException;
import org.iq.ums.dao.UmsUserDao;
import org.iq.ums.dao.impl.UmsUserDaoImpl;
import org.iq.ums.exception.UmsException;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.util.UmsPasswordEncryptor;
import org.iq.ums.vo.UmsUser;

/**
 * <p>
 * This class is an implementation of the {@link UmsAnnexSecurityI}.
 * </p>
 * <p>
 * This class contains the default implementation of extra functionality in the
 * UMS.
 * </p>
 * <p>
 * Any third party user of UMS may wish to extend this {@link UmsAnnexSecurity}
 * class.
 * </p>
 * 
 * @author Sam
 *
 */
public class UmsAnnexSecurity implements UmsAnnexSecurityI {

	@Override
	public UmsUser authenticate(String userName, char[] password) throws UmsException, RenderableException {
		UmsUser user = null;
		try {
			UmsUserDao userDao = new UmsUserDaoImpl(UmsDbProvider.getDbSession());
			user = userDao.getUserByUsername(userName);
		} catch (BusinessException e) {
			throw new UmsException(e);
		} catch (DbException e) {
			throw new UmsException(e);
		}

		if (user != null) {
			String decryptedPassword = UmsPasswordEncryptor.decrypt(user.getPassword());
			boolean authenticateUser = decryptedPassword.equals(new String(password));
			if (authenticateUser) {
				return user;
			} else {
				throw new RenderableException("Password was wrong");
			}
		}

		throw new RenderableException("Username did not match any registered user");
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

	@Override
	public Map<String, Map<String, Object>> getAdditionalDetailsMap() throws UmsException {
		// TODO Auto-generated method stub
		return null;
	}

}