package org.iq.db;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.iq.config.ConfigFactory;
import org.iq.config.DatabaseConfig;
import org.iq.exception.DbException;

/**
 * @author Sam
 * 
 */
public class DbSessionFactory {

	/**
	 * @return {@link DbSession}
	 */
	/*public static DbSession getDbSession() {
		DatabaseConfig databaseConfig = (DatabaseConfig) ConfigFactory.getConfig("org.iq.config.DatabaseConfig");
		
		DbSession dbSession = null;
		try {
			Class<?> classDefinition = Class.forName(databaseConfig.getDbSessionClassname());
			Constructor<?> constructor = classDefinition
					.getConstructor(String.class, Short.class, String.class, String.class, String.class);
			dbSession = (DbSession) constructor.newInstance(
					databaseConfig.getDbHost(), databaseConfig.getDbPort(),
					databaseConfig.getDbName(), databaseConfig.getDbUser(),
					databaseConfig.getDbPass());
			
//			dbSession = (DbSession) classDefinition.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO
		} catch (InstantiationException e) {
			// TODO
		} catch (IllegalAccessException e) {
			// TODO
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
		}
		return dbSession;
	}*/

	/**
	 * @param databaseName
	 * @return {@link DbSession}
	 * @throws {@link DbException}
	 */
	public static DbSession getDbSession(String databaseName)
			throws DbException {
		DatabaseConfig databaseConfig = (DatabaseConfig) ConfigFactory
				.getConfig("org.iq.config.DatabaseConfig", databaseName);

		DbSession dbSession = null;
		try {
			Class<?> classDefinition = Class.forName(databaseConfig
					.getDbSessionClassname());
			Constructor<?> constructor = classDefinition.getConstructor(
					String.class, Short.class, String.class, String.class,
					String.class);
			dbSession = (DbSession) constructor.newInstance(
					databaseConfig.getDbHost(), databaseConfig.getDbPort(),
					databaseConfig.getDbName(), databaseConfig.getDbUser(),
					databaseConfig.getDbPass());

		} catch (ClassNotFoundException e) {
			throw new DbException(e);
		} catch (InstantiationException e) {
			throw new DbException(e);
		} catch (IllegalAccessException e) {
			throw new DbException(e);
		} catch (IllegalArgumentException e) {
			throw new DbException(e);
		} catch (InvocationTargetException e) {
			throw new DbException(e);
		} catch (NoSuchMethodException e) {
			throw new DbException(e);
		} catch (SecurityException e) {
			throw new DbException(e);
		}
		return dbSession;
	}
	
	/**
	 * @param dbSessionClassname
	 * @param dbHost
	 * @param dbPort
	 * @param dbName
	 * @param dbUser
	 * @param dbPass
	 * @return {@link DbSession}
	 * @throws {@link DbException}
	 */
	public static DbSession getDbSession(String dbSessionClassname,
			String dbHost, Short dbPort, String dbName, String dbUser,
			String dbPass) throws DbException {
		DbSession dbSession = null;
		try {
			Class<?> classDefinition = Class.forName(dbSessionClassname);
			Constructor<?> constructor = classDefinition.getConstructor(
					String.class, Short.class, String.class, String.class,
					String.class);
			dbSession = (DbSession) constructor.newInstance(dbHost, dbPort,
					dbName, dbUser, dbPass);

		} catch (ClassNotFoundException e) {
			throw new DbException(e);
		} catch (InstantiationException e) {
			throw new DbException(e);
		} catch (IllegalAccessException e) {
			throw new DbException(e);
		} catch (IllegalArgumentException e) {
			throw new DbException(e);
		} catch (InvocationTargetException e) {
			throw new DbException(e);
		} catch (NoSuchMethodException e) {
			throw new DbException(e);
		} catch (SecurityException e) {
			throw new DbException(e);
		}
		return dbSession;
	}
}