/**
 * 
 */
package org.iq.gen.builder;

import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.Module;
import org.iq.gen.data.action.LaunchActionData;

/**
 * @author Sam
 *
 */
public class LaunchActionBuilder extends BaseArtifactBuilder {

	private static final String LAUNCH_ACTION_TEMPLATE_FILE_PATH = "org/iq/gen/builder/template/action-launch.vm";
	
	private LaunchActionData launchAction;

	public LaunchActionBuilder(Module module, LaunchActionData launchAction) {
		super(LAUNCH_ACTION_TEMPLATE_FILE_PATH);
		this.module = module;
		this.launchAction = launchAction;
	}

	@Override
	protected void prepareContext() {
		// put objects to be used in vm template
		context.put("module", module);
		context.put("launchAction", launchAction);
		
		// put objects to be used for building artifact
		context.put("artifact-type", Artifact.Type.JAVA);
		context.put("folder-name", module.getActionPackageName());
		context.put("file-name", launchAction.getClassName());
		context.put("overwrite", true);
	}
}
