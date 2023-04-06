package com.simplilearn.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer> {
	
	@Query("FROM Movie m WHERE m.movieName LIKE %?1%")
	public List<Movie> findyByMoviename(String movieName);
	
	@Query("FROM Movie m WHERE m.id=?1")
	public Movie findyByMovieID(int id);
	
	@Query("FROM Movie m WHERE m.genre=?1")
	public List<Movie> getMoviesByGenre(String genre);
	
	@Query("FROM Movie m WHERE m.language=?1")
	public List<Movie> getMoviesByLanguage(String language);
}

 
