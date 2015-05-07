package org.iq.form.dao;

import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.form.Form;

/**
 * @author Sam
 * 
 */
public interface FormDetailsDao extends BaseDao<Form> {

	Form select(int formId) throws DbException;
	
}
