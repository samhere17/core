package org.iq.action;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.iq.exception.ServiceException;
import org.iq.util.StringUtil;
import org.iq.version.Version;

/**
 * @author Sam
 */
final public class Actions {

	private static final String ACTIONS_JAR_ENDS_WITH = "-actions.jar";
	private static final Properties actions= new Properties();

	/**
	 * 
	 */
	public static void load() {
		try {
			ClassLoader cl = Actions.class.getClassLoader();
			URL[] jarURLs = ((URLClassLoader) cl).getURLs();

			String coreActionsJarName = "core-" + Version.coreVersionNumber + ACTIONS_JAR_ENDS_WITH;

			// TODO Add application name as parameter. Commenting "ams-" as of now
			String appActionsJarName = /*"ams-" + */Version.versionNumber + ACTIONS_JAR_ENDS_WITH;

			for (URL url : jarURLs) {
				if (url.getFile().endsWith(coreActionsJarName) || url.getFile().endsWith(appActionsJarName)) {
					JarFile jarFile = new JarFile(URLDecoder.decode(url.getPath(), "UTF-8"));
					Enumeration<JarEntry> allEntries = jarFile.entries();
					while (allEntries.hasMoreElements()) {
						JarEntry entry = (JarEntry) allEntries.nextElement();
						String name = entry.getName();
						if (name.endsWith(".class")) {
							String classname = name.replace('/', '.').substring(0, name.length() - 6);
							try {
								Class<?> clazz = Class.forName(classname);
								if (clazz.isAnnotationPresent(Action.class)) {
									Action action = clazz.getAnnotation(Action.class);
									actions.put(action.id(), clazz.getName());
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
			// TODO Exception handling
		}
	}
	
	/**
	 * @param actionId
	 * @return String
	 */
	public static String getActionClassName(String actionId) {
		return actions.getProperty(actionId);
	}
	
	/**
	 * @param actionId
	 * @return BaseAction
	 * @throws ServiceException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static BaseAction getActionClass(String actionId)
			throws ServiceException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String requestedActionClassName = getActionClassName(actionId);

		if (StringUtil.isEmpty(requestedActionClassName)) {
			throw new ServiceException("Class name not found for requested action id = " + actionId);
		}
		Class<?> actionClass = Class.forName(requestedActionClassName);
		return (BaseAction) actionClass.newInstance();
	}
}