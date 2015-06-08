package org.iq.ums.service.option;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.ums.helper.UmsOptionHelper;
import org.iq.util.StringUtil;

@Service(name="InsertOption")
public class InsertOptionService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5909617370348150109L;

	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		String optionName = StringUtil.getStringValue(input.get(OptionKeys.OPTION_NAME_KEY));
		String optionDescription = StringUtil.getStringValue(input.get(OptionKeys.OPTION_DESCRIPTION_KEY));
		int optionTypeValue = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_TYPE_KEY)));
		int optionStatusValue = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_STATUS_KEY)));
		int optionOrder = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_ORDER_KEY)));
		boolean enableToolbox = Boolean.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_ENABLE_TOOLBOX_KEY)));
		String optionLink = StringUtil.getStringValue(input.get(OptionKeys.OPTION_LINK_KEY));
		String optionImageLink = StringUtil.getStringValue(input.get(OptionKeys.OPTION_IMAGE_LINK_KEY));
		String optionImageAlt = StringUtil.getStringValue(input.get(OptionKeys.OPTION_IMAGE_ALT_KEY));
		String objectReferenceKey = StringUtil.getStringValue(input.get(OptionKeys.OBJECT_REFERENCE_KEY));
		int parentOptionId = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_PARENT_ID_KEY)));
		
		int optionId = -9999;
		try {
			optionId = new UmsOptionHelper().createOption(optionName, optionDescription,
					optionTypeValue, optionStatusValue, optionOrder,
					enableToolbox, optionLink, optionImageLink,
					optionImageAlt, objectReferenceKey, parentOptionId);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}
		
		redirectUrl = "adapter?serviceName=GetOption&path=__sys/opt/details&optId="+optionId;
		LocalLogger.logMethodEnd();
	}
}