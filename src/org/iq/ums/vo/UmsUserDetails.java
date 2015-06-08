package org.iq.ums.vo;

import java.util.Date;

import org.iq.ums.UmsConstants.Gender;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsUserDetails extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1221541938109865849L;

	private int userId = 0;
	private String userFirstName = null;
	private String userLastName = null;
	private String userAlias = null;
	private String address = null;
	private String primaryPhone = null;
	private String primaryEmail = null;
	private String alternatePhone = null;
	private String alternateEmail = null;
	private Gender gender = null;
	private Date dateOfBirth = null;
	private Date anniversary = null;

	/**
	 * 
	 */
	public UmsUserDetails() {

	}

	/**
	 * @param userId
	 * @param userFirstName
	 * @param userLastName
	 * @param userAlias
	 * @param primaryPhone
	 * @param primaryEmail
	 * @param alternatePhone
	 * @param alternateEmail
	 * @param gender
	 * @param dateOfBirth
	 * @param anniversary
	 */
	public UmsUserDetails(int userId, String userFirstName,
			String userLastName, String userAlias, String address , String primaryPhone,
			String primaryEmail, String alternatePhone, String alternateEmail,
			Gender gender, Date dateOfBirth, Date anniversary) {
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAlias = userAlias;
		this.address = address;
		this.primaryPhone = primaryPhone;
		this.primaryEmail = primaryEmail;
		this.alternatePhone = alternatePhone;
		this.alternateEmail = alternateEmail;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.anniversary = anniversary;
	}

	
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * @return the userAlias
	 */
	public String getUserAlias() {
		return userAlias;
	}

	/**
	 * @param userAlias the userAlias to set
	 */
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the primaryPhone
	 */
	public String getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * @param primaryPhone the primaryPhone to set
	 */
	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * @return the primaryEmail
	 */
	public String getPrimaryEmail() {
		return primaryEmail;
	}

	/**
	 * @param primaryEmail the primaryEmail to set
	 */
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	/**
	 * @return the alternatePhone
	 */
	public String getAlternatePhone() {
		return alternatePhone;
	}

	/**
	 * @param alternatePhone the alternatePhone to set
	 */
	public void setAlternatePhone(String alternatePhone) {
		this.alternatePhone = alternatePhone;
	}

	/**
	 * @return the alternateEmail
	 */
	public String getAlternateEmail() {
		return alternateEmail;
	}

	/**
	 * @param alternateEmail the alternateEmail to set
	 */
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public void setGenderValue(int genderValue) {
		this.gender = Gender.getGender(genderValue);
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the anniversary
	 */
	public Date getAnniversary() {
		return anniversary;
	}

	/**
	 * @param anniversary the anniversary to set
	 */
	public void setAnniversary(Date anniversary) {
		this.anniversary = anniversary;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsUserDetails=[" + StringUtil.lineSeparator);
		buffer.append("    userId=" + userId + StringUtil.lineSeparator);
		buffer.append("    userFirstName=" + userFirstName
				+ StringUtil.lineSeparator);
		buffer.append("    userLastName=" + userLastName + StringUtil.lineSeparator);
		buffer.append("    userAlias=" + userAlias + StringUtil.lineSeparator);
		buffer.append("    address=" + address + StringUtil.lineSeparator);
		buffer.append("    dateOfBirth=" + dateOfBirth
				+ StringUtil.lineSeparator);
		buffer.append("    gender=" + gender.toString() + "(Value:"
				+ gender.getGenderValue() + StringUtil.lineSeparator);
		buffer.append("    primary email = " + primaryEmail
				+ StringUtil.lineSeparator);
		buffer.append("    alternateEmail = " + alternateEmail
				+ StringUtil.lineSeparator);
		buffer.append("    mobileNumber=" + primaryPhone
				+ StringUtil.lineSeparator);
		buffer.append("    alternatePhone =" + alternatePhone
				+ StringUtil.lineSeparator);
		buffer.append("    anniversary =" + anniversary
				+ StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}