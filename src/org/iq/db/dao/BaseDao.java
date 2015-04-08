package org.iq.db.dao;

import java.util.List;

import org.iq.db.DataSet;
import org.iq.exception.DbException;
import org.iq.valueobject.BaseVO;

public interface BaseDao<T extends BaseVO> {

	/**
	 * @param t
	 * @return int
	 * @throws DbException
	 */
	int insert(T t) throws DbException;

	/**
	 * @param t
	 * @return int
	 * @throws DbException
	 */
	int update(T t) throws DbException;

	/**
	 * @return List<T>
	 * @throws DbException
	 */
	List<T> select() throws DbException;
	
	/**
	 * @param t
	 * @return int
	 * @throws DbException
	 */
	int delete(T t) throws DbException;

	/**
	 * @param dataSet
	 * @param rowNum
	 * @return T
	 */
	T getSingleRow(DataSet dataSet, int rowNum);

}