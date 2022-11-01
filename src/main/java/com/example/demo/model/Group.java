package com.example.demo.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

import lombok.Singular;

public class Group {
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String gid;
	private LocalDate date;
	private Type type;
	private String description;
	@Singular
	private Set<String> users = new HashSet<>();
}
