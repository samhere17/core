package org.iq.gen.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author Sam
 * 
 */
public abstract class BaseAntTask extends Task {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		super.execute();
		checkInputArgs();
		executeTask();
	}

	/**
	 * 
	 */
	protected abstract void checkInputArgs() throws BuildException;

	/**
	 * @throws BuildException
	 */
	protected abstract void executeTask() throws BuildException;

	/**
	 * @param inputStr
	 * @return boolean
	 */
	protected boolean isEmptyString(String inputStr) {
		return inputStr == null ? true : inputStr.trim().length() == 0 ? true : false;
	}
}