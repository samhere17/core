package org.iq.ums.util;

import java.util.UUID;

/**
 * @author Sam
 *
 */
public class UmsKeyGenerator {

	public static String getRandomKey() {
		return UUID.randomUUID().toString();
	}
}