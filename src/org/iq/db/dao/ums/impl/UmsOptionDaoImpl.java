package org.iq.db.dao.ums.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.UmsConstants.AreaSpecifier;
import org.iq.UmsConstants.OptionStatus;
import org.iq.UmsConstants.OptionType;
import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.db.dao.ums.UmsOptionDao;
import org.iq.exception.DbException;
import org.iq.valueobject.ums.UmsOption;

public class UmsOptionDaoImpl extends BaseDaoImpl implements UmsOptionDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3936198046919775474L;
	private static final String INSERT_ALL = "INSERT INTO UMS_OPTION (OPTION_NAME, OPTION_DESCRIPTION, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SELECT_ALL = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION ORDER BY PARENT_OPTION_ID, OPTION_ORDER";
	private static final String SELECT_PARENT_OPTIONS = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE OPTION_TYPE = "
			+ OptionType.MENU.getOptionTypeValue() + " ORDER BY OPTION_ORDER";
	private static final String SELECT_PARENT_APP_OPTIONS = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE OPTION_TYPE = "
			+ OptionType.MENU.getOptionTypeValue() + " AND OPTION_AREA = "+AreaSpecifier.APPLICATION.getAreaSpecifierValue()+" ORDER BY OPTION_ORDER";
	private static final String SELECT_ACTIVE_PARENT_OPTIONS = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE OPTION_TYPE = "
			+ OptionType.MENU.getOptionTypeValue() + " AND OPTION_STATUS = "+OptionStatus.ACTIVE.getOptionStatusValue()+" ORDER BY OPTION_ORDER";
	private static final String SELECT_BY_PARENT_OPTION_ID = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE PARENT_OPTION_ID = ? ORDER BY OPTION_ORDER";
	private static final String SELECT_ACTIVE_BY_PARENT_OPTION_ID = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE OPTION_STATUS = "+OptionStatus.ACTIVE.getOptionStatusValue()+" AND PARENT_OPTION_ID = ? ORDER BY OPTION_ORDER";
	private static final String SELECT_LAST_OPTION_ID = "SELECT MAX(OPTION_ID) AS OPTION_ID FROM UMS_OPTION";
	
	private static final String SELECT_BY_OPTION_ID = "SELECT OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY FROM UMS_OPTION WHERE OPTION_ID = ?";

	private static final String UPDATE_ALL_BY_ID = "UPDATE UMS_OPTION SET OPTION_NAME = ?, OPTION_DESCRIPTION = ?, OPTION_TYPE = ?, OPTION_STATUS = ?, OPTION_LINK = ?, OPTION_IMAGE_LINK = ?, OPTION_IMAGE_ALT = ?, OPTION_ORDER = ?, PARENT_OPTION_ID = ?, ENABLE_TOOLBOX = ?, OBJECT_REFERENCE_KEY = ? WHERE OPTION_ID = ?";

	private static final String MARK_DELETE_BY_ID = "UPDATE UMS_OPTION SET OPTION_STATUS = "+OptionStatus.DELETED.getOptionStatusValue()+" WHERE OPTION_ID = ?";

//	private static final String UMS_OPTION_SELECT_ALL_VALID = "SELECT OPTION_ID, OPTION_NAME, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_ORDER, PARENT_OPTION_ID FROM UMS_OPTION WHERE OPTION_STATUS = "+OptionStatus.ACTIVE.getOptionStatusValue()+" ORDER BY PARENT_OPTION_ID, OPTION_ORDER";
//	private static final String UMS_OPTION_SELECT_PARENT = "SELECT OPTION_ID, OPTION_NAME, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_ORDER, PARENT_OPTION_ID FROM UMS_OPTION WHERE PARENT_OPTION_ID = 0";

