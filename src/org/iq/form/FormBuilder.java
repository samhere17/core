package org.iq.form;

import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.form.dao.FormDetailsDao;
import org.iq.form.dao.FormDetailsDaoImpl;
import org.iq.form.templates.FormTemplate;
import org.iq.form.templates.TemplateTest;
import org.iq.helper.BaseHelper;
import org.iq.util.system.CoreDbProvider;

public class FormBuilder extends BaseHelper {

	public FormBuilder() throws BusinessException {
		super(CoreDbProvider.getDbSession());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5162515074478931026L;

	public String getFormHtml(int formId) throws BusinessException {
		Form formData = null;
		//For development testing
		if (formId==0) {
			formData = TemplateTest.getDummyForm();
		}
		else {
			formData = getFormData(formId);
		}

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