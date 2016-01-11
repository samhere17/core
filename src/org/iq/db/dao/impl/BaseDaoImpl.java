package org.iq.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.iq.Base;
import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.exception.DbException;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public abstract class BaseDaoImpl<T extends BaseVO> extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6917368018392556478L;
	
	/**
	 * @param dbSession
	 */
	public BaseDaoImpl(DbSession dbSession) {
		super(dbSession);
	}
	
	/**
	 * @param searchQuery
	 * @param searchCriteria
	 * @return List<T>
	 * @throws DbException
	 */
	protected List<T> executeSearch(String searchQuery, List<SearchCriterion> searchCriteria) throws DbException {
		String query = generateSearchQuery(searchQuery, searchCriteria);

		DataSet dataSet = dbSession.executeQuery(query);
		List<T> tList = null;
		if (dataSet.getRowCount() > 0) {
			tList = new ArrayList<T>();
			for (int i = 0; i < dataSet.getRowCount(); i++) {
				tList.add(getSingleRow(dataSet, i));
			}
		}
		return tList;
	}

	/**
	 * @param searchQuery
	 * @param searchCriteria
	 * @return String
	 */
	protected String generateSearchQuery(String searchQuery, List<SearchCriterion> searchCriteria) {

		StringBuilder query = new StringBuilder();

		query.append(searchQuery);

		boolean hasOccured = false;
		for (SearchCriterion searchCriterion : searchCriteria) {
			if (searchCriterion != null) {
				if (StringUtil.isEmpty(StringUtil.getStringValue(searchCriterion.getColoumnName())) == false
						&& StringUtil.isEmpty(StringUtil.getStringValue(searchCriterion.getValue())) == false) {
					query.append(getWhereOrAnd(hasOccured));
					query.append(getCriteriaString(searchCriterion.getColoumnName(),
							StringUtil.getStringValue(searchCriterion.getValue()), searchCriterion.getSearchType()));
					hasOccured = true;
				}
			}
		}

		return query.toString();
	}

	/**
	 * @param hasOccured
	 * @return String
	 */
	private String getWhereOrAnd(boolean hasOccured) {
		return hasOccured ? " AND " : " WHERE ";
	}

	/**
	 * @param columnName
	 * @param criteria
	 * @param searchType
	 * @return String
	 */
	protected String getCriteriaString(String columnName, String criteria, SearchType searchType) {
		switch (searchType) {
		case STARTS_WITH:
			return columnName + " LIKE '" + criteria + "%'";
		case ENDS_WITH:
			return columnName + " LIKE '%" + criteria + "'";
		case EQUALS:
			return columnName + " = '" + criteria + "'";
		case CONTAINS:
		default:
			return columnName + " LIKE '%" + criteria + "%'";
		}
	}

	/**
	 * @param dataSet
	 * @param rowNum
	 * @return T
	 */
	protected abstract T getSingleRow(DataSet dataSet, int rowNum);

	
	/**
	 * The {@code stringToBoolean} method maps a string to a corresponding Boolean value
	 * <p>
	 *     We store Boolean values as '1' or '0' i.e. strings,
	 *     where '1' maps to a Boolean {@code true} value and 0 maps to Boolean {@code false} value".
	 * </p>
	 * <p>
	 *     This method converts the strings back to the Boolean form.
	 * </p>
	 * @param string
	 * @return Boolean
	 */
	public Boolean stringToBoolean(String string) {
		if ("1".equals(string)) {
			return true;
		} else if ("0".equals(string)) {
			return false;
		} else {
			return null;
		}
	}
	
	/**
	 * The {@code booleanToString} method maps a Boolean to a corresponding string value
	 * <p>
	 *     We store Boolean values as '1' or '0' i.e. strings,
	 *     where '1' maps to a Boolean {@code true} value and 0 maps to Boolean {@code false} value".
	 * </p>
	 * <p>
	 *     This method converts the Boolean back to the string form.
	 * </p>
	 * @param bool
	 * @return String
	 */
	public String booleanToString(Boolean bool) {
		if (true == bool) {
			return "1";
		} else if (false == bool) {
			return "0";
		} else {
			return null;
		}
	}
}