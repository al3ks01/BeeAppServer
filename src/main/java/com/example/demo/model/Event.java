package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document(value="Event")
public class Event implements Serializable{
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
