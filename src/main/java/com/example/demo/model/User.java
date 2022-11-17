package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

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
public class User {

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

	@Column(columnDefinition="BLOB")
	@Lob
	private Byte[] picture;
	@Column(length = 120)
	private String mood;

	/*@Singular
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ID")
	private Set<String> contactUids;*/

}
