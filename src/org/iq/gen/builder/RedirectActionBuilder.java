/**
 * 
 */
package org.iq.gen.builder;

import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.Module;
import org.iq.gen.data.action.RedirectActionData;

/**
 * @author Sam
 *
 */
public class RedirectActionBuilder extends BaseArtifactBuilder {

	private static final String REDIRECT_ACTION_TEMPLATE_FILE_PATH = "org/iq/gen/builder/template/action-redirect.vm";
	
	private RedirectActionData redirectAction;

	public RedirectActionBuilder(Module module, RedirectActionData redirectAction) {
		super(REDIRECT_ACTION_TEMPLATE_FILE_PATH);
		this.module = module;
		this.redirectAction = redirectAction;
	}

	@Override
	protected void prepareContext() {
		// put objects to be used in vm template
		context.put("module", module);
		context.put("redirectAction", redirectAction);
		
		// put objects to be used for building artifact
		context.put("artifact-type", Artifact.Type.JAVA);
		context.put("folder-name", module.getActionPackageName());
		context.put("file-name", redirectAction.getClassName());
		context.put("overwrite", true);
	}
}
