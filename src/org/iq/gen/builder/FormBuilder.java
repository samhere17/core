/**
 * 
 */
package org.iq.gen.builder;

import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.Form;

/**
 * @author Sam
 *
 */
public class FormBuilder extends BaseArtifactBuilder {

	private static final String FORM_TEMPLATE_FILE_PATH = "org/iq/gen/builder/template/form.vm";
	
	private Form form;
	private String moduleName;

	public FormBuilder(Form form, String moduleName) {
		super(FORM_TEMPLATE_FILE_PATH);
		this.form = form;
		this.moduleName = moduleName;
	}

	@Override
	protected void prepareContext() {
		// put objects to be used in vm template
//		context.put("module", module);
		context.put("form", form);
		context.put("moduleName", moduleName);
		
		// put objects to be used for building artifact
		context.put("artifact-type", Artifact.Type.JSP);
		context.put("folder-name", moduleName/*module.getServicePackageName()*/); //TODO
		context.put("file-name", form.getId()); //TODO change method to getJspFileName()
		context.put("overwrite", true);
	}
}