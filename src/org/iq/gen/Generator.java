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
import org.iq.gen.builder.ParamKeysBuilder;
import org.iq.gen.data.Form;
import org.iq.gen.data.Module;

/**
 * @author Sam
 *
 */
public class Generator {
	
	private String plansDir = null;
	private String[] moduleNames = null;
//	private String destDir = null;
	
	private List<Artifact> generatedArtifacts = new ArrayList<Artifact>();
	
	public Generator(String plansDir, String[] moduleNames, String destDir) {
		this.plansDir = plansDir;
		this.moduleNames = moduleNames;
//		this.destDir = destDir;
		
		//initialize GeneratorContext
		GeneratorContext.root = destDir;
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
						//Generating forms
						List<Form> forms = module.getForms();
						if (forms != null && forms.size()>0) {
							for (Form form : forms) {
								FormBuilder formContentBuilder = new FormBuilder(form, module.getName());
								/*generatedFilesMap.put(formContentBuilder.getGeneratedFilename(),
											formContentBuilder.getGeneratedContent());*/

								generatedArtifacts.add(formContentBuilder.getGeneratedArtifact());

								ParamKeysBuilder paramKeysBuilder = new ParamKeysBuilder(module);
								/*generatedFilesMap.put(paramKeysBuilder.getGeneratedFilename(),
											paramKeysBuilder.getGeneratedContent());*/

								generatedArtifacts.add(paramKeysBuilder.getGeneratedArtifact());

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