package com.simplilearn.demo.entity;


import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	 @Id
    private String uname;
	private String password;
	private String name;
	private String email;
	private String mobileNo;
	private String address;
}