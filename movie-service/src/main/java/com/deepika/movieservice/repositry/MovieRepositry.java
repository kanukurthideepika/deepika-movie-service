package com.deepika.movieservice.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepika.movieservice.model.Movie;

@Repository
public interface MovieRepositry extends JpaRepository<Movie, Long>{

}
