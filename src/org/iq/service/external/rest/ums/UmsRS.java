package org.iq.service.external.rest.ums;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.iq.exception.BusinessException;
import org.iq.helper.ums.UmsAuthenticationHelper;
import org.iq.helper.ums.UmsHelper;
import org.iq.valueobject.ums.UmsSession;

/**
 * @author Sam
 * 
 */
@Path("/ums")
public class UmsRS {
	
	/**
	 * @return boolean
	 * @throws BusinessException
	 */
	@GET
	@Path("/isAdminUserConfigured")
	public boolean isAdminUserConfigured() throws BusinessException {
		return new UmsHelper().isAdminUserConfigured();
	}

	/**
	 * @param username
	 * @param password
	 * @return UmsSession
	 * @throws BusinessException
	 */
	@POST
	@Path("/login")
	public UmsSession login(String username, String password,
			String jSessionId, String accessIp, String accessPort,
			String accessGateway, String actualAccessIP, String userAgentString)
			throws BusinessException {
		return new UmsAuthenticationHelper().authenticate(username, password,
				jSessionId, accessIp, accessPort, accessGateway,
				actualAccessIP, userAgentString);
	}
}
