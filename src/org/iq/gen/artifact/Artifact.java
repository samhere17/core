package org.iq.gen.artifact;

import java.io.File;
import java.io.IOException;

import org.iq.gen.GeneratorContext;
import org.iq.gen.GeneratorUtil;

/**
 * @author Sam
 *
 */
public abstract class Artifact {

	public static final String JSP_EXT = ".jsp";
	public static final String JAVA_EXT = ".java";

	public static final String GEN_SOURCE_FOLDER = "gen";
	public static final String GEN_WEB_FOLDER = "web/gen";

	protected String filename = null;
	protected String foldername = null;
	protected String content = null;
	protected boolean overWrite = false;
	
	protected boolean javaClass;
	protected boolean jspFile;
	
	public enum Type {
		JAVA, JSP;
	}
	
	public Artifact(String foldername, String filename, String content, boolean overWrite) {
		this.foldername = foldername;
		this.filename = filename;
		this.content = content;
		this.overWrite = overWrite;
	}

	/**
	 * @throws IOException
	 * 
	 */
	public void save() throws IOException {
		GeneratorUtil.createFile(getFullFilePath(), content, overWrite);
	}

	/**
	 * @return String
	 */
	private String getFullFilePath() {
		String fullFilePath = GeneratorContext.root;
		if (isJavaClass()) {
			fullFilePath = fullFilePath + File.separator + GEN_SOURCE_FOLDER;
		} else if (isJspFile()) {
			fullFilePath = fullFilePath + File.separator + GEN_WEB_FOLDER;
		}
		fullFilePath = fullFilePath + File.separator + foldername + File.separator + filename;
		return fullFilePath;
	}

	private boolean isJspFile() {
		return jspFile;
	}

	private boolean isJavaClass() {
		return javaClass;
	}
}