package com.digwener.http;

import com.digwener.common.DataType;

/**
 * interface representing a service which gets RAW string data from HTTP endpoint
 * <p>
 * Created by aberezin on 24.04.2016.
 */
public interface FooHttpService {
	String getApiResponse(final DataType dataType /*, parameters like id of the resource */);
}
