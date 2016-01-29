package org.iq.gen.data;

import java.util.List;

import org.iq.gen.GeneratorContext;
import org.iq.gen.GeneratorUtil;
import org.iq.gen.artifact.Artifact;
import org.iq.gen.data.action.LaunchActionData;
import org.iq.gen.data.action.RedirectActionData;
import org.iq.gen.data.action.SubmitActionData;

public class Module extends BaseData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 740921971425383868L;

	private static final String SERVICE_PACKAGE_PREFIX = GeneratorContext.package_prefix+".service.";
	private static final String ACTION_PACKAGE_PREFIX = GeneratorContext.package_prefix+".action.";
	private static final String PARAM_KEYS_CLASS_SUFFIX = "ParamKeys";

	private String name;
	private String description;
	private List<Form> forms;

	private List<RedirectActionData> redirectActions;
	private List<LaunchActionData> launchActions;
	private List<SubmitActionData> submitActions;

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
	 * @return the redirectActions
	 */
	public final List<RedirectActionData> getRedirectActions() {
		return redirectActions;
	}

	/**
	 * @param redirectActions the redirectActions to set
	 */
	public final void setRedirectActions(List<RedirectActionData> redirectActions) {
		this.redirectActions = redirectActions;
	}

	/**
	 * @return the launchActions
	 */
	public final List<LaunchActionData> getLaunchActions() {
		return launchActions;
	}

	/**
	 * @param launchActions the launchActions to set
	 */
	public final void setLaunchActions(List<LaunchActionData> launchActions) {
		this.launchActions = launchActions;
	}

	/**
	 * @return the submitActions
	 */
	public final List<SubmitActionData> getSubmitActions() {
		return submitActions;
	}

	/**
	 * @param submitActions the submitActions to set
	 */
	public final void setSubmitActions(List<SubmitActionData> submitActions) {
		this.submitActions = submitActions;
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
	public String getActionPackageName() {
		return ACTION_PACKAGE_PREFIX + name.replace(" ", "").toLowerCase();
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
		return getServicePackageName().replace(".", "/") + getParamKeysClassName() + Artifact.JAVA_EXT;
	}
}