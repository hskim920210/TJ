package com.tje.model;

import java.util.*;

public class TheJoEun {
	private String location;
	private ArrayList<Student> students;
	
	public TheJoEun() {}

	public TheJoEun(String location, ArrayList<Student> students) {
		this.location = location;
		this.students = students;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(String.format("지점의 위치는 %s 입니다.\n", this.location));
		buffer.append("학생들의 정보는 다음과 같습니다.\n");
		
		for ( Student s : this.students ) {
			buffer.append(String.format("- %s (%s)\n", s.getName(), s.getAddress()));
			
		}
		return buffer.toString();
	}
	
}
