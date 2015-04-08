/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.util.handlers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sam
 *
 * @param <T>
 */
public abstract class PropertiesHandler<T> implements BaseHandler<T> {
	
	private boolean loaded = false;
	protected T object = null;
	protected InputStream propFile = null;
	protected Properties properties = new Properties();

	/**
	 * 
	 */
	public PropertiesHandler(InputStream propFileInput) {
		this.propFile = propFileInput;
	}


	/* (non-Javadoc)
	 * @see org.iq.util.handlers.BaseHandler#getObject()
	 */
	final public T getObject() {
		if (!loaded) {
			loadProperties(this.propFile);
			loaded = true;
		}
		return object;
	}

	private void loadProperties(InputStream propFileInput) {
		try {
			properties.load(propFileInput);
			setLocalData();
		} catch (FileNotFoundException e) {
			loadPropertiesError();
			e.printStackTrace();
		} catch (IOException e) {
			loadPropertiesError();
			e.printStackTrace();
		}
	}

	public abstract void setLocalData();
	
	public abstract void loadPropertiesError();
}
