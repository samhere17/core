package org.iq.service.external.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("RS")
public class JerseyApplication extends ResourceConfig {

	/**
	 * 
	 */
	public JerseyApplication() {
		
		System.out.println("STARTING JERSEY APPLICATION...");

		System.out.println("[INFO]  Loading default-packages.properties...");
		Properties defaultPackages = new Properties();
		InputStream localInputStream = JerseyApplication.class
				.getResourceAsStream("default-packages.properties");
		if (localInputStream != null) {
			try {
				defaultPackages.load(localInputStream);
				System.out.println("[INFO]  Loading default-packages.properties... SUCCESS");
			} catch (IOException localIOException) {
				System.out.println("[ERROR] Loading default-packages.properties... ERROR");
				System.out.println(localIOException);
			}
		}

		System.out.println("[INFO]  Loading packages.properties...");
		Properties packages = new Properties(defaultPackages);
		localInputStream = JerseyApplication.class
				.getResourceAsStream("packages.properties");
		if (localInputStream != null) {
			try {
				packages.load(localInputStream);
				System.out.println("[INFO]  Loading packages.properties... SUCCESS");
			} catch (IOException localIOException) {
				System.out.println("[ERROR] Loading packages.properties... ERROR");
				System.out.println(localIOException);
			}
		}

		Set<Object> packageNames = packages.keySet();

		for (Object packageName : packageNames) {
			Boolean recursive = (Boolean) packages.get(packageName);
			if (recursive) {
				packages(true, packageName.toString());
			} else {
				packages(packageName.toString());
			}
		}
		
		System.out.println("JERSEY APPLICATION STARTED SUCCESSFULLY");
	}
}