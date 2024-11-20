package com.habit.report;

import com.habit.entities.CategoryUnity;

public class ReportMonthDTO {

	private String name;
	private Double maxActivityDay;
	private Double minActivityDay;
	private Double monthAverage;
	private CategoryUnity un;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaxActivityDay() {
		return maxActivityDay;
	}

	public void setMaxActivityDay(Double maxActivityDay) {
		this.maxActivityDay = maxActivityDay;
	}

	public Double getMinActivityDay() {
		return minActivityDay;
	}

	public void setMinActivityDay(Double minActivityDay) {
		this.minActivityDay = minActivityDay;
	}

	public Double getMonthAverage() {
		return monthAverage;
	}

	public void setMonthAverage(Double monthAverage) {
		this.monthAverage = monthAverage;
	}

	public CategoryUnity getUn() {
		return un;
	}

	public void setUn(CategoryUnity un) {
		this.un = un;
	}

}
