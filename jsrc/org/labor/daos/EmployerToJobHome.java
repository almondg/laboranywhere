package org.labor.daos;

// Generated Jul 25, 2013 11:50:54 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.labor.pojos.EmployerToJob;

/**
 * Home object for domain model class EmployerToJob.
 * @see org.labor.pojos.EmployerToJob
 * @author Hibernate Tools
 */
@Stateless
public class EmployerToJobHome {

	private static final Log log = LogFactory.getLog(EmployerToJobHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployerToJob transientInstance) {
		log.debug("persisting EmployerToJob instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployerToJob persistentInstance) {
		log.debug("removing EmployerToJob instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployerToJob merge(EmployerToJob detachedInstance) {
		log.debug("merging EmployerToJob instance");
		try {
			EmployerToJob result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployerToJob findById(Integer id) {
		log.debug("getting EmployerToJob instance with id: " + id);
		try {
			EmployerToJob instance = entityManager
					.find(EmployerToJob.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
