/**
 * 
 */
package org.iq.gen;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.iq.exception.UtilityException;
import org.iq.gen.artifact.Artifact;
import org.iq.gen.builder.FormBuilder;
import org.iq.gen.builder.LaunchActionBuilder;
import org.iq.gen.builder.ParamKeysBuilder;
import org.iq.gen.builder.RedirectActionBuilder;
import org.iq.gen.builder.SubmitActionBuilder;
import org.iq.gen.data.Form;
import org.iq.gen.data.Module;
import org.iq.gen.data.action.LaunchActionData;
import org.iq.gen.data.action.RedirectActionData;
import org.iq.gen.data.action.SubmitActionData;

/**
 * @author Sam
 *
 */
public class Generator {
	
	private String plansDir = null;
	private String[] moduleNames = null;
	
	private List<Artifact> generatedArtifacts = new ArrayList<Artifact>();
	
	public Generator(String plansDir, String[] moduleNames, String destDir, String packagePrefix) {
		this.plansDir = plansDir;
		this.moduleNames = moduleNames;
		
		//initialize GeneratorContext
		GeneratorContext.destination_directory = destDir;
		GeneratorContext.package_prefix = packagePrefix;
	}
	
	public void generate() {
		try {
			List<File> planFilesToGenerate = getPlanFilesToGenerate();
			
			if (planFilesToGenerate != null && planFilesToGenerate.size() > 0) {
				for (File planFile : planFilesToGenerate) {
					System.out.println("Processing " + planFile.getName() + " file.");
					String jsonString = GeneratorUtil.getFileContent(planFile);
					Module module = (Module) GeneratorUtil.getObject(jsonString, Module.class);

					if (module != null) {
						// Generating module level artifacts
						ParamKeysBuilder paramKeysBuilder = new ParamKeysBuilder(module);
						generatedArtifacts.add(paramKeysBuilder.getGeneratedArtifact());

						// Generating form level artifacts
						List<Form> forms = module.getForms();
						if (forms != null && forms.size() > 0) {
							for (Form form : forms) {
								FormBuilder formContentBuilder = new FormBuilder(form, module.getName());
								generatedArtifacts.add(formContentBuilder.getGeneratedArtifact());
							}
						}

						// Generating action level artifacts
						List<RedirectActionData> redirectActions = module.getRedirectActions();
						if (redirectActions != null && redirectActions.size() > 0) {
							for (RedirectActionData redirectAction : redirectActions) {
								RedirectActionBuilder redirectActionBuilder = new RedirectActionBuilder(module,
										redirectAction);
								generatedArtifacts.add(redirectActionBuilder.getGeneratedArtifact());
							}
						}

						List<LaunchActionData> launchActions = module.getLaunchActions();
						if (launchActions != null && launchActions.size() > 0) {
							for (LaunchActionData launchAction : launchActions) {
								LaunchActionBuilder launchActionBuilder = new LaunchActionBuilder(module, launchAction);
								generatedArtifacts.add(launchActionBuilder.getGeneratedArtifact());

								RedirectActionData innerRedirectAction = launchAction.getRedirectAction();
								if (innerRedirectAction != null) {
									RedirectActionBuilder redirectActionBuilder = new RedirectActionBuilder(module,
											innerRedirectAction);
									generatedArtifacts.add(redirectActionBuilder.getGeneratedArtifact());
								}
							}
						}

						List<SubmitActionData> submitActions = module.getSubmitActions();
						if (submitActions != null && submitActions.size() > 0) {
							for (SubmitActionData submitAction : submitActions) {
								SubmitActionBuilder submitActionBuilder = new SubmitActionBuilder(module, submitAction);
								generatedArtifacts.add(submitActionBuilder.getGeneratedArtifact());
								
								//TODO inner actions
							}
						}
					}
				}
			}
		} catch (UtilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Creating files
		/*if (generatedFilesMap != null && generatedFilesMap.isEmpty() == false) {
			for (Map.Entry<String, String> entry : generatedFilesMap.entrySet()) {
				String filename = entry.getKey();
				
				try {
					GeneratorUtil.createFile(entry.getKey(), entry.getValue(), true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/
		if (generatedArtifacts != null && generatedArtifacts.isEmpty() == false) {
			for (Artifact artifact : generatedArtifacts) {
				try {
					artifact.save();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @return
	 */
	private List<File> getPlanFilesToGenerate() {
		List<File> planFilesToGenerate = null;
		
		File plansDirFile = new File(plansDir);
		
		// getting all plan files in the supplied directory
		File[] planFiles = plansDirFile.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".plan.json");
			}
		});
		
		
		if (planFiles != null && planFiles.length > 0) {
//			System.out.println(planFiles.length + " plan json files found.");
			if (moduleNames != null && moduleNames.length > 0) {
				// if moduleNames are supplied we will generate plan files for only supplied modules
				planFilesToGenerate = new ArrayList<File>();
				for (String moduleStr : moduleNames) {
					for (File planFile : planFiles) {
						if (moduleStr
								.equalsIgnoreCase(planFile.getName().substring(0, planFile.getName().indexOf(".")))) {
							planFilesToGenerate.add(planFile);
							break;
						}
					}
				}
			} else {
				// if moduleNames is not supplied we will generate all plan files
				planFilesToGenerate = Arrays.asList(planFiles);
			}
		}
		return planFilesToGenerate;
	}
}