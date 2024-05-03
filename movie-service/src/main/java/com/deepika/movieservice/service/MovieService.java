package com.deepika.movieservice.service;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepika.movieservice.model.Movie;
import com.deepika.movieservice.repositry.MovieRepositry;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieRepositry movieRepositry;
	
	//crud operation create ,read , update ,delete
	
	public Movie create(Movie movie) {
		if (movie == null) {
			throw new RuntimeException("Invalid movie");
		}
		return movieRepositry.save(movie);
		
	}
	
	public Optional<Movie> read(Long id) {
		if (id == null) {
			throw new RuntimeException("not found  movie");
		}
		return movieRepositry.findById(id);
		
	}
	
	public void update(Long id ,Movie update) {
		
		if (update == null || id == null) {
			throw new RuntimeException("Invalid movie");
		}
		
		if(movieRepositry.existsById(id)) {
			Movie movie = movieRepositry.getReferenceById(id);
			movie.setName(update.getName());
			movie.setDirector(update.getDirector());
			movie.setActors(update.getActors());
			movieRepositry.save(movie);
		}
		else {
			throw new RuntimeException("Movie not found");
		}
	}
	 public void delete(long id) {
			if(movieRepositry.existsById(id)) {
				movieRepositry.deleteById(id);
			}
			else {
				throw new RuntimeException("Movie not found");
	 }
	 }
}
