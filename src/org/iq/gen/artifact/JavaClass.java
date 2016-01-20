/**
 * 
 */
package org.iq.gen.artifact;

/**
 * @author Sam
 * 
 */
public class JavaClass extends Artifact {

	public JavaClass(String packagename, String classname, String content, boolean overWrite) {
		super(packagename.replace(".", "/"), classname + JAVA_EXT, content, overWrite);
		this.javaClass = true;
	}
}
