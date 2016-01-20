package org.iq.gen.constants;

public enum Method {
	GET(1), POST(2);

	private final int method;

	Method(int method) {
		this.method = method;
	}

	/**
	 * @return int
	 */
	public int getMethodValue() {
		return method;
	}

	/**
	 * @param methodValue
	 * @return Method
	 */
	public static Method getMethod(int methodValue) {
		Method method = null;
		for (Method thisMethod : Method.values()) {
			if (thisMethod.getMethodValue() == methodValue) {
				method = thisMethod;
				break;
			}
		}
		return method;
	}

	@Override
	public String toString() {
		switch (this) {
		case GET:
			return "get";
		case POST:
			return "post";
		default:
			return "post";
		}
	}
}