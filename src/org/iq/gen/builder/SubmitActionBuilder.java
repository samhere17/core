/**
 * 
 */
package org.iq.gen.builder;

import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.Module;
import org.iq.gen.data.action.SubmitActionData;

/**
 * @author Sam
 *
 */
public class SubmitActionBuilder extends BaseArtifactBuilder {

	private static final String SUBMIT_ACTION_TEMPLATE_FILE_PATH = "org/iq/gen/builder/template/action-submit.vm";
	
	private SubmitActionData submitAction;

	public SubmitActionBuilder(Module module, SubmitActionData submitAction) {
		super(SUBMIT_ACTION_TEMPLATE_FILE_PATH);
		this.module = module;
		this.submitAction = submitAction;
	}

	@Override
	protected void prepareContext() {
		// put objects to be used in vm template
		context.put("module", module);
		context.put("submitAction", submitAction);
		
		// put objects to be used for building artifact
		context.put("artifact-type", Artifact.Type.JAVA);
		context.put("folder-name", module.getActionPackageName());
		context.put("file-name", submitAction.getClassName());
		context.put("overwrite", true);
	}
}
