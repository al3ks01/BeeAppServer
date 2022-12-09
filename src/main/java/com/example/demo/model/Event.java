package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document(value="Event")
public class Event implements Serializable{
	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String name;
	private String description;
	@Singular
	private Set<String> attendees;
	private LocalDate date;
	private LocalTime time;
	
	//En que momento pones location y address??
	//private String address;
	private String location;

	
	private EventType type;
}
