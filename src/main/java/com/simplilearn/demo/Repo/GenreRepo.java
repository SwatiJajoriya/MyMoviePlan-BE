package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.demo.entity.Genre;



public interface GenreRepo extends JpaRepository<Genre, Integer>{

}
