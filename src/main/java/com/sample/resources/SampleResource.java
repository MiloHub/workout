package com.sample.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sample.model.Person;


@Path("/samplerest")
public class SampleResource {

	static List<Person> persons = new ArrayList<Person>();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getPerson() {

		Person person = new Person();
		person.setAge(45);
		person.setName("john");
		person.setExample("Get example for person");
		Person person2 = new Person();
		person2.setAge(45);
		person2.setName("john");
		person2.setExample("Get example for person");
		persons.add(person2);
		persons.add(person);

		return persons;

	}
	
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Object deletePersons() {
		persons.clear();
		return Response.status(200).entity("persons deleted successfully")
				.build();

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Object addPerson(Person person) throws Exception {
		if (person != null) {
			persons.add(person);
			return Response.status(200).entity("person saved successfully")
					.build();
		} else {
			throw new Exception("Error in request");
		}

	}

}
