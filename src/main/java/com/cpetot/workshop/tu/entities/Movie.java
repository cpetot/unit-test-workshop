package com.cpetot.workshop.tu.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

import com.cpetot.workshop.tu.enums.ContentRating;

@Entity
@Access(AccessType.FIELD)
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "le titre est obligatoire")
	@Column(unique = true, nullable = false)
	private String title;

	@NotNull(message = "le rating est obligatoire")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ContentRating rating;

	@Column
	private Date lastWatch;

	public Movie() {
	}

	public Movie(ContentRating rating) {
		this();
		this.rating = rating;
	}

	public Movie(String title, ContentRating rating) {
		this(rating);
		this.title = title;
	}

	public boolean isAvailableForAge(int minAge) {
		return minAge >= rating.minAge();
	}

	public void updateLastWatch() {
		this.lastWatch = new Date();
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
