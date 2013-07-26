package org.labor.daos;

// Generated Jul 25, 2013 11:50:54 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.labor.pojos.EmployeeToJob;

/**
 * Home object for domain model class EmployeeToJob.
 * @see org.labor.pojos.EmployeeToJob
 * @author Hibernate Tools
 */
@Stateless
public class EmployeeToJobHome {

	private static final Log log = LogFactory.getLog(EmployeeToJobHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeeToJob transientInstance) {
		log.debug("persisting EmployeeToJob instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployeeToJob persistentInstance) {
		log.debug("removing EmployeeToJob instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployeeToJob merge(EmployeeToJob detachedInstance) {
		log.debug("merging EmployeeToJob instance");
		try {
			EmployeeToJob result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeeToJob findById(Integer id) {
		log.debug("getting EmployeeToJob instance with id: " + id);
		try {
			EmployeeToJob instance = entityManager
					.find(EmployeeToJob.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
