/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.messages;

import java.io.InputStream;
import java.util.Properties;

import org.iq.util.handlers.PropertiesHandler;

/**
 * @author Sam
 *
 */
public class Messages {

	private static final String MSG_DIR = "msg/";
	private static final String MSG_FILE_NAME = "messages.properties";

	private static Messages messages = null;
	private static Properties messageProps = null;

	/**
	 * 
	 */
	private Messages() {
		String msgResPath = MSG_DIR + MSG_FILE_NAME;
		InputStream msgInputStream = getClass().getClassLoader().getResourceAsStream(msgResPath);

		MessagesHandler messagesHandler = new MessagesHandler(msgInputStream);
		messagesHandler.getObject();

	}

	/**
	 * @return Messages
	 */
	public static Messages getInstance() {
		if (messages == null) {
			messages = new Messages();
		}
		return messages;
	}

	class MessagesHandler extends PropertiesHandler<Messages> {

		public MessagesHandler(InputStream propFileInput) {
			super(propFileInput);
		}

		@Override
		public void setLocalData() {
			messageProps = new Properties(properties);
		}

		@Override
		public void loadPropertiesError() {
			// TODO Auto-generated method stub

		}
	}

	/**
	 * @param key
	 * @return String
	 */
	public String getMessage(String key) {
		return messageProps.getProperty(key);
	}

	/**
	 * @param key
	 * @param objects
	 * @return String
	 */
	public String getMessage(String key, Object... objects) {
		return String.format(messageProps.getProperty(key), objects);
	}
}
