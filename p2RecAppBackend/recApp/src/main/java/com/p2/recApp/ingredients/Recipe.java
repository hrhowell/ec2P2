package com.p2.recApp.ingredients;

public class Recipe {
	private String name;
	
	public Recipe() {
		super();
	}

	public Recipe(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + "]";
	}
	
	
}
