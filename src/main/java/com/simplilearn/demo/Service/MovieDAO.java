package com.simplilearn.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.demo.Repo.MovieRepo;
import com.simplilearn.demo.entity.Movie;

@Service
public class MovieDAO {
	
	@Autowired
	MovieRepo repo;
	
	public Movie updateMovie(int id, Movie newmv) {
		if(repo.findById(id).isPresent()) {
			Movie oldmv= repo.findById(id).get();
			oldmv.setMovieName(newmv.getMovieName());
			oldmv.setShowDate(newmv.getShowDate());
			oldmv.setShowTime(newmv.getShowTime());
			oldmv.setShowingLocation(newmv.getShowingLocation());
			oldmv.setPrice(newmv.getPrice());
			oldmv.setGenre(newmv.getGenre());
			oldmv.setLanguage(newmv.getLanguage());
			oldmv.setImagePath(newmv.getImagePath());
			return repo.save(oldmv);
		}
		else {
			return null;
		}
	}
	
	public boolean deleteMovie(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}

}
