package org.labor.daos;

// Generated Jul 25, 2013 11:50:54 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.labor.pojos.Employer;

/**
 * Home object for domain model class Employer.
 * @see org.labor.pojos.Employer
 * @author Hibernate Tools
 */
@Stateless
public class EmployerHome {

	private static final Log log = LogFactory.getLog(EmployerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Employer transientInstance) {
		log.debug("persisting Employer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Employer persistentInstance) {
		log.debug("removing Employer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Employer merge(Employer detachedInstance) {
		log.debug("merging Employer instance");
		try {
			Employer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Employer findById(Integer id) {
		log.debug("getting Employer instance with id: " + id);
		try {
			Employer instance = entityManager.find(Employer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
