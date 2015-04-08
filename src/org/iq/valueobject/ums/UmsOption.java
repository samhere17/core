package org.iq.valueobject.ums;

import java.util.ArrayList;
import java.util.List;

import org.iq.UmsConstants.OptionStatus;
import org.iq.UmsConstants.OptionType;
import org.iq.util.StringUtil;
import org.iq.valueobject.BaseVO;

public class UmsOption extends BaseVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6803282411879518086L;

	private int optionId;
	private String optionName;
	private String optionDescription;
//	private AreaSpecifier areaSpecifier;
	private OptionType optionType;
	private OptionStatus optionStatus;
	private String optionLink;
	private String optionImageLink;
	private String optionImageAlt;
	private int optionOrder;
	private int parentOptionId;
	private boolean enableToolbox;
	private String objectReferenceKey;
	private List<UmsOption> childOptions;
	
	/*private String menuItemName = null;
	private String menuItemTitle = null;
	private String menuItemLink = null;
	private String menuItemImageLink = null;
	private String menuItemImageAlt = null;*/
	private boolean menuItemSeparator = false;
	private boolean menuItemEnabled = false;
//	private boolean menuItemToolItem = false;


	/**
	 * @return the optionId
	 */
	public int getOptionId() {
		return optionId;
	}

	/**
	 * @param optionId
	 *            the optionId to set
	 */
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	/**
	 * @return the optionName
	 */
	public String getOptionName() {
		return optionName;
	}

	/**
	 * @param optionName
	 *            the optionName to set
	 */
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	/**
	 * @return the optionStatus
	 */
	public OptionStatus getOptionStatus() {
		return optionStatus;
	}

	/**
	 * @return the optionStatus
	 */
	public int getOptionStatusValue() {
		return optionStatus.getOptionStatusValue();
	}

	/**
	 * @param optionStatus
	 *            the optionStatus to set
	 */
	public void setOptionStatus(OptionStatus optionStatus) {
		this.optionStatus = optionStatus;
	}

	/**
	 * @param optionStatus
	 *            the optionStatus to set
	 */
	public void setOptionStatus(int optionStatusValue) {
		this.optionStatus = OptionStatus.getOptionStatus(optionStatusValue);
	}

	/**
	 * @return the optionLink
	 */
	public String getOptionLink() {
		return optionLink;
	}

	/**
	 * @param optionLink
	 *            the optionLink to set
	 */
	public void setOptionLink(String optionLink) {
		this.optionLink = optionLink;
	}

	/**
	 * @return the optionImageLink
	 */
	public String getOptionImageLink() {
		return optionImageLink;
	}

	/**
	 * @param optionImageLink
	 *            the optionImageLink to set
	 */
	public void setOptionImageLink(String optionImageLink) {
		this.optionImageLink = optionImageLink;
	}

	/**
	 * @return the optionOrder
	 */
	public int getOptionOrder() {
		return optionOrder;
	}

	/**
	 * @param optionOrder
	 *            the optionOrder to set
	 */
	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	/**
	 * @return the parentOptionId
	 */
	public int getParentOptionId() {
		return parentOptionId;
	}

	/**
	 * @param parentOptionId
	 *            the parentOptionId to set
	 */
	public void setParentOptionId(int parentOptionId) {
		this.parentOptionId = parentOptionId;
	}

	/**
	 * @return the optionDescription
	 */
	public String getOptionDescription() {
		return optionDescription;
	}

	/**
	 * @param optionDescription
	 *            the optionDescription to set
	 */
	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	/**
	 * @return the optionType
	 */
	public OptionType getOptionType() {
		return optionType;
	}

	/**
	 * @param optionType
	 *            the optionType to set
	 */
	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
		switch (this.optionType) {
		case SEPERATOR:
			this.menuItemSeparator = true;
			break;
		case MENU:
		case MENU_ITEM:
		default:
			this.menuItemSeparator = false;
			break;
		}
	}

	/**
	 * @param optionType
	 *            the optionType to set
	 */
	public void setOptionType(int optionTypeValue) {
		this.setOptionType(OptionType.getOptionType(optionTypeValue));
	}

	/**
	 * @return the optionImageAlt
	 */
	public String getOptionImageAlt() {
		return optionImageAlt;
	}

	/**
	 * @param optionImageAlt
	 *            the optionImageAlt to set
	 */
	public void setOptionImageAlt(String optionImageAlt) {
		this.optionImageAlt = optionImageAlt;
	}

	/**
	 * @return the enableToolbox
	 */
	public boolean isEnableToolbox() {
		return enableToolbox;
	}

	/**
	 * @param enableToolbox
	 *            the enableToolbox to set
	 */
	public void setEnableToolbox(boolean enableToolbox) {
		this.enableToolbox = enableToolbox;
	}
