package com.sharad.quizbowlclassifier.category;

import java.util.ArrayList;
import java.util.List;

public class Supercategory {
	String name;
	List<Category> categories;

	public Supercategory(String name) {
		this.name = name;
		categories = new ArrayList<Category>();
	}

	public void addCategory(String categoryName) {
		categories.add(new Category(name, this));
	}

	public String getName() {
		return name;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object obj) {
		if (obj.toString().equals(toString()))
			return true;
		else
			return false;
	}

}
