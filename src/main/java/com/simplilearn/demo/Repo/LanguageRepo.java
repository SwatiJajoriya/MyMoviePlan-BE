package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.demo.entity.Language;

public interface LanguageRepo extends JpaRepository<Language,Integer> {

}
