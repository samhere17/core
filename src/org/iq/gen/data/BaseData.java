/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.gen.data;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.iq.gen.GeneratorUtil;

/**
 * @author Sam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseData implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4482026828500251952L;

	private String id = UUID.randomUUID().toString();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try {
			return GeneratorUtil.getJson(this);
		} catch (IOException e) {
			return "Could not generate String";
		}
	}
}
