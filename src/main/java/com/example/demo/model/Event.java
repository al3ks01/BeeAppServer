package com.example.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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

@Document(value = "Event")
public class Event implements Serializable {
	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String name;
	private String description;
	@Singular
	private Set<String> attendees;
	private String date;
	private String time;
	private String location;
	private EventType type;
	private String chatId;
	private List<Expense> expenses;
}
