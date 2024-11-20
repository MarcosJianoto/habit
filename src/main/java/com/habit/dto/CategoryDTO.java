package com.habit.dto;

import com.habit.entities.CategoryUnity;

public class CategoryDTO {

	private String name;
	private CategoryUnity categoryUnity;

	public CategoryDTO() {
	}

	public CategoryDTO(String name, CategoryUnity categoryUnity) {
		this.name = name;
		this.categoryUnity = categoryUnity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryUnity getCategoryUnity() {
		return categoryUnity;
	}

	public void setCategoryUnity(CategoryUnity categoryUnity) {
		this.categoryUnity = categoryUnity;
	}

}
