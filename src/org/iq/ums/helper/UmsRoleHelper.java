package org.iq.ums.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iq.exception.BusinessException;
import org.iq.exception.DbException;
import org.iq.helper.BaseHelper;
import org.iq.ums.UmsConstants.AreaSpecifier;
import org.iq.ums.UmsConstants.RoleStatus;
import org.iq.ums.dao.UmsRoleDao;
import org.iq.ums.dao.UmsRoleOptionMapDao;
import org.iq.ums.dao.UmsUserRoleMapDao;
import org.iq.ums.dao.impl.UmsRoleDaoImpl;
import org.iq.ums.dao.impl.UmsRoleOptionMapDaoImpl;
import org.iq.ums.dao.impl.UmsUserRoleMapDaoImpl;
import org.iq.ums.util.UmsDbProvider;
import org.iq.ums.vo.UmsRole;
import org.iq.ums.vo.UmsRoleOptionMap;
import org.iq.ums.vo.UmsUserRoleMap;

public class UmsRoleHelper extends BaseHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9029653180971394912L;

	public UmsRoleHelper() throws BusinessException {
		super(UmsDbProvider.getDbSession());
	}

	public Map<Integer, Boolean> getOptionsMap(int roleId) throws BusinessException {
		UmsRoleOptionMapDao umsRoleOptionMapDao = new UmsRoleOptionMapDaoImpl(dbSession);
		Map<Integer, Boolean> retMap = null;
		try {
			List<UmsRoleOptionMap> umsRoleOptionMaps = umsRoleOptionMapDao.selectOptionsByRoleId(roleId);

			if (umsRoleOptionMaps != null && umsRoleOptionMaps.size() > 0) {
				retMap = new HashMap<Integer, Boolean>();
				for (UmsRoleOptionMap umsRoleOptionMap : umsRoleOptionMaps) {
					retMap.put(umsRoleOptionMap.getOptionId(), umsRoleOptionMap.isEnabled());
				}
			}
		} catch (DbException e) {
			throw new BusinessException(e);
		}
		return retMap;
	}

	/**
	 * @param roleArea
	 * @param roleId
	 * @param roleName
	 * @return List<UmsRole>
	 * @throws BusinessException
	 */
	public List<UmsRole> getSearchedRoles(Integer roleArea, Integer roleId, String roleName) throws BusinessException {
		UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);
		
		UmsRole umsRole = new UmsRole();
		
		umsRole.setRoleName(roleName);
		
		try {
			return umsRoleDao.search(umsRole);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	/**
	 * @param roleId
	 * @return UmsRole
	 * @throws BusinessException
	 */
	public UmsRole getRoleByRoleId(int roleId) throws BusinessException {
		UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);
		try {
			return umsRoleDao.selectByRoleId(roleId);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	/**
	 * @param roleId
	 * @return UmsRole
	 * @throws BusinessException
	 */
	public UmsRole getRoleByUserId(int userId) throws BusinessException {
		try {
			UmsUserRoleMapDao umsUserRoleMapDao = new UmsUserRoleMapDaoImpl(dbSession);
			UmsUserRoleMap roleMap = umsUserRoleMapDao.selectByUserId(userId);

			UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);
			return umsRoleDao.selectByRoleId(roleMap.getRoleId());
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public UmsRole createRole(String roleName, String roleDesc, Map<Integer, Boolean> optionsMap, String additionalId,
			int userId) throws BusinessException {
		UmsRole umsRole = null;
		try {
			UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);

			umsRole = new UmsRole();
			umsRole.setAdditionalId(additionalId);
			umsRole.setRoleArea(AreaSpecifier.APPLICATION);
			umsRole.setRoleCreation(new Date());
			umsRole.setRoleCreatedBy(userId);
			umsRole.setRoleDescription(roleDesc);
			umsRole.setRoleName(roleName);
			umsRole.setRoleStatus(RoleStatus.ACTIVE);
			umsRole.setRoleUpdated(new Date());
			umsRole.setRoleUpdatedBy(userId);

			int roleId = umsRoleDao.insertAndGetRoleId(umsRole);

			umsRole.setRoleId(roleId);

			UmsRoleOptionMapDao umsRoleOptionMapDao = new UmsRoleOptionMapDaoImpl(dbSession);

			umsRoleOptionMapDao.insertMultiple(roleId, optionsMap);

		} catch (DbException e) {
			throw new BusinessException(e);
		}
		return umsRole;
	}

	public void updateRole(int roleId, String roleName, String roleDesc, Map<Integer, Boolean> optionsMap,
			String additionalId, int userId) throws BusinessException {
		UmsRole umsRole = null;
		try {
			UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);

			umsRole = new UmsRole();
			umsRole.setRoleId(roleId);
			umsRole.setAdditionalId(additionalId);
			umsRole.setRoleArea(AreaSpecifier.APPLICATION);
			umsRole.setRoleCreation(new Date());
			umsRole.setRoleCreatedBy(userId);
			umsRole.setRoleDescription(roleDesc);
			umsRole.setRoleName(roleName);
			umsRole.setRoleStatus(RoleStatus.ACTIVE);
			umsRole.setRoleUpdated(new Date());
			umsRole.setRoleUpdatedBy(userId);

			umsRoleDao.update(umsRole);

			UmsRoleOptionMapDao umsRoleOptionMapDao = new UmsRoleOptionMapDaoImpl(dbSession);

			umsRoleOptionMapDao.updateMultiple(roleId, optionsMap);

		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public List<UmsRole> getAllRoles() throws BusinessException {
		UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);

		try {
			return umsRoleDao.select();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public List<UmsRole> getAppRoles() throws BusinessException {
		UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);

		try {
			return umsRoleDao.selectAppRoles();
		} catch (DbException e) {
			throw new BusinessException(e);
		}
	}

	public void delete(int roleId, int userId) throws BusinessException {
		UmsRoleDao umsRoleDao = new UmsRoleDaoImpl(dbSession);
		
		try {
			UmsRole umsRole = new UmsRole();
			umsRole.setRoleId(roleId);
			umsRole.setRoleUpdated(new Date());
			umsRole.setRoleUpdatedBy(userId);
			
			umsRoleDao.softDelete(umsRole);
		} catch (DbException e) {
			throw new BusinessException(e);
		}
		
	}
}