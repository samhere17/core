/**
 * 
 */
package org.iq.gen.builder;

import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.iq.gen.artifact.Artifact;
import org.iq.gen.artifact.Artifact.Type;
import org.iq.gen.artifact.JavaClass;
import org.iq.gen.artifact.JspFile;
import org.iq.gen.data.Module;

/**
 * @author Sam
 *
 */
public abstract class BaseArtifactBuilder {

	private String templateFilePath;
	
	protected Module module;

	protected VelocityContext context = new VelocityContext();

	public BaseArtifactBuilder(String templateFilePath) {
		this.templateFilePath = templateFilePath;
	}
	
	/**
	 * @return the generated artifact
	 */
	public Artifact getGeneratedArtifact() {
		prepareContext();
		
		Type artifactType = (Type) context.get("artifact-type");
		String folderName = (String) context.get("folder-name"); //package name in case of java class
		String fileName = (String) context.get("file-name"); //class name in case of java class
		boolean overwrite = (boolean) context.get("overwrite");
		
		//Setting StringUtils in context, as this is to be used in VM
		context.put("StringUtils", StringUtils.class);
		context.put("BuilderUtil", BuilderUtil.class);
		
		String content = generateContentString();
		
		switch (artifactType) {
		case JAVA:
			return new JavaClass(folderName, fileName, content, overwrite);
		case JSP:
			return new JspFile(folderName, fileName, content, overwrite);
		default:
			return null;
		}
	}
	
	/**
	 * 
	 */
	protected abstract void prepareContext();

	/**
	 * @return
	 */
	private String generateContentString() {
		VelocityEngine engine = new VelocityEngine();
		try {
			engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
			engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			
			engine.init();
			
			Template templateSource = engine.getTemplate(templateFilePath);
			StringWriter writer = new StringWriter();
			templateSource.merge(context, writer);
//			System.out.println(writer.toString());
			return writer.toString();

		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MethodInvocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}