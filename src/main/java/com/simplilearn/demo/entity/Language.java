package com.simplilearn.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String language;
}


