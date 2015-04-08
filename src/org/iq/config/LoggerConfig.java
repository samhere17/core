/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;

import org.iq.config.handler.ConfigXmlHandler;
import org.iq.logger.formatter.FormatterFactory;
import org.iq.logger.formatter.TextFormatter;
import org.iq.logger.handler.FileHandler;
import org.iq.logger.handler.HandlerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * @author Sam
 * 
 */
final public class LoggerConfig extends ConfigXmlHandler<LoggerConfig> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5442729366402339667L;

	private static final String DEFAULT_LOGGER_CONFIG_NAME = "logger";

	private static final String LOGGING_CONF_Q_NAME = "logger-conf";
	private static final String LOGGER_NAME_Q_NAME = "logger-name";
	private static final String LOGGER_CLASS_Q_NAME = "logger-class";
	private static final String HANDLER_Q_NAME = "handler";
	private static final String LOGGING_LEVEL_Q_NAME = "logging-level";
	private static final String HANDLER_CLASS_Q_NAME = "handler-class";
	private static final String HANDLER_ARGUMENTS_Q_NAME = "handler-arguments";
	private static final String ARGUMENT_Q_NAME = "argument";
	private static final String ARG_NAME_Q_NAME = "arg-name";
	private static final String ARG_VALUE_Q_NAME = "arg-value";
	private static final String FORMATTER_Q_NAME = "formatter";
	private static final String FORMATTER_CLASS_Q_NAME = "formatter-class";
	private static final String FORMATTER_PATTERN_Q_NAME = "formatter-pattern";

	private static final String DEFAULT_FORMATTER_CLASS_NAME = TextFormatter.class
			.getName();
	private static final String DEFAULT_FORMATTER_PATTERN = "%d %t %c %M %l - %m";

	private static final String DEFAULT_HANDLER_CLASS_NAME = FileHandler.class
			.getName();

	private static final String DEFAULT_LOG_FILE_LOCATION_ARG_KEY = "log.file.location";
	private static final String DEFAULT_LOG_FILE_PATTERN_ARG_KEY = "log.file.pattern";
	private static final String DEFAULT_LOG_FILE_APPEND_MODE_ARG_KEY = "log.file.append.mode";

	private static final String DEFAULT_LOG_FILE_LOCATION = /*SystemContext.getAppHome() + */File.separator + "logs";
	private static final String DEFAULT_LOG_FILE_PATTERN = "system-%g.log";
	private static final String DEFAULT_LOG_FILE_APPEND_MODE = "true";

	private String loggerName = null;
	private String loggerClassName = null;

	private Level logLevel = null;
	private Handler logHandler = null;
	private ArrayList<Handler> logHandlers = null;// new ArrayList<Handler>();
	private String handlerClassName = null;

	private Map<String, String> argumentsMap = null;
	private String argName = null;
	private String argValue = null;

	private Formatter formatter = null;
	private String formatterClassName = null;
	private String formatterPattern = null;


	/**
	 * 
	 */
	public LoggerConfig() {
		super(DEFAULT_LOGGER_CONFIG_NAME,true);
	}

	/**
	 * 
	 */
	/*public LoggerConfig(String loggerName) {
		super(loggerName);
	}*/

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.util.xml.XmlHandler#parseTemplateError(java.lang.Exception)
	 */
	@Override
	public void parseTemplateError(Exception e) {
		logLevel = Level.ALL;

		formatterClassName = DEFAULT_FORMATTER_CLASS_NAME;
		formatterPattern = DEFAULT_FORMATTER_PATTERN;
		formatter = FormatterFactory.getFormatter(formatterClassName,
				formatterPattern);

		handlerClassName = DEFAULT_HANDLER_CLASS_NAME;
		argumentsMap.put(DEFAULT_LOG_FILE_LOCATION_ARG_KEY,
				DEFAULT_LOG_FILE_LOCATION);
		argumentsMap.put(DEFAULT_LOG_FILE_PATTERN_ARG_KEY,
				DEFAULT_LOG_FILE_PATTERN);
		argumentsMap.put(DEFAULT_LOG_FILE_APPEND_MODE_ARG_KEY,
				DEFAULT_LOG_FILE_APPEND_MODE);

		logHandler = HandlerFactory.getHandler(handlerClassName, argumentsMap);
		logHandler.setLevel(logLevel);
		logHandler.setFormatter(formatter);

		logHandlers.add(logHandler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.util.xml.XmlHandler#startXmlDocument()
	 */
	@Override
	public void startXmlDocument() throws SAXException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.util.xml.XmlHandler#startXmlElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startXmlElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (LOGGING_CONF_Q_NAME.equals(qName)) {
			logHandlers = new ArrayList<Handler>();
		} else if (LOGGER_NAME_Q_NAME.equals(qName)) {

		} else if (LOGGER_CLASS_Q_NAME.equals(qName)) {

		} else if (HANDLER_Q_NAME.equals(qName)) {

		} else if (LOGGING_LEVEL_Q_NAME.equals(qName)) {

		} else if (HANDLER_CLASS_Q_NAME.equals(qName)) {

		} else if (HANDLER_ARGUMENTS_Q_NAME.equals(qName)) {
			argumentsMap = new HashMap<String, String>();
		} else if (ARGUMENT_Q_NAME.equals(qName)) {

		} else if (ARG_NAME_Q_NAME.equals(qName)) {
			argName = "";
		} else if (ARG_VALUE_Q_NAME.equals(qName)) {
			argValue = "";
		} else if (FORMATTER_Q_NAME.equals(qName)) {

		} else if (FORMATTER_CLASS_Q_NAME.equals(qName)) {
			formatterClassName = "";
		} else if (FORMATTER_PATTERN_Q_NAME.equals(qName)) {
			formatterPattern = "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.util.xml.XmlHandler#endXmlElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endXmlElement(String uri, String localName, String qName)
			throws SAXException {
		if (LOGGING_CONF_Q_NAME.equals(qName)) {

		} else if (LOGGER_NAME_Q_NAME.equals(qName)) {
			loggerName = xmlTextContent.toString();
		} else if (LOGGER_CLASS_Q_NAME.equals(qName)) {
			loggerClassName = xmlTextContent.toString();
		} else if (HANDLER_Q_NAME.equals(qName)) {
			logHandler = HandlerFactory.getHandler(handlerClassName,
					argumentsMap);

			logHandler.setLevel(logLevel);
			logHandler.setFormatter(formatter);

			logHandlers.add(logHandler);
		} else if (HANDLER_CLASS_Q_NAME.equals(qName)) {
			handlerClassName = xmlTextContent.toString();
		} else if (HANDLER_ARGUMENTS_Q_NAME.equals(qName)) {

		} else if (ARGUMENT_Q_NAME.equals(qName)) {
			argumentsMap.put(argName, argValue);
		} else if (ARG_NAME_Q_NAME.equals(qName)) {
			argName = xmlTextContent.toString();
		} else if (ARG_VALUE_Q_NAME.equals(qName)) {
			argValue = xmlTextContent.toString();
		} else if (LOGGING_LEVEL_Q_NAME.equals(qName)) {
			try {
				logLevel = Level.parse(xmlTextContent.toString());
			} catch (IllegalArgumentException e) {
				logLevel = Level.ALL;
			}
		} else if (FORMATTER_Q_NAME.equals(qName)) {
			formatter = FormatterFactory.getFormatter(formatterClassName,
					formatterPattern);
		} else if (FORMATTER_CLASS_Q_NAME.equals(qName)) {
			formatterClassName = xmlTextContent.toString();
		} else if (FORMATTER_PATTERN_Q_NAME.equals(qName)) {
			formatterPattern = xmlTextContent.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iq.util.xml.XmlHandler#endXmlDocument()
	 */
	@Override
	public void endXmlDocument() throws SAXException {

	}
	
	/**
	 * @return the loggerHome
	 */
	public static String getLoggerHome() {
		return /*SystemContext.getAppHome()+*/File.separator+"logs";
	}

	/**
	 * @return the logHandlers
	 */
	public ArrayList<Handler> getLogHandlers() {
		getObject();
		return logHandlers;
	}

	/**
	 * @return the loggerClassName
	 */
	public String getLoggerClassName() {
		getObject();
		return loggerClassName;
	}

	public String getLoggerName() {
		getObject();
		return loggerName ;
	}

}