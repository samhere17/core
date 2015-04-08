package org.iq.validation;

public interface ValidationConstants {

	/**
	 *
	 */
	public enum MessageLevel {

		/**
		 * 
		 */
		INFO("-iq-info"),
		/**
		 * 
		 */
		WARN("-iq-warning"),
		/**
		 * 
		 */
		ERROR("-iq-error");

		private final String msgLevel;

		MessageLevel(String msgLevel) {
			this.msgLevel = msgLevel;
		}

		/**
		 * @return String
		 */
		public String getMessageLevelString() {
			return msgLevel;
		}

		/**
		 * @param level
		 * @return MessageLevel
		 */
		public static MessageLevel getMessageLevel(String level) {
			MessageLevel msgLevel = null;
			for (MessageLevel thisLevel : MessageLevel.values()) {
				if (thisLevel.getMessageLevelString().equals(level)) {
					msgLevel = thisLevel;
					break;
				}
			}
			return msgLevel;
		}

		@Override
		public String toString() {
			return msgLevel;
		}
	}
}
