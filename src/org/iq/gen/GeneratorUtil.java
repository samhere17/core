/**
 * 
 */
package org.iq.gen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.iq.exception.UtilityException;
import org.iq.gen.artifact.Artifact;

/**
 * @author Sam
 *
 */
public class GeneratorUtil {

	public static final String lineSeparator = System.getProperty("line.separator");

	/**
	 * @param object
	 * @return String
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String getJson(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	public static String getPrettyJson(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
	}

	/**
	 * @param json
	 * @param inputClass
	 * @return Object
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Object getObject(String json, Class<?> inputClass)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, inputClass);
	}

	/**
	 * Returns true if <code>inputString</code> is null or length of
	 * <code>inputString</code> is 0
	 * 
	 * @param inputString
	 *          <code>String</code> to be checked
	 * @return boolean
	 */
	public static boolean isEmpty(String inputString) {
		return inputString == null ? true
				: inputString.trim().length() == 0 ? true : false;
	}

	/**
	 * @param inputFile
	 * @return String
	 * @throws UtilityException
	 */
	public static String getFileContent(File inputFile) throws UtilityException {
		StringBuffer stringBuffer = new StringBuffer();
		try {
			FileInputStream fstream = new FileInputStream(inputFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			if (br != null) {
				String strLine;
				while ((strLine = br.readLine()) != null) {
					stringBuffer.append(strLine);
					stringBuffer.append(lineSeparator);
				}
			}
			in.close();
		} catch (IOException e) {
			throw new UtilityException("Error reading file content as string", e);
		}
		return stringBuffer.toString();
	}

	/**
	 * @param fileName
	 * @param content
	 * @throws IOException
	 */
	public static void createFile(String fileName, String content) throws IOException {
		createFile(fileName, content, false);
	}

	/**
	 * @param fileName
	 * @param content
	 * @throws IOException
	 */
	public static void createFile(String fileName, String content, boolean overwrite) throws IOException {
		if (fileName != null && isFilenameValid(fileName) && content != null) {
			File file = new File(fileName);
			if (overwrite) {
				file.delete();
			}
			
			if(file.getParentFile().exists() == false)
				file.getParentFile().mkdirs();
			
			boolean exist = file.createNewFile();
			if (!exist) {
				System.out.println("File already exists.");
				return;
			}
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(content);
			out.close();
		}
	}

	/**
	 * @param fileName
	 * @return boolean
	 */
	public static boolean isFilenameValid(String fileName) {
		if (fileName != null) {
			File f = new File(fileName);
			try {
				f.getCanonicalPath();
				return true;
			} catch (IOException e) {
				System.out.println("Not a valid filename.");
				return false;
			}
		}
		return false;
	}

	/**
	 * @param name
	 * @return String
	 */
	public static String getJspFilename(String name) {
		name = name.replace(" ", "-");
		return name.toLowerCase()+Artifact.JSP_EXT;
	}
	
	/**
	 * @param name
	 * @param suffix 
	 * @return String
	 */
	public static String getJavaFilename(String name) {
		return getJavaFilename(name, null);
	}
	
	/**
	 * @param name
	 * @param suffix 
	 * @return String
	 */
	public static String getJavaFilename(String name, String suffix) {
		return toCamelCase(name) + (isEmpty(suffix) ? "" : suffix) + Artifact.JAVA_EXT;
	}
	
	/**
	 * @param in
	 * @return String
	 */
	public static String toCamelCase(String in) {
		StringBuilder sb = new StringBuilder();
		for( String oneString : in.trim().split(" ") )
		{
		    sb.append( oneString.substring(0,1) );
		    sb.append( oneString.substring(1).toLowerCase() );
		}
		return sb.toString();
	}

	/**
	 * @param in
	 * @return
	 */
	public static String upperFirstLetter(String in) {
		return in.substring(0, 1).toUpperCase() + in.substring(1);
	}

	/**
	 * @param in
	 * @return
	 */
	public static String lowerFirstLetter(String in) {
		return in.substring(0, 1).toLowerCase() + in.substring(1);
	}
}