package com.test.resources;

import java.io.IOException;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SampleResourceTest {
	@XmlRootElement
	class Person {
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getExample() {
			return example;
		}
		public void setExample(String example) {
			this.example = example;
		}
		private String name;
		private int age;
		private String example;
		

	}
	@Test
	public void testGet() {
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/codechallenge/rest/samplerest/get");

		ClientResponse response = webResource.type("application/json").get(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		Object person = response.getEntity(String.class);
		System.out.println(person);
	}

	@Test
	public void testPost() throws JsonGenerationException, JsonMappingException, IOException {
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/codechallenge/rest/samplerest/post");
		Person person = new Person();
		person.setAge(60);
		person.setName("Don");
		person.setExample("added by post");
		
		ObjectMapper mapper = new ObjectMapper();
		String input = mapper.writeValueAsString(person);
		ClientResponse response = webResource.type("application/json").post(
				ClientResponse.class, input);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		Object output = response.getEntity(String.class);
		System.out.println(output);
	}

	@Test
	public void testDelete() throws JsonGenerationException, JsonMappingException, IOException {
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/codechallenge/rest/samplerest/delete");
		ClientResponse response = webResource.type("application/json").delete(
				ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		System.out.println("Output from Server .... \n");
		Object output = response.getEntity(String.class);
		System.out.println(output);
	}

}
