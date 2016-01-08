package org.iq.ums.service.option;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsOptionHelper;
import org.iq.util.StringUtil;

@Service(name="GetOption")
public class GetOptionService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8960406095885736507L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		int optionId = Integer.valueOf(StringUtil.getStringValue(input
				.get(OptionKeys.OPTION_ID_KEY)));

		try {
			resultAttributes.put(OptionKeys.OPTION_KEY,
					new UmsOptionHelper().getOption(optionId));
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "ums/opt/details.jsp";

		LocalLogger.logMethodEnd();
	}

}
