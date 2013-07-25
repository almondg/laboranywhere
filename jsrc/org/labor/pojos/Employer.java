package org.labor.pojos;

// Generated Jul 25, 2013 11:50:54 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Employer generated by hbm2java
 */
@Entity
@Table(name = "Employer")
public class Employer implements java.io.Serializable {

	private Integer employerId;
	private String accountId;
	private Set employerToJobs = new HashSet(0);

	public Employer() {
	}

	public Employer(String accountId, Set employerToJobs) {
		this.accountId = accountId;
		this.employerToJobs = employerToJobs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "employer_id", unique = true, nullable = false)
	public Integer getEmployerId() {
		return this.employerId;
	}

	public void setEmployerId(Integer employerId) {
		this.employerId = employerId;
	}

	@Column(name = "account_id", length = 4096)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employer")
	public Set getEmployerToJobs() {
		return this.employerToJobs;
	}

	public void setEmployerToJobs(Set employerToJobs) {
		this.employerToJobs = employerToJobs;
	}

}