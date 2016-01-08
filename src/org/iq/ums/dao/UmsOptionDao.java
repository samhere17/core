package org.iq.ums.dao;

import java.util.List;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.ums.vo.UmsOption;

/**
 * @author Sam
 * 
 */
public interface UmsOptionDao extends BaseDao<UmsOption> {

	public int insertAndGetID(UmsOption t) throws DbException;

	/**
	 * @param parentOptionId
	 * @return List<UmsOption>
	 */
	public List<UmsOption> selectByParentId(int parentOptionId)
			throws DbException;

	public List<UmsOption> selectParentOptions() throws DbException;

	public UmsOption selectByOptionId(int optionId) throws DbException;

	List<UmsOption> selectActiveParentOptions() throws DbException;

	List<UmsOption> selectActiveByParentId(int parentOptionId)
			throws DbException;

	public List<UmsOption> selectParentAppOptions() throws DbException;

	public int updateOptionOrder(int optId, int newOrderId) throws DbException;

}