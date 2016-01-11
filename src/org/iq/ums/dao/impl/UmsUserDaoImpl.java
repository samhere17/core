package org.iq.ums.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.exception.DbException;
import org.iq.ums.UmsConstants.UserStatus;
import org.iq.ums.UmsConstants.UserType;
import org.iq.ums.dao.UmsUserDao;
import org.iq.ums.util.UmsPasswordEncryptor;
import org.iq.ums.vo.UmsUser;

public class UmsUserDaoImpl extends BaseDaoImpl<UmsUser> implements UmsUserDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4472700398346719027L;
	private static final String SELECT_ALL = "SELECT USER_ID, USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY FROM UMS_USER";
	private static final String SELECT_BY_USER_ID = "SELECT USER_ID, USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY FROM UMS_USER WHERE USER_ID = ?";
	private static final String SELECT_BY_USER_ACCESS_KEY = "SELECT USER_ID, USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY FROM UMS_USER WHERE USER_ACCESS_KEY = ?";
	private static final String SELECT_BY_USERNAME = "SELECT USER_ID, USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY FROM UMS_USER WHERE USERNAME = ?";

	private static final String INSERT_ALL = "INSERT INTO UMS_USER (USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

//	private static final String UMS_USER_UPDATE_ALL_BY_USER_ACCESS_KEY = "UPDATE UMS_USER SET USERNAME=?, PASSWORD=?, USER_TYPE=?, USER_STATUS=? WHERE USER_ACCESS_KEY = ?";
	private static final String UPDATE_PASSWORD_BY_USER_ACCESS_KEY = "UPDATE UMS_USER SET PASSWORD=? WHERE USER_ACCESS_KEY = ?";

