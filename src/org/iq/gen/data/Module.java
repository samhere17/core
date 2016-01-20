package org.iq.gen.data;

import java.util.List;

import org.iq.gen.GeneratorUtil;
import org.iq.gen.artifact.Artifact;

public class Module extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 740921971425383868L;

	private static final String SERVICE_PACKAGE_PREFIX = "com.iq.ams.service.";
	private static final String PARAM_KEYS_CLASS_SUFFIX = "ParamKeys";

	private String name;
	private String description;
	private List<Form> forms;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the forms
	 */
	public List<Form> getForms() {
		return forms;
	}

	/**
	 * @param forms
	 *            the forms to set
	 */
	public void setForms(List<Form> forms) {
		this.forms = forms;
	}
	/**
	 * @return String
	 */
	public String getServicePackageName() {
		return SERVICE_PACKAGE_PREFIX + name.replace(" ", "").toLowerCase();
	}

	/**
	 * @return String
	 */
	public String getParamKeysClassName() {
		return GeneratorUtil.toCamelCase(name) + PARAM_KEYS_CLASS_SUFFIX;
	}

	/**
	 * @return String
	 */
	public String getParamKeysClassFileName() {
		return getServicePackageName().replace(".", "/")+getParamKeysClassName()+Artifact.JAVA_EXT;
	}
}