package org.iq.config.handler;

import java.io.File;

import org.iq.util.handlers.XmlHandler;

/**
 * @author Sam
 * 
 * @param <T>
 */
public abstract class ConfigXmlHandler<T> extends XmlHandler<T> {

	/**
	 * @param confName
	 */
	/*public ConfigXmlHandler(String confName) {
		super(new File(SystemContext.getAppConfigHome() + File.separator
				+ confName + "." + BaseConfig.CONF_EXT));
	}*/

	/**
	 * @param confName
	 */
	protected ConfigXmlHandler(String confName, Object system) {
		super(new File(/*SystemContext.getSystemConfigHome() + */File.separator
				+ confName + ".conf"));
	}

}