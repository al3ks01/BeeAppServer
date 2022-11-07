package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/

import lombok.Singular;

public class Event {
	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private LocalDate date;
	private LocalTime time;
	private Type type;
	private String description;
	private String address;
	private String location;
	@Singular
	private Set<String> users = new HashSet<>();
	@Singular
	private Set<String> managers = new HashSet<>();
}
