package com.habit.report;

import com.habit.entities.CategoryUnity;

public class ReportComparateCategorysDTO {

	private String name;
	private Integer days;
	private Double daysCompleted;
	private CategoryUnity un;
	private Double percentageComplete;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getDaysCompleted() {
		return daysCompleted;
	}

	public void setDaysCompleted(Double daysCompleted) {
		this.daysCompleted = daysCompleted;
	}

	public CategoryUnity getUn() {
		return un;
	}

	public void setUn(CategoryUnity un) {
		this.un = un;
	}

	public Double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(Double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

}
