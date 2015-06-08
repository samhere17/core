package org.iq.ums.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.ums.UmsConstants.OptionStatus;
import org.iq.ums.dao.UmsOptionDao;
import org.iq.ums.dao.impl.UmsOptionDaoImpl;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.vo.UmsOption;
import org.iq.util.StringUtil;

public class UmsOptionHelper extends BaseHelper {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3725430657335455971L;

	public UmsOptionHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

/*	public List<UmsOption> getAllOptions() throws DbException {
		// Fetching option details
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		return umsOptionsDao.getAllOptions();
	}

	public List<UmsOption> getOptionsList(String listType) throws DbException {
		// Fetching option details
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		if (ALL_OPTIONS.equals(listType)) {
			return umsOptionsDao.getAllOptions();
		} else if (ACTIVE_OPTIONS.equals(listType)) {
			return umsOptionsDao.getActiveOptions();
		} else if (PARENT_OPTIONS.equals(listType)) {
			return umsOptionsDao.getParentOptions();
		}else {
			return umsOptionsDao.getAllOptions();
		}
	}

	public UmsOption getOptionById(String optionId) throws DbException {
		// Fetching option details
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		return umsOptionsDao.getOptionByOptionId(optionId);
	}

	public int updateOption(int optionId, String optionName, int optionStatus, String optionLink,
			String optionImageLink, int parentOptionId, int optionOrder) {
		
		// preparing data before hitting UmsOptions DAO layer
		UmsOption umsOption = new UmsOption();
		umsOption.setOptionId(optionId);
		umsOption.setOptionName(optionName);
		umsOption.setOptionStatus(OptionStatus.getOptionStatus(optionStatus));
		umsOption.setOptionLink(optionLink);
		umsOption.setOptionImageLink(optionImageLink);
		umsOption.setParentOptionId(parentOptionId);
		umsOption.setOptionOrder(optionOrder);

		//hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.updateOption(umsOption);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
*/

