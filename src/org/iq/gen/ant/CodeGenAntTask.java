package org.iq.gen.ant;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.iq.gen.Generator;


/**
 * @author Sam
 * 
 */
public class CodeGenAntTask extends BaseAntTask {

	private String plansDir = null;
	private String moduleNames = null;
	private String destDir = null;

	@Override
	protected void executeTask() throws BuildException {
		String[] moduleNamesArr;
		if (isEmptyString(moduleNames)) {
			/*
			 * if moduleNames is not supplied we will generate all plan files,
			 * so setting moduleNamesArr as null
			 */
			moduleNamesArr = null;
		} else {
			/*
			 * if moduleNames are supplied we will generate plan files for only
			 * supplied modules, so preparing data for moduleNamesArr
			 */
			if (moduleNames.contains(",")) {
				moduleNamesArr = moduleNames.split(",");
			} else {
				moduleNamesArr = new String[] { moduleNames };
			}
		}

		Generator codeGenerator = new Generator(plansDir, moduleNamesArr, destDir);

		codeGenerator.generate();

	}

	/**
	 * @return boolean
	 */
	@Override
	protected void checkInputArgs() throws BuildException {
		if (isEmptyString(plansDir)) {
			throw new BuildException("Error : Mandatory argument 'plansDir' missing.");
		} else {
			File plansDirFile = new File(plansDir);
			if (plansDirFile != null && plansDirFile.isDirectory() == false) {
				throw new BuildException("Error : 'plansDir' = " + plansDir + " is not a directory.");
			} else {
				log("plansDir = " + plansDir, Project.MSG_INFO);
			}
		}

		if (isEmptyString(moduleNames)) {
			log("Argument 'moduleNames' is missing. Will generate all plan files", Project.MSG_WARN);
		} else {
			log("moduleNames = " + moduleNames, Project.MSG_INFO);
			log("Will generate '" + moduleNames+"' plan file(s)", Project.MSG_INFO);
		}

		if (isEmptyString(destDir)) {
			log("Argument 'destDir' is missing. Setting 'basedir' as 'destDir'", Project.MSG_WARN);
			destDir = getProject().getBaseDir().getAbsolutePath();
			log("destDir = " + destDir, Project.MSG_INFO);
		} else {
			log("destDir = " + destDir, Project.MSG_INFO);
		}
	}

	/**
	 * @return the moduleNames
	 */
	public String getModuleNames() {
		return moduleNames;
	}

	/**
	 * @param moduleNames
	 *            the moduleNames to set
	 */
	public void setModuleNames(String moduleNames) {
		this.moduleNames = moduleNames;
	}

	/**
	 * @return the plansDir
	 */
	public String getPlansDir() {
		return plansDir;
	}

	/**
	 * @param plansDir
	 *            the plansDir to set
	 */
	public void setPlansDir(String plansDir) {
		this.plansDir = plansDir;
	}

	/**
	 * @return the destDir
	 */
	public String getDestDir() {
		return destDir;
	}

	/**
	 * @param destDir the destDir to set
	 */
	public void setDestDir(String destDir) {
		this.destDir = destDir;
	}

}