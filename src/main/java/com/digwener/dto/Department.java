package com.digwener.dto;

/**
 * Created by aberezin on 24.04.2016.
 */
public class Department {

	private final String name;

	private final int peopleCount;

	public Department(final String name, final int peopleCount) {
		this.name = name;
		this.peopleCount = peopleCount;
	}

	public String getName() {
		return name;
	}

	public int getPeopleCount() {
		return peopleCount;
	}
}
