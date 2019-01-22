package com.cpetot.workshop.tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpetot.workshop.tu.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	Movie findByTitle(String title);

}
