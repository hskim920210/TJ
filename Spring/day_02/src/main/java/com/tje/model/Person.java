package com.tje.model;

public class Person {
	private String name;
	private Pet pet;

	public Person(String name, Pet pet) {
		this.name = name;
		this.pet = pet;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
}
