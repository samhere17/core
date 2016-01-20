package org.iq.gen.constants;

/**
 * This enum specifies DeviceTypes in relation to Bootstrap grid system.
 * <ul>
 * <li>xs - extra small - screen width < 768px</li>
 * <li>sm - small - 768px <= screen width < 992px</li>
 * <li>md - medium - 992px <= screen width < 1200px</li>
 * <li>lg - large - 1200px <= screen width</li>
 * </ul>
 * 
 * @author Sam
 *
 */
public enum DeviceType {

	EXTRA_SMALL, SMALL, MEDIUM, LARGE;

	@Override
	public String toString() {
		switch (this) {
		case EXTRA_SMALL:
			return "Extra Small";
		case SMALL:
			return "Small";
		case MEDIUM:
			return "Medium";
		case LARGE:
			return "Large";
		default:
			return "Unknown";
		}
	}

	public String getDenoter() {
		switch (this) {
		case EXTRA_SMALL:
			return "xs";
		case SMALL:
			return "sm";
		case MEDIUM:
			return "md";
		case LARGE:
			return "lg";
		default:
			return "md";
		}
	}
}