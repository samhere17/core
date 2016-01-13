package org.iq.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.iq.version.Version;

/**
 * @author Sam
 */
final public class ServicesDefinitions {

	private static final Properties services= new Properties();

	/*static {
		try {
			ClassLoader cl = ServicesDefinitions.class.getClassLoader();
			URL[] jarURLs = ((URLClassLoader) cl).getURLs();
			for (URL url : jarURLs) {
//				System.out.println(url.getFile());
				
				String servicesJarName = "ams-"+Version.versionNumber+"-services.jar";
//				System.out.println(servicesJarName);

				if (url.getFile().endsWith(servicesJarName)) {
					JarFile jarFile = new JarFile(URLDecoder.decode(url.getPath(), "UTF-8"));
					Enumeration<JarEntry> allEntries = jarFile.entries();
					while (allEntries.hasMoreElements()) {
						JarEntry entry = (JarEntry) allEntries.nextElement();
						String name = entry.getName();
//						System.out.println(name);

						if (name.endsWith(".class")) {
							String classname = name.replace('/', '.').substring(0, name.length() - 6);
							try {
								Class<?> clazz = Class.forName(classname);
								if (clazz.isAnnotationPresent(Service.class)) {
									Service service = clazz.getAnnotation(Service.class);
									services.put(service.name(), clazz.getName());
								}
							} catch (Throwable e) {
								System.out.println("WARNING: failed to instantiate " + classname + " from " + name);
							}
						}
					}
					jarFile.close();
				}
			}
		} catch (IOException e) {

		}
	}*/
	
	
	/**
	 * 
	 */
	public static void load() {
		try {
			ClassLoader cl = ServicesDefinitions.class.getClassLoader();
			URL[] jarURLs = ((URLClassLoader) cl).getURLs();

			String coreServicesJarName = "core-" + Version.coreVersionNumber + "-services.jar";

			// TODO Add application name as parameter. Commenting "ams-" as of now
			String appServicesJarName = /*"ams-" + */Version.versionNumber + "-services.jar";

			for (URL url : jarURLs) {
				if (url.getFile().endsWith(coreServicesJarName) || url.getFile().endsWith(appServicesJarName)) {
					JarFile jarFile = new JarFile(URLDecoder.decode(url.getPath(), "UTF-8"));
					Enumeration<JarEntry> allEntries = jarFile.entries();
					while (allEntries.hasMoreElements()) {
						JarEntry entry = (JarEntry) allEntries.nextElement();
						String name = entry.getName();
						// System.out.println(name);

						if (name.endsWith(".class")) {
							String classname = name.replace('/', '.').substring(0, name.length() - 6);
							try {
								Class<?> clazz = Class.forName(classname);
								if (clazz.isAnnotationPresent(Service.class)) {
									Service service = clazz.getAnnotation(Service.class);
									services.put(service.name(), clazz.getName());
								}
							} catch (Throwable e) {
								System.out.println("WARNING: failed to instantiate " + classname + " from " + name);
							}
						}
					}
					jarFile.close();
				}
			}
		} catch (IOException e) {

		}
	}
	
	/**
	 * 
	 */
	public static String getServiceClassName(String requestedServiceName) {
		return services.getProperty(requestedServiceName);
	}
}