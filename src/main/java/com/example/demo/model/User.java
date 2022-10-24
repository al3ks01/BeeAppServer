package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User {
	@Id
	private String id;
	private String username;
	private String picture;
}
