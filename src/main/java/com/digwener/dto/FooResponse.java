package com.digwener.dto;

/**
 * General Dto for Foo API
 * Created by aberezin on 24.04.2016.
 */
public class FooResponse<T> {

	private final String status;

	private final String message;

	private final T data;

	public FooResponse(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
