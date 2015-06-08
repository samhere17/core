package org.iq.ums.vo;

import java.util.Date;

import org.iq.ums.UmsConstants.AreaSpecifier;
import org.iq.ums.UmsConstants.RoleStatus;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsRole extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4634396180723180513L;

	private int roleId;
	private String roleName;
	private String roleDescription;
	private AreaSpecifier roleArea;
	private RoleStatus roleStatus;
	private String additionalId;
	private Date roleCreation;
	private int roleCreatedBy;
	private Date roleUpdated;
	private int roleUpdatedBy;

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDescription
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription
	 *            the roleDescription to set
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * @return the areaSpecifier
	 */
	public AreaSpecifier getRoleArea() {
		return roleArea;
	}

	/**
	 * @param areaSpecifier
	 *            the areaSpecifier to set
	 */
	public void setRoleArea(AreaSpecifier roleArea) {
		this.roleArea = roleArea;
	}

	/**
	 * @return the roleStatus
	 */
	public RoleStatus getRoleStatus() {
		return roleStatus;
	}

	/**
	 * @param roleStatus
	 *            the roleStatus to set
	 */
	public void setRoleStatus(RoleStatus roleStatus) {
		this.roleStatus = roleStatus;
	}

	/**
	 * @return the additionalId
	 */
	public String getAdditionalId() {
		return additionalId;
	}

	/**
	 * @param additionalId
	 *            the additionalId to set
	 */
	public void setAdditionalId(String additionalId) {
		this.additionalId = additionalId;
	}

	/**
	 * @return the roleCreation
	 */
	public Date getRoleCreation() {
		return roleCreation;
	}

	/**
	 * @param roleCreation
	 *            the roleCreation to set
	 */
	public void setRoleCreation(Date roleCreation) {
		this.roleCreation = roleCreation;
	}

	/**
	 * @return the roleCreatedBy
	 */
	public int getRoleCreatedBy() {
		return roleCreatedBy;
	}

	/**
	 * @param roleCreatedBy
	 *            the roleCreatedBy to set
	 */
	public void setRoleCreatedBy(int roleCreatedBy) {
		this.roleCreatedBy = roleCreatedBy;
	}

	/**
	 * @return the roleUpdated
	 */
	public Date getRoleUpdated() {
		return roleUpdated;
	}

	/**
	 * @param roleUpdated
	 *            the roleUpdated to set
	 */
	public void setRoleUpdated(Date roleUpdated) {
		this.roleUpdated = roleUpdated;
	}

	/**
	 * @return the roleUpdatedBy
	 */
	public int getRoleUpdatedBy() {
		return roleUpdatedBy;
	}

	/**
	 * @param roleUpdatedBy
	 *            the roleUpdatedBy to set
	 */
	public void setRoleUpdatedBy(int roleUpdatedBy) {
		this.roleUpdatedBy = roleUpdatedBy;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsRole=[" + StringUtil.lineSeparator);
		buffer.append("    roleId=" + roleId + StringUtil.lineSeparator);
		buffer.append("    roleName=" + roleName + StringUtil.lineSeparator);
		buffer.append("    roleDescription=" + roleDescription
				+ StringUtil.lineSeparator);
		buffer.append("    roleArea=" + roleArea.toString()
				+ "(Value:" + roleArea.getAreaSpecifierValue() + ")"
				+ StringUtil.lineSeparator);
		buffer.append("    roleStatus=" + roleStatus.toString() + "(Value:"
				+ roleStatus.getRoleStatusValue() + ")"
				+ StringUtil.lineSeparator);
		buffer.append("    additionalId=" + additionalId
				+ StringUtil.lineSeparator);
		buffer.append("    roleCreation=" + roleCreation
				+ StringUtil.lineSeparator);
		buffer.append("    roleCreatedBy=" + roleCreatedBy
				+ StringUtil.lineSeparator);
		buffer.append("    roleUpdated=" + roleUpdated
				+ StringUtil.lineSeparator);
		buffer.append("    roleUpdatedBy=" + roleUpdatedBy
				+ StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}