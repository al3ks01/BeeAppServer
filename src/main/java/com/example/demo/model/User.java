package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
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
public class User implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	private String id;
	
	@Column(length = 30)
	private String username;
	@Column(length = 60)
	private String email;
	@Column(length = 30)
	private String password;

	// longitud máxima de un teléfono con prefijo de 3 dígitos
	@Column(length = 12)
	private String phone;

	@Column
	private String picture;
	@Column(length = 120)
	private String mood;
}
