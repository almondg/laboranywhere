package org.labor.daos;

// Generated Jul 25, 2013 11:50:54 PM by Hibernate Tools 4.0.0

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.labor.pojos.Job;

/**
 * Home object for domain model class Job.
 * @see org.labor.pojos.Job
 * @author Hibernate Tools
 */
@Stateless
public class JobHome {

	private static final Log log = LogFactory.getLog(JobHome.class);

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
