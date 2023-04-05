package com.simplilearn.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.simplilearn.demo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
	
	@Query("Select u from User u where u.uname=?1")
	public User findByuserName(String uname);


}
