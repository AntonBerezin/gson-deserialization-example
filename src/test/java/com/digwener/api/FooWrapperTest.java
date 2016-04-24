package com.digwener.api;

import com.digwener.common.DataType;
import com.digwener.dto.Department;
import com.digwener.dto.FooResponse;
import com.digwener.dto.Person;
import com.digwener.http.FooHttpService;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

/**
 * Test class which demonstrates deserialization
 * Created by aberezin on 24.04.2016.
 */
public class FooWrapperTest {

	@Mock
	private FooHttpService fooHttpService;

	@InjectMocks
	private FooWrapper fooWrapper;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldLoadPerson() throws Exception {
		given(fooHttpService.getApiResponse(DataType.PERSON)).willReturn(getResource("person.json"));

		FooResponse<Person> person = fooWrapper.getResponse(DataType.PERSON, Person.class);

		assertNotNull(person);
		assertEquals(person.getData().getName(), "John");
		assertEquals(person.getData().getSurname(), "Smith");
	}

	@Test
	public void shouldLoadDepartment() throws Exception {
		given(fooHttpService.getApiResponse(DataType.DEPARTMENT)).willReturn(getResource("department.json"));

		FooResponse<Department> department = fooWrapper.getResponse(DataType.DEPARTMENT, Department.class);

		assertNotNull(department);
		assertEquals(department.getData().getName(), "Agriculture");
		assertEquals(department.getData().getPeopleCount(), 42);
	}

	private String getResource(final String fileName) throws Exception {
		return IOUtils.toString(
				this.getClass().getResourceAsStream(fileName),
				"UTF-8"
		);
	}

}