//	private static final String UMS_USER_UPDATE_PASSWORD_BY_USER_ACCESS_KEY = "UPDATE UMS_USER SET PASSWORD=? WHERE USER_ACCESS_KEY = ?";

	/*
	
	OPTION_ID, OPTION_NAME, OPTION_DESCRIPTION, OPTION_AREA, OPTION_TYPE, OPTION_STATUS, OPTION_LINK, OPTION_IMAGE_LINK, OPTION_IMAGE_ALT, OPTION_ORDER, PARENT_OPTION_ID, ENABLE_TOOLBOX, OBJECT_REFERENCE_KEY

	OPTION_ID				INT NOT NULL AUTO_INCREMENT,
	OPTION_NAME				VARCHAR(25) NOT NULL,
	OPTION_DESCRIPTION		VARCHAR(200),
	OPTION_AREA				INT(2) NOT NULL,
	OPTION_TYPE				INT(2) NOT NULL,
	OPTION_STATUS			INT(2) NOT NULL,
	OPTION_LINK				VARCHAR(200) NOT NULL DEFAULT '#',
	OPTION_IMAGE_LINK		VARCHAR(200),
	OPTION_IMAGE_ALT		VARCHAR(100),
	OPTION_ORDER			INT(2) NOT NULL DEFAULT 0,
	PARENT_OPTION_ID		INT NOT NULL,
	ENABLE_TOOLBOX			TINYINT(1),
	OBJECT_REFERENCE_KEY	VARCHAR(100),

	*/

	/**
	 * @param dbSession
	 */
	public UmsOptionDaoImpl(DbSession dbSession) {
		super(dbSession);
	}


	@Override
	public int insert(UmsOption umsOption) throws DbException {
		return dbSession.executeUpdate(INSERT_ALL, umsOption.getOptionName(),
				umsOption.getOptionDescription(), umsOption.getOptionType()
						.getOptionTypeValue(), umsOption.getOptionStatus()
						.getOptionStatusValue(), umsOption.getOptionLink(),
				umsOption.getOptionImageLink(), umsOption.getOptionImageAlt(),
				umsOption.getOptionOrder(), umsOption.getParentOptionId(),
				umsOption.isEnableToolbox(), umsOption.getObjectReferenceKey());
	}
	
	@Override
	public int insertAndGetID(UmsOption t) throws DbException {
		int count = insert(t);
		if (count==1) {
			return getLastOptionId();
		}
		return -1;
	}

	private int getLastOptionId() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_LAST_OPTION_ID);

		if (dataSet.getRowCount() > 0) {
			return dataSet.getIntValue(0, "OPTION_ID");
		}
		return -1;
	}


	@Override
	public int update(UmsOption umsOption) throws DbException {
		return dbSession.executeUpdate(UPDATE_ALL_BY_ID, umsOption
				.getOptionName(), umsOption.getOptionDescription(), umsOption
				.getOptionType().getOptionTypeValue(), umsOption
				.getOptionStatus().getOptionStatusValue(), umsOption
				.getOptionLink(), umsOption.getOptionImageLink(), umsOption
				.getOptionImageAlt(), umsOption.getOptionOrder(), umsOption
				.getParentOptionId(), umsOption.isEnableToolbox(), umsOption
				.getObjectReferenceKey(), umsOption.getOptionId());
	}


	@Override
	public List<UmsOption> select() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ALL);
		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}


	@Override
	public int delete(UmsOption umsOption) throws DbException {
		return dbSession.executeUpdate(MARK_DELETE_BY_ID, umsOption.getOptionId());
	}

	@Override
	public UmsOption getSingleRow(DataSet dataSet, int rowNum) {
		UmsOption option = new UmsOption();
		option.setOptionId(dataSet.getIntValue(rowNum, "OPTION_ID"));
		option.setOptionName(dataSet.getStringValue(rowNum, "OPTION_NAME"));
		option.setOptionArea(dataSet.getIntValue(rowNum, "OPTION_AREA"));
		option.setOptionDescription(dataSet.getStringValue(rowNum, "OPTION_DESCRIPTION"));
		option.setOptionType(dataSet.getIntValue(rowNum, "OPTION_TYPE"));
		option.setOptionStatus(dataSet.getIntValue(rowNum, "OPTION_STATUS"));
		option.setOptionLink(dataSet.getStringValue(rowNum, "OPTION_LINK"));
		option.setOptionImageLink(dataSet.getStringValue(rowNum, "OPTION_IMAGE_LINK"));
		option.setOptionImageAlt(dataSet.getStringValue(rowNum, "OPTION_IMAGE_ALT"));
		option.setOptionOrder(dataSet.getIntValue(rowNum, "OPTION_ORDER"));
		option.setParentOptionId(dataSet.getIntValue(rowNum, "PARENT_OPTION_ID"));
		option.setEnableToolbox(dataSet.getBooleanValue(rowNum, "ENABLE_TOOLBOX"));
		option.setObjectReferenceKey(dataSet.getStringValue(rowNum, "OBJECT_REFERENCE_KEY"));
		return option;
	}

	@Override
	public List<UmsOption> selectParentOptions() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_PARENT_OPTIONS);
		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}
	
	@Override
	public List<UmsOption> selectParentAppOptions() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_PARENT_APP_OPTIONS);
		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}

	@Override
	public List<UmsOption> selectActiveParentOptions() throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ACTIVE_PARENT_OPTIONS);
		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}

	@Override
	public List<UmsOption> selectByParentId(int parentOptionId)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_PARENT_OPTION_ID,
				parentOptionId);

		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}
	
	@Override
	public List<UmsOption> selectActiveByParentId(int parentOptionId)
			throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_ACTIVE_BY_PARENT_OPTION_ID,
				parentOptionId);

		List<UmsOption> umsOptions = null;
		if (dataSet.getRowCount() > 0) {
			umsOptions = new ArrayList<UmsOption>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				umsOptions.add(getSingleRow(dataSet, i));
			}
		}
		return umsOptions;
	}
	
	@Override
	public UmsOption selectByOptionId(int optionId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(SELECT_BY_OPTION_ID, optionId);
		if (dataSet.getRowCount() > 0) {
			return getSingleRow(dataSet, 0);
		}
		return null;
	}
}