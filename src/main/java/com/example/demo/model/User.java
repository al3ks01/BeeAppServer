package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Lob;

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

@Document(value = "User")
public class User implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	private String id;
	private String username;
	private String email;
	private String password;
	private Byte[] picture;
	private String mood;
	@Singular
	private Set<String> contacts;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", mood="
				+ mood + ", contacts=" + contacts + "]";
	}

}
