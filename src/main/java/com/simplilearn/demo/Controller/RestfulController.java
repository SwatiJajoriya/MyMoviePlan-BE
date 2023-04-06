package com.simplilearn.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.demo.Repo.AdminRepo;
import com.simplilearn.demo.Repo.CartRepo;
import com.simplilearn.demo.Repo.GenreRepo;
import com.simplilearn.demo.Repo.LanguageRepo;
import com.simplilearn.demo.Repo.MovieRepo;
import com.simplilearn.demo.Repo.UserRepo;
import com.simplilearn.demo.Service.MovieDAO;
import com.simplilearn.demo.entity.Admin;
import com.simplilearn.demo.entity.Cart;
import com.simplilearn.demo.entity.Genre;
import com.simplilearn.demo.entity.Language;
import com.simplilearn.demo.entity.Movie;
import com.simplilearn.demo.entity.User;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class RestfulController {
	@Autowired
	MovieRepo movieRepo;
	@Autowired
	CartRepo cartRepo;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	GenreRepo genreRepo;
	@Autowired
	LanguageRepo languageRepo;
	@Autowired
	private MovieDAO mdao;
	
	@PostMapping("/movie/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie m) {
		Movie movie=movieRepo.save(m);
		if(movie!=null) {
			return new ResponseEntity<Movie>(movie,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<Movie>(movie,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 
	@GetMapping("/movie/getallmovie")
	public List<Movie> getAllMovie() {
		return movieRepo.findAll();
	}
	
	//search by moviename
	@GetMapping("/movie/getByMovieName/{movieName}")
	public List<Movie>getMovieByName (@PathVariable String movieName){
		return movieRepo.findyByMoviename(movieName);
	}
	
	//search by genre
	@GetMapping("/movie/getAllByGenre/{genre}")
	public List<Movie>getMovieByGenre (@PathVariable String genre){
		return movieRepo.getMoviesByGenre(genre);
	}
	
	//search by language
	@GetMapping("/movie/getAllByLanguage/{language}")
	public List<Movie>getMovieByLanguage (@PathVariable String language){
		return movieRepo.getMoviesByLanguage(language);
	}
	
	@GetMapping("/movie/getMovieById/{id}")
	public ResponseEntity<Movie>getMovieById (@PathVariable int id){
		Movie movie= movieRepo.findyByMovieID(id);
		if(movie!=null) {
			return new ResponseEntity<Movie>(movie, HttpStatus.OK);
			}
		else {
			return new ResponseEntity<Movie>(movie, HttpStatus.NOT_FOUND);
			}
	}
	
	@PutMapping("/movie/movieUpdate/{id}")
	public ResponseEntity<Object> updateMovie(@PathVariable int id,@RequestBody Movie newmv){
		Movie med= mdao.updateMovie(id, newmv);
		
		if (med!=null)
			return new ResponseEntity<Object>(med,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Movie Available to Update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/movie/delete/{id}")
	public ResponseEntity<String>deleteMovie(@PathVariable int id){
		boolean result = mdao.deleteMovie(id);
		if(result) 
			return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("NO movie Found", HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/cart/movies/all")
	public List<Cart> getAllMovieincart() {
		return cartRepo.findAll();
	}
	
	@PostMapping("/cart/movies/add")
	public Cart addMovieToCart(@RequestBody(required = false) Cart cart) {
		return cartRepo.save(cart);
	}
	
	@DeleteMapping("/cart/movies/delete/{id}")
	public void deleteMovieFromCart(@PathVariable int id) {
		cartRepo.deleteById(id);
	}
	
	@DeleteMapping("/cart/movies/delete/all")
	public void deleteAllMovie() {
		cartRepo.deleteAll();
	}
	
	@PostMapping("/admin/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin ad) {
		Admin mm=adminRepo.save(ad);
		if(mm!=null) {
			return new ResponseEntity<Admin>(mm,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<Admin>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/admin/getAdmin/{username}")
	public ResponseEntity<Admin>checkAdmin (@PathVariable String username){
		Admin ad= adminRepo.findByName(username);
		if(ad!=null)
			return new ResponseEntity<Admin>(ad, HttpStatus.OK);
		else
			return new ResponseEntity<Admin>(ad, HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/user/getUser/{username}")
	public ResponseEntity<User>checkUser (@PathVariable String username){
		User u= userRepo.findByuserName(username);
		if(u!=null)
			return new ResponseEntity<User>(u, HttpStatus.OK);
		else
			return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
	}
	@PostMapping("/user/addUser")
	public ResponseEntity<User> addUser(@RequestBody User u) {
		User mm=userRepo.save(u);
		if(mm!=null) {
			return new ResponseEntity<User>(mm,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<User>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/genre/addGenre")
	public ResponseEntity<Genre> addGenre(@RequestBody Genre g) {
		Genre mm=genreRepo.save(g);
		if(mm!=null) {
			return new ResponseEntity<Genre>(mm,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<Genre>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/genre/getallGenre")
	public List<Genre> getAllGenre() {
		return genreRepo.findAll();
	}
	
	@PostMapping("/language/addlanguage")
	public ResponseEntity<Language> addLanguage(@RequestBody Language lang) {
		Language mm=languageRepo.save(lang);
		if(mm!=null) {
			return new ResponseEntity<Language>(mm,HttpStatus.CREATED);
		}
			else {
				return new ResponseEntity<Language>(mm,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/language/getallLanguage")
	public List<Language> getAllLanguage() {
		return languageRepo.findAll();
	}
	
}


