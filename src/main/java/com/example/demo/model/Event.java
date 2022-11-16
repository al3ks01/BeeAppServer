package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Event {
	@Id
<<<<<<< HEAD
	@EqualsAndHashCode.Include
	private int id;
=======
	private String id;
>>>>>>> 7c8c2c13a31a8b2db872db1f2937dcdf4091c4c0
	private String name;
	private LocalDate date;
	private LocalTime time;
	private Type type;
	private String description;
	private String address;
	private String location;
	//@Singular
	
	//private Set<String> attendees = new HashSet<>();
}
