package com.simplilearn.demo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.simplilearn.demo.entity.Admin;



public interface AdminRepo extends JpaRepository<Admin, String> {
	
	@Query("Select a from Admin a where a.username=?1")
	public Admin findByName(String un);

}