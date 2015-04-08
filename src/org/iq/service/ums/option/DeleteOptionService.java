package org.iq.service.ums.option;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsOptionHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;

@Service(name="DeleteOption")
public class DeleteOptionService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7127273438580661810L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int optionId = Integer.valueOf(StringUtil.getStringValue(input
				.get(OptionKeys.OPTION_ID_KEY)));

		try {
			new UmsOptionHelper().deleteOption(optionId);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "adapter?path=__sys/opt/list&serviceName=ListOptions";

		LocalLogger.logMethodEnd();
	}

}
