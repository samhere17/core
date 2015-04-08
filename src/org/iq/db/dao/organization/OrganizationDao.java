package org.iq.db.dao.organization;

import java.util.List;

import org.iq.BasicSearchInput;
import org.iq.db.dao.BaseDao;
import org.iq.exception.DbException;
import org.iq.valueobject.organization.Organization;

/**
 * @author Sam
 * 
 */
public interface OrganizationDao extends BaseDao<Organization> {
	
	int insertAndGetOrganizationId(Organization organization)throws DbException ;
	
	List<Organization> search(BasicSearchInput basicSearchInput) throws DbException ;

	Organization selectByOrganizationId(int organizationId) throws DbException;
	
}