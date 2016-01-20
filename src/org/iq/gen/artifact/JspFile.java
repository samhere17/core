/**
 * 
 */
package org.iq.gen.artifact;

/**
 * @author Sam
 * 
 */
public class JspFile extends Artifact {

	public JspFile(String foldername, String filename, String content, boolean overWrite) {
		super(foldername, filename + JSP_EXT, content, overWrite);
		this.jspFile = true;
	}
}
