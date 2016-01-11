package org.iq.db.dao;

import java.util.List;

import org.iq.exception.DbException;
import org.iq.valueobject.BaseVO;

public interface BaseSearchDao<T extends BaseVO> {

	/**
	 * @param t
	 * @return List<T>
	 * @throws DbException
	 */
	List<T> search(T t) throws DbException;
}