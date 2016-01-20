/**
 * 
 */
package org.iq.gen.builder;

/**
 * @author Sam
 *
 */
public class BuilderUtil {

	public static String getConstantName(String name) {
		return name.replace(" ", "_").replace("-", "_").toUpperCase();
	}
}