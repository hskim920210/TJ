package com.tje.model;

import java.util.*;

public class Store {
	private String name;
	private String location;
	private HashMap<String, Double> products;
	
	public Store() {}
	
	public Store(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HashMap<String, Double> getProducts() {
		return products;
	}

	public void setProducts(HashMap<String, Double> products) {
		this.products = products;
	}
	
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(String.format("상점의 이름은 %s 입니다.\n", this.name));
		buffer.append(String.format("상점의 위치는 %s 입니다.\n", this.location));
		buffer.append("상점의 메뉴와 가격은 다음과 같습니다.\n");
		
		for ( String key : this.products.keySet() ) {
			buffer.append(String.format("- %s : %.2f 원\n", key, this.products.get(key)));
			
		}
		return buffer.toString();
	}
	
}
