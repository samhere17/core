package org.iq.valueobject.organization;

import java.util.Date;

import org.iq.Constants.OrganizationStatus;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class Organization extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3381602936646286083L;

	private int organizationId;
	private String organizationName;
	private String organizationAlias;
	private String organizationAddress1;
	private String organizationAddress2;
	private String organizationCity;
	private String organizationDistrict;
	private String organizationState;
	private String organizationCountry;
	private String organizationPin;
	private String organizationPrimaryPhone;
	private String organizationPrimaryFax;
	private String organizationPrimaryEmail;
	private String organizationAlternatePhone;
	private String organizationAlternateFax;
	private String organizationAlternateEmail;
	private OrganizationStatus organizationStatus;
	private Date organizationCreation;
	private int organizationCreatedBy;
	private String organizationCreatedByName;
	private Date organizationUpdated;
	private int organizationUpdatedBy;
	private String organizationUpdatedByName;

	/**
	 * @return the organizationId
	 */
	public int getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId
	 *            the organizationId to set
	 */
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName
	 *            the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the organizationAlias
	 */
	public String getOrganizationAlias() {
		return organizationAlias;
	}

	/**
	 * @param organizationAlias
	 *            the organizationAlias to set
	 */
	public void setOrganizationAlias(String organizationAlias) {
		this.organizationAlias = organizationAlias;
	}

	/**
	 * @return the organizationAddress1
	 */
	public String getOrganizationAddress1() {
		return organizationAddress1;
	}

	/**
	 * @param organizationAddress1
	 *            the organizationAddress1 to set
	 */
	public void setOrganizationAddress1(String organizationAddress1) {
		this.organizationAddress1 = organizationAddress1;
	}

	/**
	 * @return the organizationAddress2
	 */
	public String getOrganizationAddress2() {
		return organizationAddress2;
	}

	/**
	 * @param organizationAddress2
	 *            the organizationAddress2 to set
	 */
	public void setOrganizationAddress2(String organizationAddress2) {
		this.organizationAddress2 = organizationAddress2;
	}

	/**
	 * @return the organizationCity
	 */
	public String getOrganizationCity() {
		return organizationCity;
	}

	/**
	 * @param organizationCity
	 *            the organizationCity to set
	 */
	public void setOrganizationCity(String organizationCity) {
		this.organizationCity = organizationCity;
	}

	/**
	 * @return the organizationDistrict
	 */
	public String getOrganizationDistrict() {
		return organizationDistrict;
	}

	/**
	 * @param organizationDistrict
	 *            the organizationDistrict to set
	 */
	public void setOrganizationDistrict(String organizationDistrict) {
		this.organizationDistrict = organizationDistrict;
	}

	/**
	 * @return the organizationState
	 */
	public String getOrganizationState() {
		return organizationState;
	}

	/**
	 * @param organizationState
	 *            the organizationState to set
	 */
	public void setOrganizationState(String organizationState) {
		this.organizationState = organizationState;
	}

	/**
	 * @return the organizationCountry
	 */
	public String getOrganizationCountry() {
		return organizationCountry;
	}

	/**
	 * @param organizationCountry
	 *            the organizationCountry to set
	 */
	public void setOrganizationCountry(String organizationCountry) {
		this.organizationCountry = organizationCountry;
	}

	/**
	 * @return the organizationPin
	 */
	public String getOrganizationPin() {
		return organizationPin;
	}

	/**
	 * @param organizationPin
	 *            the organizationPin to set
	 */
	public void setOrganizationPin(String organizationPin) {
		this.organizationPin = organizationPin;
	}

	/**
	 * @return the organizationPrimaryPhone
	 */
	public String getOrganizationPrimaryPhone() {
		return organizationPrimaryPhone;
	}

	/**
	 * @param organizationPrimaryPhone
	 *            the organizationPrimaryPhone to set
	 */
	public void setOrganizationPrimaryPhone(String organizationPrimaryPhone) {
		this.organizationPrimaryPhone = organizationPrimaryPhone;
	}

	/**
	 * @return the organizationPrimaryFax
	 */
	public String getOrganizationPrimaryFax() {
		return organizationPrimaryFax;
	}

	/**
	 * @param organizationPrimaryFax
	 *            the organizationPrimaryFax to set
	 */
	public void setOrganizationPrimaryFax(String organizationPrimaryFax) {
		this.organizationPrimaryFax = organizationPrimaryFax;
	}

	/**
	 * @return the organizationPrimaryEmail
	 */
	public String getOrganizationPrimaryEmail() {
		return organizationPrimaryEmail;
	}

	/**
	 * @param organizationPrimaryEmail
	 *            the organizationPrimaryEmail to set
	 */
	public void setOrganizationPrimaryEmail(String organizationPrimaryEmail) {
		this.organizationPrimaryEmail = organizationPrimaryEmail;
	}

	/**
	 * @return the organizationAlternatePhone
	 */
	public String getOrganizationAlternatePhone() {
		return organizationAlternatePhone;
	}

	/**
	 * @param organizationAlternatePhone
	 *            the organizationAlternatePhone to set
	 */
	public void setOrganizationAlternatePhone(String organizationAlternatePhone) {
		this.organizationAlternatePhone = organizationAlternatePhone;
	}

	/**
	 * @return the organizationAlternateFax
	 */
	public String getOrganizationAlternateFax() {
		return organizationAlternateFax;
	}

	/**
	 * @param organizationAlternateFax
	 *            the organizationAlternateFax to set
	 */
	public void setOrganizationAlternateFax(String organizationAlternateFax) {
		this.organizationAlternateFax = organizationAlternateFax;
	}

	/**
	 * @return the organizationAlternateEmail
	 */
	public String getOrganizationAlternateEmail() {
		return organizationAlternateEmail;
	}

	/**
	 * @param organizationAlternateEmail
	 *            the organizationAlternateEmail to set
	 */
	public void setOrganizationAlternateEmail(String organizationAlternateEmail) {
		this.organizationAlternateEmail = organizationAlternateEmail;
	}

	/**
	 * @return the organizationStatus
	 */
	public OrganizationStatus getOrganizationStatus() {
		return organizationStatus;
	}

	/**
	 * @param organizationStatus
	 *            the organizationStatus to set
	 */
	public void setOrganizationStatus(OrganizationStatus organizationStatus) {
		this.organizationStatus = organizationStatus;
	}

	/**
	 * @param organizationStatusValue
	 *            the organizationStatus to set
	 */
	public void setOrganizationStatus(int organizationStatusValue) {
		this.organizationStatus = OrganizationStatus.getOrganizationStatus(organizationStatusValue);
	}

	/**
	 * @return the organizationCreation
	 */
	public Date getOrganizationCreation() {
		return organizationCreation;
	}

	/**
	 * @param organizationCreation
	 *            the organizationCreation to set
	 */
	public void setOrganizationCreation(Date organizationCreation) {
		this.organizationCreation = organizationCreation;
	}
	
	/**
	 * @return the organizationCreatedBy
	 */
	public int getOrganizationCreatedBy() {
		return organizationCreatedBy;
	}

	/**
	 * @param organizationCreatedBy the organizationCreatedBy to set
	 */
	public void setOrganizationCreatedBy(int organizationCreatedBy) {
		this.organizationCreatedBy = organizationCreatedBy;
	}

	/**
	 * @return the organizationCreatedByName
	 */
	public String getOrganizationCreatedByName() {
		return organizationCreatedByName;
	}

	/**
	 * @param organizationCreatedByName the organizationCreatedByName to set
	 */
	public void setOrganizationCreatedByName(String organizationCreatedByName) {
		this.organizationCreatedByName = organizationCreatedByName;
	}

	/**
	 * @return the organizationUpdated
	 */
	public Date getOrganizationUpdated() {
		return organizationUpdated;
	}

	/**
	 * @param organizationUpdated
	 *            the organizationUpdated to set
	 */
	public void setOrganizationUpdated(Date organizationUpdated) {
		this.organizationUpdated = organizationUpdated;
	}

	/**
	 * @return the organizationUpdatedBy
	 */
	public int getOrganizationUpdatedBy() {
		return organizationUpdatedBy;
	}

	/**
	 * @param organizationUpdatedBy
	 *            the organizationUpdatedBy to set
	 */
	public void setOrganizationUpdatedBy(int organizationUpdatedBy) {
		this.organizationUpdatedBy = organizationUpdatedBy;
	}
	
	/**
	 * @return the organizationUpdatedByName
	 */
	public String getOrganizationUpdatedByName() {
		return organizationUpdatedByName;
	}

	/**
	 * @param organizationUpdatedByName the organizationUpdatedByName to set
	 */
	public void setOrganizationUpdatedByName(String organizationUpdatedByName) {
		this.organizationUpdatedByName = organizationUpdatedByName;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Organization=[" + StringUtil.lineSeparator);
		buffer.append("    organizationId=" + organizationId + StringUtil.lineSeparator);
		buffer.append("    organizationName=" + organizationName + StringUtil.lineSeparator);
		buffer.append("    organizationAlias=" + organizationAlias + StringUtil.lineSeparator);
		buffer.append("    organizationAddress1=" + organizationAddress1 + StringUtil.lineSeparator);
		buffer.append("    organizationAddress2=" + organizationAddress2 + StringUtil.lineSeparator);
		buffer.append("    organizationCity=" + organizationCity + StringUtil.lineSeparator);
		buffer.append("    organizationDistrict=" + organizationDistrict + StringUtil.lineSeparator);
		buffer.append("    organizationState=" + organizationState + StringUtil.lineSeparator);
		buffer.append("    organizationCountry=" + organizationCountry + StringUtil.lineSeparator);
		buffer.append("    organizationPin=" + organizationPin + StringUtil.lineSeparator);
		buffer.append("    organizationPrimaryPhone=" + organizationPrimaryPhone + StringUtil.lineSeparator);
		buffer.append("    organizationPrimaryFax=" + organizationPrimaryFax+ StringUtil.lineSeparator);
		buffer.append("    organizationPrimaryEmail="+ organizationPrimaryEmail + StringUtil.lineSeparator);
		buffer.append("    organizationAlternatePhone=" + organizationAlternatePhone + StringUtil.lineSeparator);
		buffer.append("    organizationAlternateFax=" + organizationAlternateFax + StringUtil.lineSeparator);
		buffer.append("    organizationAlternateEmail="+ organizationAlternateEmail + StringUtil.lineSeparator);
		buffer.append("    organizationStatus=" + organizationStatus.toString()+ "(Value:" + organizationStatus.getOrganizationStatusValue() +")"+ StringUtil.lineSeparator);
		buffer.append("    organizationCreation=" + organizationCreation + StringUtil.lineSeparator);
		buffer.append("    organizationCreatedBy=" + organizationCreatedBy + StringUtil.lineSeparator);
		buffer.append("    organizationCreatedByName=" + organizationCreatedByName + StringUtil.lineSeparator);
		buffer.append("    organizationUpdated=" + organizationUpdated + StringUtil.lineSeparator);
		buffer.append("    organizationUpdatedBy=" + organizationUpdatedBy + StringUtil.lineSeparator);
		buffer.append("    organizationUpdatedByName=" + organizationUpdatedByName + StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}