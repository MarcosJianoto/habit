package com.habit.report;

import com.habit.entities.CategoryUnity;

public class ReportCategoryInUseDTO {

	private String name;
	private Double goalQuantity;
	private CategoryUnity un;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGoalQuantity() {
		return goalQuantity;
	}

	public void setGoalQuantity(Double goalQuantity) {
		this.goalQuantity = goalQuantity;
	}

	public CategoryUnity getUn() {
		return un;
	}

	public void setUn(CategoryUnity un) {
		this.un = un;
	}

}
