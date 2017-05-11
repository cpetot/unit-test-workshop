package com.cpetot.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Access(AccessType.FIELD)
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private Integer age;

	@JsonIgnore
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Movie> watchList;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Integer getAge() {
		return age;
	}

	public List<Movie> getWatchList() {
		return watchList;
	}
}
