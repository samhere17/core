/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.valueobject;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Sam
 */
public abstract class BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4482026828500251952L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return toJson(true);
	}

	/**
	 * @return String
	 */
	public String toJson() {
		return toJson(false);
	}

	/**
	 * @return String
	 */
	public String toJson(boolean pretty) {
		Gson gson = new Gson();
		if (pretty) {
			gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		}
		return gson.toJson(this);
	}

	public static <T extends BaseVO> T fromJson(String jsonStr, Class<T> clazz) {
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, clazz);
	}
}