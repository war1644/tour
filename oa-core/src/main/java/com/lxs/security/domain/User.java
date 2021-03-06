package com.lxs.security.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

@Entity
@Table(name = "user_")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JSONType(ignores = "hibernateLazyInitializer")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String userName;
	private String realName;
	private String password;
	private String desc;
	private Dept dept;

	private Set<Role> roles = new HashSet<Role>();
	private Set<Job> jobs = new HashSet<Job>();

	@Id
	@GeneratedValue
	@Column(name = "id_")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user_name_", unique = true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password_")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "real_name_")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * mapperdBy:制定关联属性，表示关联哪一方维护关联关系,维护关联关系的一方配置JoinTable
	 * 
	 * @return
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@JSONField(serialize = false)
	public Set<Role> getRoles() {
		return roles;
	}
	
	@JSONField(deserialize = false)
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_job_", joinColumns = { @JoinColumn(name = "user_id_") }, inverseJoinColumns = { @JoinColumn(name = "job_id_") })
	@JSONField(serialize = false)
	public Set<Job> getJobs() {
		return jobs;
	}

	@JSONField(deserialize = false)
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id_")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Lob
	@Column(name = "desc_")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
