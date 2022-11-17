package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Event {
	@Id
	@EqualsAndHashCode.Include
<<<<<<< HEAD
	private String id;
=======

	private String id;

>>>>>>> c4ede6ec726b3dbb365958f7605f8b4265362a6b
	private String name;
	private LocalDate date;
	private LocalTime time;
	private Type type;
	private String description;
	private String address;
	private String location;
	// @Singular
	// private Set<String> attendees = new HashSet<>();
}
