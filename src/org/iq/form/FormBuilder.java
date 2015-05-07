package org.iq.form;

import org.iq.db.DbSession;
import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.form.dao.FormDetailsDao;
import org.iq.form.dao.FormDetailsDaoImpl;
import org.iq.form.templates.FormTemplate;
import org.iq.helper.BaseHelper;
import org.iq.util.system.CoreDbProvider;

public class FormBuilder extends BaseHelper {

	public FormBuilder(DbSession dbSession) throws BusinessException {
		super(CoreDbProvider.getDbSession());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162515074478931026L;

	public String getFormHtml(int formId) throws BusinessException {

		Form formData = getFormData(formId);

		return new FormTemplate().generate(formData);
	}

	private Form getFormData(int formId) throws BusinessException {
		FormDetailsDao formDao = new FormDetailsDaoImpl(dbSession);

		try {
			Form formData = formDao.select(formId);

			
			return formData;
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}