package org.iq;

/**
 * @author Sam
 * 
 */
public interface Constants {

	/**
	 *
	 */
	public enum OrganizationStatus {

		/**
		 * 
		 */
		UNKNOWN(0),
		/**
		 * 
		 */
		NEW(1),
		/**
		 * 
		 */
		ACTIVE(2)/*
				 * , EXPIRING(9), EXPIRED(1), REJECTED(2), NOT_EFFECTIVE(4),
				 * DISABLED(8), NEVER_EXPIRED(0), CHECKED(0),
				 * WRONG_CREDENTIAL_TYPE(16)
				 */;

		private final int organizationStatus;

		OrganizationStatus(int organizationStatus) {
			this.organizationStatus = organizationStatus;
		}

		/**
		 * @return int
		 */
		public int getOrganizationStatusValue() {
			return organizationStatus;
		}

		/**
		 * @param status
		 * @return UserStatus
		 */
		public static OrganizationStatus getOrganizationStatus(int status) {
			OrganizationStatus orgStatus = null;
			for (OrganizationStatus stat : OrganizationStatus.values()) {
				if (stat.getOrganizationStatusValue() == status) {
					orgStatus = stat;
					break;
				}
			}
			return orgStatus;
		}

		@Override
		public String toString() {
			switch (this) {
			case NEW:
				return "New";
			case ACTIVE:
				return "Active";
			case UNKNOWN:
			default:
				return "Unknown";
			}
		}
	}
}