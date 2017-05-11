package com.cpetot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpetot.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Movie findByTitle(String title);

}
