/**
 * 
 */
package org.iq.gen.builder;

import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.Module;

/**
 * @author Sam
 *
 */
public class ParamKeysBuilder extends BaseArtifactBuilder {

	private static final String PARAM_KEYS_TEMPLATE_FILE_PATH = "org/iq/gen/builder/template/param-keys.vm";

	public ParamKeysBuilder(Module module) {
		super(PARAM_KEYS_TEMPLATE_FILE_PATH);
		this.module = module;
	}

	@Override
	protected void prepareContext() {
		// put objects to be used in vm template
		context.put("module", module);
		
		// put objects to be used for building artifact
		context.put("artifact-type", Artifact.Type.JAVA);
		context.put("folder-name", module.getServicePackageName());
		context.put("file-name", module.getParamKeysClassName());
		context.put("overwrite", true);
	}
}
