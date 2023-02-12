package com.example.demoswagger.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	private String userId;
	private String name;
	private String designation;
	private String userEmail;
	private long phoneNumber;

}