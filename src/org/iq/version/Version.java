/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sam
 */
public class Version {
	public static final String coreVersionNumber;
	public static final String coreDevVersionNumber;
	public static final String versionNumber;
	public static final String devVersionNumber;

	private static String coreMajorVersion = "0";
	private static String coreMinorVersion = "0";
	private static String corePatchVersion = "0";
	private static String coreHotfixVersion = "0";
	private static String coreBuildNumber = "0";

	private static String majorVersion = "0";
	private static String minorVersion = "0";
	private static String patchVersion = "0";
	private static String hotfixVersion = "0";
	private static String buildNumber = "0";

	static {
		Properties localProperties = new Properties();
		InputStream localInputStream = Version.class
				.getResourceAsStream("version.properties");
		if (localInputStream != null) {
			try {
				localProperties.load(localInputStream);
				majorVersion = localProperties.getProperty("version.major", "");
				minorVersion = localProperties.getProperty("version.minor", "");
				patchVersion = localProperties.getProperty("version.patch", "");
				hotfixVersion = localProperties.getProperty("version.hotfix",
						"");
				buildNumber = localProperties.getProperty(
						"version.build.number", "");
			} catch (IOException localIOException) {
				System.err.println("Could not read version.properties: "
						+ localIOException);
			}
		}
		versionNumber = majorVersion + "." + minorVersion + "." + patchVersion
				+ "." + hotfixVersion;
		devVersionNumber = versionNumber + "." + buildNumber;

		localInputStream = Version.class
				.getResourceAsStream("core-version.properties");
		if (localInputStream != null) {
			try {
				localProperties.load(localInputStream);
				coreMajorVersion = localProperties.getProperty(
						"core.version.major", "");
				coreMinorVersion = localProperties.getProperty(
						"core.version.minor", "");
				corePatchVersion = localProperties.getProperty(
						"core.version.patch", "");
				coreHotfixVersion = localProperties.getProperty(
						"core.version.hotfix", "");
				coreBuildNumber = localProperties.getProperty(
						"core.version.build.number", "");
			} catch (IOException localIOException) {
				System.err.println("Could not read core-version.properties: "
						+ localIOException);
			}
		}
		coreVersionNumber = coreMajorVersion + "." + coreMinorVersion + "."
				+ corePatchVersion + "." + coreHotfixVersion;
		coreDevVersionNumber = coreVersionNumber + "." + coreBuildNumber;
	}
}