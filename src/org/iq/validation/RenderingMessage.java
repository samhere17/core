package org.iq.validation;

import org.iq.util.StringUtil;
import org.iq.validation.ValidationConstants.MessageLevel;
import org.iq.valueobject.BaseVO;

public class RenderingMessage extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4984065878954453158L;
	
	private String message;
	private String level;
	
	public RenderingMessage(String message, MessageLevel level) {
		this.message = message;
		this.level = level.getMessageLevelString();
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("RenderingMessage = [" + StringUtil.lineSeparator);
		buffer.append("    level = " + level + StringUtil.lineSeparator);
		buffer.append("    message = " + message + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}