//	private static final String DELETE_HARD_BY_USER_ACCESS_KEY = "DELETE FROM UMS_USER WHERE USER_ACCESS_KEY = ?";
	private static final String DELETE_SOFT_BY_USER_ACCESS_KEY = "UPDATE UMS_USER SET USER_STATUS = " + UserStatus.DELETED.getUserStatusValue() + " WHERE USER_ACCESS_KEY = ?";
	private static final String SELECT_BY_TYPE_SYSTEM = "SELECT USER_ID,USER_ACCESS_KEY ,USERNAME,PASSWORD ,USER_TYPE ,USER_STATUS,ADDITIONAL_ID FROM UMS_USER WHERE USER_TYPE="
			+ UserType.SYSTEM_USER.getUerTypeValue();
	private static final String SELECT_LAST_USER_ID = "SELECT MAX(USER_ID) AS USER_ID FROM UMS_USER";
	
	/*
	USER_ID, USER_ACCESS_KEY, USERNAME, PASSWORD, USER_TYPE, USER_STATUS, ADDITIONAL_ID, USER_CREATION_STAMP, USER_UPDATED_STAMP, USER_UPDATED_BY

	USER_ID				INT NOT NULL AUTO_INCREMENT,
	USER_ACCESS_KEY		VARCHAR(50) NOT NULL UNIQUE,
	USERNAME			VARCHAR(50) NOT NULL,
	PASSWORD			VARCHAR(90) NOT NULL,
	USER_TYPE			TINYINT NOT NULL,
	USER_STATUS			TINYINT(2) NOT NULL,
	ADDITIONAL_ID		VARCHAR(100),
	USER_CREATION_STAMP	TIMESTAMP NOT NULL,
	USER_UPDATED_STAMP	TIMESTAMP NOT NULL,
	USER_UPDATED_BY		INT,
	 */

	/**
	 * @param dbSession
	 */
	public UmsUserDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public List<UmsUser> getAllUsers() throws DbException {
		return select();
	}

	@Override
	public List<UmsUser> getSystemUsers() throws DbException {
		DataSet dataSet = dbSession
				.executeQuery(SELECT_BY_TYPE_SYSTEM);

		List<UmsUser> umsUsers = null;
		if (dataSet.getRowCount() > 0) {
			umsUsers = new ArrayList<UmsUser>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsUsers.add(getSingleRow(dataSet, i));
			}
		}

		return umsUsers;
	}

	@Override
	public UmsUser getUserByUserAccessKey(String userAccessKey)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(
				SELECT_BY_USER_ACCESS_KEY, userAccessKey);

		UmsUser user = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			user = getSingleRow(dataSet, 0);
		}

		return user;
	}
	
	@Override
	public UmsUser getUserByUserId(int userId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_USER_ID, userId);

		UmsUser user = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			user = getSingleRow(dataSet, 0);
		}

		return user;
	}


	@Override
	public UmsUser getUserByUsername(String userName) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_USERNAME,
				userName);

		UmsUser user = null;
		if (dataSet != null && dataSet.getRowCount() > 0) {
			user = getSingleRow(dataSet, 0);
		}

		return user;
	}

	@Override
	public int updatePassword(String userAccessKey, String password)
			throws DbException {
		return dbSession.executeUpdate(
				UPDATE_PASSWORD_BY_USER_ACCESS_KEY, password,
				userAccessKey);
	}
	
	@Override
	public int insertAndGetUserId(UmsUser user) throws DbException {
		int count = insert(user);
		if (count==1) {
			return getLastUserId();
		}
		return -1;
	}

	@Override
	public int getLastUserId() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_LAST_USER_ID);

		if (dataSet.getRowCount() > 0) {
			return dataSet.getIntValue(0, "USER_ID");
		}

		return -1;
	}

	@Override
	public int insert(UmsUser user) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, user.getUserAccessKey(),
				user.getUsername(), user.getPassword(), user.getUserType()
						.getUerTypeValue(), user.getUserStatus()
						.getUserStatusValue(), user.getAdditionalId(), user
						.getUserCreationTime(), user.getUserUpdatedTime(), user
						.getUserUpdatedBy());
	}

	@Override
	public int update(UmsUser object) throws DbException {
		return dbSession.executeUpdate(SELECT_BY_USER_ACCESS_KEY,
				object.getUserAccessKey());
	}

	@Override
	public List<UmsUser> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);

		List<UmsUser> umsUsers = null;
		if (dataSet.getRowCount() > 0) {
			umsUsers = new ArrayList<UmsUser>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				UmsUser user = getSingleRow(dataSet, i);
				umsUsers.add(user);
			}
		}
		return umsUsers;
	}

	@Override
	public UmsUser getSingleRow(DataSet dataSet, int rowNum) {
		UmsUser user = new UmsUser();
		user.setUserId(dataSet.getIntValue(rowNum, "USER_ID"));
		user.setUserAccessKey(dataSet.getStringValue(rowNum, "USER_ACCESS_KEY"));
		user.setUsername(dataSet.getStringValue(rowNum, "USERNAME"));
		user.setPassword(dataSet.getStringValue(rowNum, "PASSWORD"));
		user.setDecryptedPassword(UmsPasswordEncryptor.decrypt(user.getPassword()));
		user.setUserType(UserType.getUserType(dataSet.getIntValue(rowNum,
				"USER_TYPE")));
		user.setUserStatus(UserStatus.getUserStatus(dataSet.getIntValue(rowNum,
				"USER_STATUS")));
		user.setAdditionalId(dataSet.getStringValue(rowNum, "ADDITIONAL_ID"));
		user.setUserCreationTime(dataSet.getDateValue(rowNum,
				"USER_CREATION_STAMP"));
		user.setUserUpdatedTime(dataSet.getDateValue(rowNum,
				"USER_UPDATED_STAMP"));
		user.setUserUpdatedBy(dataSet.getIntValue(rowNum, "USER_UPDATED_BY"));
		return user;
	}

	@Override
	public int softDelete(UmsUser umsUser) throws DbException {
		return dbSession.executeUpdate(DELETE_SOFT_BY_USER_ACCESS_KEY,
				umsUser.getUserAccessKey());
	}

	@Override
	public int hardDelete(UmsUser t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

}