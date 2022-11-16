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
	@EqualsAndHashCode.Include

	private String id;

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
