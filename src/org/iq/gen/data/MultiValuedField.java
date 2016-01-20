package org.iq.gen.data;

/**
 * @author Sam
 *
 */
public class MultiValuedField extends Field {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8046165551370209642L;
	
	/**
	 * 
	 */
	private String[] values;

	/**
	 * @return
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * @param values
	 */
	public void setValues(String[] values) {
		this.values = values;
	}
}
