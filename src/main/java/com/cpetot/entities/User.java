package com.cpetot.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cpetot.exceptions.MovieAlreadyInWatchlistException;
import com.cpetot.exceptions.UserNotAllowedToWatchException;
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
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "join_user_watch_movies",
			joinColumns = @JoinColumn(
					name = "user_id",
					nullable = false,
					foreignKey = @ForeignKey(name = "user_fk")
			),
			inverseJoinColumns = @JoinColumn(
					name = "movie_id",
					nullable = false,
					foreignKey = @ForeignKey(name = "movie_fk")
			)
	)
	private List<Movie> watchList;

	public User() {
		watchList = new ArrayList<>();
	}

	public User(String username, Integer age) {
		this();
		this.username = username;
		this.age = age;
	}

	public void addWatchMovie(Movie movie) {
		if (watchList.contains(movie)) {
			throw new MovieAlreadyInWatchlistException(username, movie.getTitle());
		}

		if (!movie.isAvailableForAge(age)) {
			throw new UserNotAllowedToWatchException(age, movie.getRating());
		}

		watchList.add(movie);
		movie.updateLastWatch();
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
		return Collections.unmodifiableList(watchList);
	}
}
