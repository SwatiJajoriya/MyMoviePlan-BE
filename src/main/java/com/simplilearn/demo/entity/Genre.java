package com.simplilearn.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String genre;
}