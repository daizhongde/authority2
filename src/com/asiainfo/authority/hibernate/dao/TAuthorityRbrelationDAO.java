package com.asiainfo.authority.hibernate.dao;

import java.util.List;

import com.asiainfo.authority.hibernate.pojo.TAuthorityRbrelation;

import person.daizhongde.virtue.dao.SpringHibernateDao;

public interface TAuthorityRbrelationDAO extends SpringHibernateDao {

	// property constants
	public static final String _CCIP = "CCip";
	public static final String _CCREATOR = "CCreator";

	/**
	 * @param moduleId
	 * @param userId
	 * @return
	 */
	public abstract List findUserButton4tb(Integer moduleId, Integer userId  );
		
	public abstract void save(TAuthorityRbrelation transientInstance);

	public abstract void delete(TAuthorityRbrelation persistentInstance);

	public abstract TAuthorityRbrelation findById(
			com.asiainfo.authority.hibernate.pojo.TAuthorityRbrelationId id);

	public abstract List findByExample(TAuthorityRbrelation instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCCip(Object CCip);

	public abstract List findByCCreator(Object CCreator);

	public abstract List findAll();

	public abstract TAuthorityRbrelation merge(
			TAuthorityRbrelation detachedInstance);

	public abstract void attachDirty(TAuthorityRbrelation instance);

	public abstract void attachClean(TAuthorityRbrelation instance);

}