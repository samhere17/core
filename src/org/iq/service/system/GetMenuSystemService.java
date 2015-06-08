package org.iq.service.system;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.Service;
import org.iq.ums.helper.UmsOptionHelper;

@Service(name="GetMenu")
public class GetMenuSystemService extends BaseSystemService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8750849460265627873L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();


		try {
			UmsOptionHelper umsOptionHelper = new UmsOptionHelper();
			resultAttributes.put(SystemKeys.MENU_OPTIONS_KEY, umsOptionHelper
					.getOptionsForMenu(umsSession.getRoleId() , input));
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}

}
