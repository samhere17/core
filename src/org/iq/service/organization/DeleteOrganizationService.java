package org.iq.service.organization;

import java.util.HashMap;

import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;

@Service(name="DeleteOrganization")
public class DeleteOrganizationService extends BaseService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5758415481436463236L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		LocalLogger.logMethodEnd();
	}
}