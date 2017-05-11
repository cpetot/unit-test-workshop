package com.cpetot.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import com.cpetot.enums.ContentRating;

@Entity
@Access(AccessType.FIELD)
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String title;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ContentRating rating;

	@Column
	private Date lastWatch;

	public Movie() {
	}

	public boolean isAvailableForAge(int minAge) {
		return minAge >= rating.minAge();
	}

	public ContentRating getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public Date getLastWatch() {
		return lastWatch;
	}

}