	public int deleteOption(int optionId) throws BusinessException {

		// preparing data before hitting UmsOptions DAO layer
		UmsOption umsOption = new UmsOption();
		umsOption.setOptionId(optionId);

		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.delete(umsOption);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public int insertOption(String optionName, int optionStatus, String optionLink,
			String optionImageLink, int parentOptionId, int optionOrder) throws BusinessException {
		
		// preparing data before hitting UmsOptions DAO layer
		UmsOption umsOption = new UmsOption();
		umsOption.setOptionName(optionName);
		umsOption.setOptionStatus(OptionStatus.getOptionStatus(optionStatus));
		umsOption.setOptionLink(optionLink);
		umsOption.setOptionImageLink(optionImageLink);
		umsOption.setParentOptionId(parentOptionId);
		umsOption.setOptionOrder(optionOrder);

		//hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.insert(umsOption);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}


	public List<UmsOption> getParentOptions() throws BusinessException {
		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionDao.selectParentOptions();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public List<UmsOption> getParentAppOptions() throws BusinessException {
		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionDao.selectParentAppOptions();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public List<UmsOption> getActiveParentOptions() throws BusinessException {
		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionDao.selectActiveParentOptions();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public List<UmsOption> getOptionsByParentId(int parentOptionId)
			throws BusinessException {
		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.selectByParentId(parentOptionId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
	
	public List<UmsOption> getActiveOptionsByParentId(int parentOptionId)
			throws BusinessException {
		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.selectActiveByParentId(parentOptionId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
	
	/**
	 * @param roleId
	 * @param sessionMap
	 * @return List<UmsOption>
	 * @throws BusinessException 
	 */
	public List<UmsOption> getOptionsForMenu(int roleId,
			HashMap<String, Object> sessionMap) throws BusinessException {
		
		List<UmsOption> retOptions = new ArrayList<UmsOption>();

		List<UmsOption> parentOptions = getActiveParentOptions();
		if (parentOptions != null && parentOptions.size() > 0) {
			UmsRoleHelper umsRoleHelper = new UmsRoleHelper();
			Map<Integer, Boolean> optionsMap = umsRoleHelper.getOptionsMap(roleId);
			for (UmsOption umsParentOption : parentOptions) {
				// checking for role
				if (optionsMap != null && optionsMap.get(umsParentOption.getOptionId()) != null
						&& optionsMap.get(umsParentOption.getOptionId())) {
					List<UmsOption> umsChildOptions = getActiveOptionsByParentId(umsParentOption
							.getOptionId());
					if (umsChildOptions != null && umsChildOptions.size() > 0) {
						for (UmsOption thisChildOption : umsChildOptions) {
							// checking for role
							if (/*optionsMap != null && */optionsMap.get(thisChildOption.getOptionId()) != null
									&& optionsMap.get(thisChildOption.getOptionId())) {
								thisChildOption.setMenuItemEnabled(true);
								// checking for session object availability
								if (StringUtil.isEmpty(thisChildOption.getObjectReferenceKey()) == false) {
									thisChildOption.setMenuItemEnabled(false);
									if (sessionMap.containsKey(thisChildOption.getObjectReferenceKey())) {
										thisChildOption.setMenuItemEnabled(true);
									}
								}
							}
							umsParentOption.addChildOption(thisChildOption);
						}
					}
					retOptions.add(umsParentOption);
				}
			}
		}
		return retOptions;
	}

	/**
	 * @param optionName
	 * @param optionDescription
	 * @param optionTypeValue
	 * @param optionStatusValue
	 * @param optionOrder
	 * @param enableToolbox
	 * @param optionLink
	 * @param optionImageLink
	 * @param optionImageAlt
	 * @param objectReferenceKey
	 * @param parentOptionId
	 * @return int
	 * @throws BusinessException
	 */
	public int createOption(String optionName, String optionDescription,
			int optionTypeValue, int optionStatusValue, int optionOrder,
			boolean enableToolbox, String optionLink, String optionImageLink,
			String optionImageAlt, String objectReferenceKey, int parentOptionId)
			throws BusinessException {

		// TODO Need to validate the input first

		UmsOption option = new UmsOption();

		option.setOptionName(optionName);
		option.setOptionDescription(optionDescription);
		option.setOptionType(optionTypeValue);
		option.setOptionStatus(optionStatusValue);
		option.setOptionOrder(optionOrder);
		option.setEnableToolbox(enableToolbox);
		option.setOptionLink(optionLink);
		option.setOptionImageLink(optionImageLink);
		option.setOptionImageAlt(optionImageAlt);
		option.setObjectReferenceKey(objectReferenceKey);
		option.setParentOptionId(parentOptionId);

		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionDao.insertAndGetID(option);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	/**
	 * @param optionId
	 * @return
	 * @throws BusinessException
	 */
	public UmsOption getOption(int optionId) throws BusinessException {
		UmsOptionDao umsOptionDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionDao.selectByOptionId(optionId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
	
	/**
	 * @return List<UmsOption>
	 * @throws BusinessException 
	 */
	public List<UmsOption> getAllOptions() throws BusinessException {
		List<UmsOption> parentOptions = getParentOptions();
		if (parentOptions != null && parentOptions.size() > 0) {
			for (UmsOption umsParentOption : parentOptions) {
				List<UmsOption> umsChildOptions = getOptionsByParentId(umsParentOption
						.getOptionId());
				if (umsChildOptions != null && umsChildOptions.size() > 0) {
					for (UmsOption thisChildOption : umsChildOptions) {
						umsParentOption.addChildOption(thisChildOption);
					}
				}
			}
		}
		return parentOptions;
	}

	/**
	 * @return List<UmsOption>
	 * @throws BusinessException 
	 */
	public List<UmsOption> getAppOptions() throws BusinessException {
		List<UmsOption> parentOptions = getParentAppOptions();
		if (parentOptions != null && parentOptions.size() > 0) {
			for (UmsOption umsParentOption : parentOptions) {
				List<UmsOption> umsChildOptions = getOptionsByParentId(umsParentOption
						.getOptionId());
				if (umsChildOptions != null && umsChildOptions.size() > 0) {
					for (UmsOption thisChildOption : umsChildOptions) {
						umsParentOption.addChildOption(thisChildOption);
					}
				}
			}
		}
		return parentOptions;
	}

	/**
	 * @param optionId
	 * @param optionName
	 * @param optionDescription
	 * @param optionTypeValue
	 * @param optionStatusValue
	 * @param optionLink
	 * @param optionImageLink
	 * @param optionImageAlt
	 * @param optionOrder
	 * @param parentOptionId
	 * @param enableToolbox
	 * @param objectReferenceKey
	 * @return int
	 * @throws BusinessException
	 */
	public int updateOption(int optionId, String optionName,
			String optionDescription, int optionTypeValue,
			int optionStatusValue, String optionLink, String optionImageLink,
			String optionImageAlt, int optionOrder, int parentOptionId,
			boolean enableToolbox, String objectReferenceKey)
			throws BusinessException {

		// preparing data before hitting UmsOptions DAO layer
		UmsOption umsOption = new UmsOption();
		umsOption.setOptionId(optionId);
		umsOption.setOptionName(optionName);
		umsOption.setOptionDescription(optionDescription);
		umsOption.setOptionType(optionTypeValue);
		umsOption.setOptionStatus(optionStatusValue);
		umsOption.setOptionOrder(optionOrder);
		umsOption.setEnableToolbox(enableToolbox);
		umsOption.setOptionLink(optionLink);
		umsOption.setOptionImageLink(optionImageLink);
		umsOption.setOptionImageAlt(optionImageAlt);
		umsOption.setObjectReferenceKey(objectReferenceKey);
		umsOption.setParentOptionId(parentOptionId);

		// hitting UmsOptions DAO layer
		UmsOptionDao umsOptionsDao = new UmsOptionDaoImpl(dbSession);
		try {
			return umsOptionsDao.update(umsOption);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}
}