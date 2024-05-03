package com.deepika.movieservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepika.movieservice.model.Movie;
import com.deepika.movieservice.service.MovieService;


@RestController

@RequestMapping("/movies")
public class MovieController {
	
	Logger logger =LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movie>> getMovie(@PathVariable Long id){
		 Optional<Movie> movie = movieService.read(id);
		 logger.info("return movie with id :{}" ,id);
		 return ResponseEntity.ok(movie);
	}
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
		Movie createMovie = movieService.create(movie);
		logger.info("create movie with id :{}" ,createMovie.getId());
		return ResponseEntity.ok(createMovie); 
	}

	@PutMapping("/{id}")
	public void updateMovie(@PathVariable Long id ,@RequestBody Movie movie) {
		logger.info("updateMovie with id :{}" ,id);
		movieService.update(id,movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		logger.info("deleteMovie with id :{}" ,id);
		movieService.delete(id);
	}
}
