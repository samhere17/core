package org.iq.ums.service.option;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsOptionHelper;

@Service(name = "ReorderOptions")
public class ReorderOptionsService extends BaseService {

	/**
	 *
	 */
	private static final long serialVersionUID = -2297818428271491928L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		Map<Integer, Integer> optionsMap = new HashMap<>();

		/* Set of all the keys in the inputMap */
		Set<String> paramKeys = input.keySet();

		for (String paramKey : paramKeys) {
			if (paramKey.startsWith(OptionKeys.OPTION_ID_KEY + "-")) {
				optionsMap.put(Integer.valueOf(paramKey.substring(paramKey.indexOf("-") + 1)),
						Integer.valueOf((String) input.get(paramKey)));
			}
		}

		/* Set of all the keys in the optionsMap */
		Set<Integer> optionIds = optionsMap.keySet();

		UmsOptionHelper optionHelper;

		try {
			optionHelper = new UmsOptionHelper();

			for (int oprionId : optionIds) {
				optionHelper.updateOptionOrder(oprionId, optionsMap.get(oprionId));
			}
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}

		redirectUrl = "adapter?path=ums/opt/list&serviceName=ListOptions";
	}
}