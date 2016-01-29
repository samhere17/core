package org.iq.gen.constants;

public enum ActionType {
	REDIRECT(1), LAUNCH(2), SUBMIT(2);

	private final int actionType;

	ActionType(int actionType) {
		this.actionType = actionType;
	}

	/**
	 * @return int
	 */
	public int getActionTypeValue() {
		return actionType;
	}

	/**
	 * @param actionTypeValue
	 * @return
	 */
	public static ActionType getActionType(int actionTypeValue) {
		ActionType actionType = null;
		for (ActionType thisActionType : ActionType.values()) {
			if (thisActionType.getActionTypeValue() == actionTypeValue) {
				actionType = thisActionType;
				break;
			}
		}
		return actionType;
	}

	@Override
	public String toString() {
		switch (this) {
		case REDIRECT:
			return "REDIRECT";
		case LAUNCH:
			return "LAUNCH";
		case SUBMIT:
			return "SUBMIT";
		default:
			return "UNKNOWN";
		}
	}
}
