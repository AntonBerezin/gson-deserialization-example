package com.digwener.api;

import com.digwener.common.DataType;
import com.digwener.dto.FooResponse;
import com.digwener.http.FooHttpService;
import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * class representing our library API
 * Created by aberezin on 24.04.2016.
 */
public class FooWrapper {

	private final FooHttpService fooHttpService;

	private final Gson gson = new Gson();

	public FooWrapper(final FooHttpService fooHttpService) {
		this.fooHttpService = fooHttpService;
	}

	/**
	 * retrieves the resource of given type
	 *
	 * @param dataType  type of the resource
	 * @param dataClass class which is used to deserialize "data" part
	 * @param <T>       type of deserialized "data" object
	 * @return deserialized object
	 */
	public <T> FooResponse<T> getResponse(final DataType dataType, final Class<T> dataClass) {

		final String rawResponse = fooHttpService.getApiResponse(dataType);

		return gson.fromJson(rawResponse, getType(FooResponse.class, dataClass));

	}

	private Type getType(final Class<?> rawClass, final Class<?> parameterClass) {
		return new ParameterizedType() {
			@Override
			public Type[] getActualTypeArguments() {
				return new Type[]{parameterClass};
			}

			@Override
			public Type getRawType() {
				return rawClass;
			}

			@Override
			public Type getOwnerType() {
				return null;
			}

		};
	}
}
