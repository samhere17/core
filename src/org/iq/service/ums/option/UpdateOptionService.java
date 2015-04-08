/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.service.ums.option;

import java.util.HashMap;

import org.iq.exception.BusinessException;
import org.iq.exception.ServiceException;
import org.iq.helper.ums.UmsOptionHelper;
import org.iq.logger.LocalLogger;
import org.iq.service.BaseService;
import org.iq.service.Service;
import org.iq.util.StringUtil;

/**
 * @author Sam
 * 
 */
@Service(name="UpdateOption")
public class UpdateOptionService extends BaseService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4938218481685588931L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.service.BaseService#execute(java.util.HashMap)
	 */
	@Override
	public void execute(HashMap<String, Object> input) throws ServiceException {
		LocalLogger.logMethodStart();
		
		int optionId = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_ID_KEY)));
		String optionName = StringUtil.getStringValue(input.get(OptionKeys.OPTION_NAME_KEY));
		String optionDescription = StringUtil.getStringValue(input.get(OptionKeys.OPTION_DESCRIPTION_KEY));
		int optionTypeValue = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_TYPE_KEY)));
		int optionStatusValue = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_STATUS_KEY)));
		String optionLink = StringUtil.getStringValue(input.get(OptionKeys.OPTION_LINK_KEY));
		String optionImageLink = StringUtil.getStringValue(input.get(OptionKeys.OPTION_IMAGE_LINK_KEY));
		String optionImageAlt = StringUtil.getStringValue(input.get(OptionKeys.OPTION_IMAGE_ALT_KEY));
		int optionOrder = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_ORDER_KEY)));
		int parentOptionId = Integer.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_PARENT_ID_KEY)));
		boolean enableToolbox = Boolean.valueOf(StringUtil.getStringValue(input.get(OptionKeys.OPTION_ENABLE_TOOLBOX_KEY)));
		String objectReferenceKey = StringUtil.getStringValue(input.get(OptionKeys.OBJECT_REFERENCE_KEY));

		try {
			new UmsOptionHelper().updateOption(optionId, optionName,
					optionDescription, optionTypeValue, optionStatusValue,
					optionLink, optionImageLink, optionImageAlt, optionOrder,
					parentOptionId, enableToolbox, objectReferenceKey);
		} catch (BusinessException e) {
			throw new ServiceException(e);
		}
		
		redirectUrl = "adapter?serviceName=GetOption&path=__sys/opt/details&optId="+optionId;

		LocalLogger.logMethodEnd();
	}
}