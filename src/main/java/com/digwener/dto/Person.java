package com.digwener.dto;

/**
 * DTO for person
 * Created by aberezin on 24.04.2016.
 */
public class Person {
	private final String name;

	private final String surname;

	public Person(final String name, final String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
}
