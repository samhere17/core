package org.iq.ums;

/**
 * @author Sam
 * 
 */
public interface UmsConstants {

	public static final String UMS_SESSION_KEY = "umsSession";

	/**
	 * @author Sam
	 *
	 */
	public enum RoleStatus {
		INACTIVE(0), ACTIVE(1), DELETED(2);

		private final int status;

		private RoleStatus(int status) {
			this.status = status;
		}

		public int getRoleStatusValue() {
			return status;
		}

		public static RoleStatus getRoleStatus(int status) {
			RoleStatus returnStatus = null;
			for(RoleStatus thisStatus : RoleStatus.values()) {
				if(thisStatus.getRoleStatusValue() == status) {
					returnStatus = thisStatus;
					break;
				}
			}
			return returnStatus;
		}

		@Override
		public String toString() {
			switch(this) {
				case INACTIVE:
					return "Inactive";
				case ACTIVE:
					return "Active";
				case DELETED:
					return "Deleted";
				default:
					return "Unknown";
			}
		}
	}

	/**
	 * @author Sam
	 *
	 */
	public enum AreaSpecifier {
		SYSTEM(0), APPLICATION(1);

		private final int type;

		private AreaSpecifier(int type) {
			this.type = type;
		}

		public int getAreaSpecifierValue() {
			return type;
		}

		public static AreaSpecifier getAreaSpecifier(int type) {
			AreaSpecifier returnType = null;
			for(AreaSpecifier thisType : AreaSpecifier.values()) {
				if(thisType.getAreaSpecifierValue() == type) {
					returnType = thisType;
					break;
				}
			}
			return returnType;
		}

		@Override
		public String toString() {
			switch(this) {
				case SYSTEM:
					return "System";
				case APPLICATION:
					return "Application";
				default:
					return "Unknown";
			}
		}
	}

	/**
	 *
	 */
	public enum UserStatus {
		/**
		 * Status not known
		 */
		UNKNOWN(0),

		/**
		 * User has just registered
		 */
		NEW(1),

		/**
		 * User has verified email address
		 */
		VERIFIED(2),

		/**
		 * User has raised a join request. Approval is pending
		 */
		PENDING_APPROVAL(3),

		/**
		 * Request to join community has been accepted.
		 */
		ACTIVE(4),

		/**
		 * User has been deleted
		 */
		DELETED(5);

		/*
		 * , EXPIRING(9), EXPIRED(1), REJECTED(2), NOT_EFFECTIVE(4), DISABLED(8), NEVER_EXPIRED(0), CHECKED(0),
		 * WRONG_CREDENTIAL_TYPE(16)
		 */

		private final int userStat;

		UserStatus(int userStatus) {
			userStat = userStatus;
		}

		/**
		 * @return int
		 */
		public int getUserStatusValue() {
			return userStat;
		}

		/**
		 * @param status
		 * @return UserStatus
		 */
		public static UserStatus getUserStatus(int status) {
			UserStatus userStatus = null;
			for(UserStatus stat : UserStatus.values()) {
				if(stat.getUserStatusValue() == status) {
					userStatus = stat;
					break;
				}
			}
			return userStatus;
		}
	}

	/**
	 * 
	 */
	public enum Gender {
		UNKNOWN(-1), MALE(0), FEMALE(1), OTHER(2);

		private final int gender;

		Gender(int type) {
			gender = type;
		}

		public int getGenderValue() {
			return gender;
		}

		public static Gender getGender(int gender) {
			Gender returnGender = null;
			for(Gender thisGender : Gender.values()) {
				if(thisGender.getGenderValue() == gender) {
					returnGender = thisGender;
					break;
				}
			}
			return returnGender;
		}

		@Override
		public String toString() {
			switch(this) {
				case MALE:
					return "Male";
				case FEMALE:
					return "Female";
				case OTHER:
					return "Other";
				case UNKNOWN:
				default:
					return "Unknown";
			}
		}
	}

	/**
	 * 
	 */
	public enum SessionStatus {
		UNKNOWN(-1), INVALID(0), VALID(1);

		private final int sessionStatus;

		SessionStatus(int type) {
			sessionStatus = type;
		}

		public int getSessionStatusValue() {
			return sessionStatus;
		}

		public static SessionStatus getSessionStatus(int sessionStatus) {
			SessionStatus returnSessionStatus = null;
			for(SessionStatus thisSessionStatus : SessionStatus.values()) {
				if(thisSessionStatus.getSessionStatusValue() == sessionStatus) {
					returnSessionStatus = thisSessionStatus;
					break;
				}
			}
			return returnSessionStatus;
		}

		@Override
		public String toString() {
			switch(this) {
				case INVALID:
					return "Invalid";
				case VALID:
					return "Valid";
				case UNKNOWN:
				default:
					return "Unknown";
			}
		}
	}

	/**
	 * Option status
	 */
	public enum OptionStatus {
		INACTIVE(0), ACTIVE(1), DELETED(2);

		private final int optionStatus;

		OptionStatus(int type) {
			optionStatus = type;
		}

		public int getOptionStatusValue() {
			return optionStatus;
		}

		public static OptionStatus getOptionStatus(int optionStatus) {
			OptionStatus returnOptionStatus = null;
			for(OptionStatus thisOptionStatus : OptionStatus.values()) {
				if(thisOptionStatus.getOptionStatusValue() == optionStatus) {
					returnOptionStatus = thisOptionStatus;
					break;
				}
			}
			return returnOptionStatus;
		}

		@Override
		public String toString() {
			switch(this) {
				case INACTIVE:
					return "Inactive";
				case ACTIVE:
					return "Active";
				case DELETED:
					return "Deleted";
				default:
					return "Unknown";
			}
		}
	}

	/**
	 * OptionType
	 */
	public enum OptionType {
		MENU(0), MENU_ITEM(1), SEPERATOR(2);

		private final int optionType;

		OptionType(int type) {
			optionType = type;
		}

		public int getOptionTypeValue() {
			return optionType;
		}

		public static OptionType getOptionType(int optionType) {
			OptionType returnOptionType = null;
			for(OptionType thisOptionType : OptionType.values()) {
				if(thisOptionType.getOptionTypeValue() == optionType) {
					returnOptionType = thisOptionType;
					break;
				}
			}
			return returnOptionType;
		}

		@Override
		public String toString() {
			switch(this) {
				case MENU:
					return "Menu";
				case MENU_ITEM:
					return "Menu Item";
				case SEPERATOR:
					return "Seperator";
				default:
					return "Unknown";
			}
		}
	}

	public enum UserType {
		SYSTEM_USER(0), APPLICATION_USER(1);

		private final int userType;

		UserType(int type) {
			userType = type;
		}

		public int getUerTypeValue() {
			return userType;
		}

		public static UserType getUserType(int userType) {
			UserType returnUserType = null;
			for(UserType thisUserType : UserType.values()) {
				if(thisUserType.getUerTypeValue() == userType) {
					returnUserType = thisUserType;
					break;
				}
			}
			return returnUserType;
		}

		@Override
		public String toString() {
			switch(this) {
				case SYSTEM_USER:
					return "System";
				case APPLICATION_USER:
					return "Application";
				default:
					return "Unknown";
			}
		}
	}
}
