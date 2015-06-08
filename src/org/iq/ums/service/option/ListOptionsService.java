package org.iq.ums.service.option;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsOptionHelper;
import org.iq.util.StringUtil;

@Service(name="ListOptions")
public class ListOptionsService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3824498676058527319L;

	private static final String ALL_OPTIONS = "all";
	private static final String PARENT_OPTIONS = "parent";
//	private static final String ACTIVE_OPTIONS = "active";

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();

		String listType = StringUtil.getStringValue(input.get(OptionKeys.LIST_TYPE_KEY));
		
		try {
			if (ALL_OPTIONS.equals(listType)) {
				resultAttributes.put(OptionKeys.OPTIONS_LIST_KEY,
						new UmsOptionHelper().getAllOptions());
			} else if (PARENT_OPTIONS.equals(listType)) {
				resultAttributes.put(OptionKeys.PARENT_OPTIONS_LIST_KEY,
						new UmsOptionHelper().getParentOptions());
			} else {
				resultAttributes.put(OptionKeys.OPTIONS_LIST_KEY,
						new UmsOptionHelper().getAllOptions());
			}

		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		LocalLogger.logMethodEnd();
	}
}