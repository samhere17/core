package org.iq.gen.constants;

public enum GridColumnType {

	CONTENT, OFFSET;

	@Override
	public String toString() {
		switch (this) {
		case CONTENT:
			return "Content";
		case OFFSET:
			return "Offset";
		default:
			return "Unknown";
		}
	}

	public String getDenoter() {
		switch (this) {
		case CONTENT:
			return "";
		case OFFSET:
			return "offset";
		default:
			return "";
		}
	}
}
