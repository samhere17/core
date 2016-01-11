package org.iq.ums.security.annex;

import java.util.Map;

import org.iq.ums.exception.UmsException;
import org.iq.ums.vo.UmsUser;

/**
 * <p>
 * This interface provides an option to add extra functionality to few areas in
 * the UMS. This is implemented by the {@link UmsAnnexSecurity} class, which can
 * in turn be extended by any user of the UMS.
 * </p>
 * 
 * @author Sam
 *
 */
interface UmsAnnexSecurityI {

	/**
	 * @param userName
	 * @param password
	 * @return UmsUser
	 * @throws UmsException
	 */
	public abstract UmsUser authenticate(String userName, char[] password) throws UmsException;

	/**
	 * @param userName
	 * @return String
	 */
	public abstract String createNativeToken(String userName);

	/**
	 * @param token
	 * @return boolean
	 */
	public abstract boolean isTokenValid(String token);

	/**
	 * <p>
	 * This method returns any additional details that may be needed to be
	 * pushed to the UMS system.
	 * </p>
	 * <p>
	 * The object returned is a Map of a Map, where the external map's key is a
	 * {@link String}.<br>
	 * This {@link String} is treated as the ADDITIONAL_ID of the UMS_USER
	 * table.
	 * </p>
	 * 
	 * @return Map<String, Map<String, Object>>
	 * @throws UmsException
	 */
	public abstract Map<String, Map<String, Object>> getAdditionalDetailsMap() throws UmsException;

}