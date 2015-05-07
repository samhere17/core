package org.iq.form.dao;

import java.util.List;

import org.iq.db.DataSet;
import org.iq.db.DbSession;
import org.iq.db.dao.impl.BaseDaoImpl;
import org.iq.exception.DbException;
import org.iq.form.Form;

/**
 * @author Sam
 *
 */
public class FormDetailsDaoImpl extends BaseDaoImpl implements FormDetailsDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2172090922961688894L;
	
	private static final String FORM_DETAILS_SELECT_BY_ID = "SELECT FORM_ID, FORM_NAME FROM FORM_DETAILS WHERE FORM_ID = ?";
	
	/*
	
	FORM_ID, FORM_NAME

	FORM_ID				INT NOT NULL AUTO_INCREMENT,
	FORM_NAME			VARCHAR(100) NOT NULL,

	 */
	
	public FormDetailsDaoImpl(DbSession dbSession) {
		super(dbSession);
	}

	@Override
	public int insert(Form t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Form t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Form> select() throws DbException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Form select(int formId) throws DbException {
		DataSet dataSet = dbSession.executeQuery(FORM_DETAILS_SELECT_BY_ID);
		return getSingleRow(dataSet, 0);
	}

	@Override
	public int delete(Form t) throws DbException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Form getSingleRow(DataSet dataSet, int rowNum) {
		Form formData = new Form();
		
		formData.setId(dataSet.getIntValue(rowNum, "FORM_ID"));
		formData.setName(dataSet.getStringValue(rowNum, "FORM_NAME"));
		
		return formData;
	}
}