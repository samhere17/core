package org.iq.validation;

import org.iq.exception.ValidationException;
import org.iq.util.StringUtil;
import org.iq.validation.ValidationConstants.MessageLevel;

public class Validator {

	public static RenderingMessage isRequired(String objName, Object object) {
		if (StringUtil.isEmpty(StringUtil.getStringValue(object))) {
			return new RenderingMessage(objName + " is null or blank",
					MessageLevel.ERROR);
		}
		return null;
	}

	public static void isMaxLength(Object object, int maxLength)
			throws ValidationException {
		if (StringUtil.getStringValue(object).length() > maxLength) {
			throw new ValidationException("Maximum " + maxLength
					+ " characters allowed");
		}
	}

	public static void isMinLength(Object object, int minLength)
			throws ValidationException {
		if (StringUtil.getStringValue(object).length() < minLength) {
			throw new ValidationException("Manimum " + minLength
					+ " characters required");
		}
	}

}