/*
	*//**
	 * @return the areaSpecifier
	 *//*
	public AreaSpecifier getAreaSpecifier() {
		return areaSpecifier;
	}

	*//**
	 * @param areaSpecifier
	 *            the areaSpecifier to set
	 *//*
	public void setAreaSpecifier(AreaSpecifier areaSpecifier) {
		this.areaSpecifier = areaSpecifier;
	}

	*//**
	 * @param areaSpecifier
	 *            the areaSpecifier to set
	 *//*
	public void setAreaSpecifier(int areaSpecifierValue) {
		this.areaSpecifier = AreaSpecifier.getAreaSpecifier(areaSpecifierValue);
	}
	
*/	

	/**
	 * @return the objectReferenceKey
	 */
	public String getObjectReferenceKey() {
		return objectReferenceKey;
	}

	/**
	 * @param objectReferenceKey the objectReferenceKey to set
	 */
	public void setObjectReferenceKey(String objectReferenceKey) {
		this.objectReferenceKey = objectReferenceKey;
	}

	/**
	 * @return the childOptions
	 */
	public List<UmsOption> getChildOptions() {
		return childOptions;
	}

	/**
	 * @param childOptions
	 *            the childOptions to set
	 */
	public void setChildOptions(List<UmsOption> childOptions) {
		this.childOptions = childOptions;
	}

	public void addChildOption(UmsOption thisChildOption) {
		if (this.childOptions == null) {
			this.childOptions = new ArrayList<UmsOption>();
		}
		this.childOptions.add(thisChildOption);
	}
	
	
	
	/**
	 * @return the menuItemEnabled
	 */
	public boolean isMenuItemEnabled() {
		return menuItemEnabled;
	}

	/**
	 * @param menuItemEnabled the menuItemEnabled to set
	 */
	public void setMenuItemEnabled(boolean menuItemEnabled) {
		this.menuItemEnabled = menuItemEnabled;
	}

	/**
	 * @return the menuItemSeparator
	 */
	public boolean isMenuItemSeparator() {
		return menuItemSeparator;
	}

	/**
	 * @return the menuItemToolItem
	 */
	public boolean isMenuItemToolItem() {
		return (enableToolbox == true && (OptionType.SEPERATOR
				.equals(optionType) == false));
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("UmsOptions=[" + StringUtil.lineSeparator);
		buffer.append("    optionId=" + optionId + StringUtil.lineSeparator);
		buffer.append("    optionName=" + optionName + StringUtil.lineSeparator);
		buffer.append("    optionDescription=" + optionDescription
				+ StringUtil.lineSeparator);
		buffer.append("    optionType=" + optionType + "(Value:"
				+ optionType.getOptionTypeValue() + ")"
				+ StringUtil.lineSeparator);
		buffer.append("    optionStatus=" + optionStatus + "(Value:"
				+ optionStatus.getOptionStatusValue() + ")"
				+ StringUtil.lineSeparator);
		buffer.append("    optionLink=" + optionLink + StringUtil.lineSeparator);
		buffer.append("    optionImageLink=" + optionImageLink
				+ StringUtil.lineSeparator);
		buffer.append("    optionImageAlt=" + optionImageAlt
				+ StringUtil.lineSeparator);
		buffer.append("    optionOrder=" + optionOrder
				+ StringUtil.lineSeparator);
		buffer.append("    parentOptionId=" + parentOptionId
				+ StringUtil.lineSeparator);
		buffer.append("    enableToolbox=" + enableToolbox
				+ StringUtil.lineSeparator);
		buffer.append("  ]");
		return buffer.toString();
	}
}