package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.demo.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	
}