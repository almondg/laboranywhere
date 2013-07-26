package org.labor.daos;

// Generated Jul 26, 2013 2:30:51 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

/**
 * Home object for domain model class Job.
 * @see org.labor.daos.Job
 * @author Hibernate Tools
 */
@Stateless
public class JobHome {

	private static final Logger log = Logger.getLogger(JobHome.class);
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Job transientInstance) {
		log.debug("persisting Job instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Job persistentInstance) {
		log.debug("removing Job instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Job merge(Job detachedInstance) {
		log.debug("merging Job instance");
		try {
			Job result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Job findById(Integer id) {
		log.debug("getting Job instance with id: " + id);
		try {
			Job instance = entityManager.find(Job.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
