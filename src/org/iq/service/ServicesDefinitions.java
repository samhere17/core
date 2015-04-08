package org.iq.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Sam
 */
final public class ServicesDefinitions {

//	private static final String SERVICES_CONFIG_NAME = "services.def";

	private static final Properties services= new Properties();

	static {
		
//		Collection<Class<?>> classes = new ArrayList<Class<?>>();
		
		try {
			ClassLoader cl = ServicesDefinitions.class.getClassLoader();
			URL[] jarURLs = ((URLClassLoader) cl).getURLs();
			for (URL url : jarURLs) {
//				System.out.println(url.getFile());

				JarFile jarFile = new JarFile(URLDecoder.decode(url.getPath(), "UTF-8"));
				Enumeration<JarEntry> allEntries = jarFile.entries();
				while (allEntries.hasMoreElements()) {
					JarEntry entry = (JarEntry) allEntries.nextElement();
					String name = entry.getName();
//					System.out.println(name);

					if (name.endsWith(".class")) {
						String classname = name.replace('/', '.').substring(0,
								name.length() - 6);
						try {
							Class<?> clazz = Class.forName(classname);
							if (clazz.isAnnotationPresent(Service.class)) {
//								classes.add(c);
								Service service = clazz.getAnnotation(Service.class);
								
								services.put(service.name(),clazz.getName());
							}
						} catch (Throwable e) {
							System.out
									.println("WARNING: failed to instantiate "
											+ classname + " from " + name);
						}
					}
				}
				jarFile.close();
			}
			
			/*for (Class<?> clazz : classes) {
				System.out.println(clazz.getName());
			}*/
		} catch (IOException e) {

		}

		System.out.println("#########");		
		
		/*try {
			LocalLogger.logDebug("Loading system services.def...");
			
			Properties systemServices = new Properties();
			systemServices.load(new FileInputStream(new File(SystemContext
					.getSystemConfigHome()
					+ File.separator
					+ SERVICES_CONFIG_NAME)));
			services.putAll(systemServices);

			LocalLogger.logDebug("Loading system services.def successful");
			
			LocalLogger.logDebug("Loading user services.def...");

			Properties userServices = new Properties();
			userServices.load(new FileInputStream(new File(SystemContext
					.getAppConfigHome()
					+ File.separator
					+ SERVICES_CONFIG_NAME)));
			services.putAll(userServices);

			LocalLogger.logDebug("Loading user services.def successful");
			
		} catch (FileNotFoundException e) {
			LocalLogger.logSevere(e);
		} catch (IOException e) {
			LocalLogger.logSevere(e);
		}*/
	}
	
	
	/**
	 * 
	 */
	public static final String getServiceClassName(String requestedServiceName) {
		return services.getProperty(requestedServiceName);
	}
}