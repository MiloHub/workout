package com.sample.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
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
