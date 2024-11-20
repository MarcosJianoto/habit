package com.habit.report;

import com.habit.entities.CategoryUnity;

public class ReportWeekDTO {

	private String name;
	private Double maxActivityDay;
	private Double minActivityDay;
	private Double weekAverage;
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

	public Double getWeekAverage() {
		return weekAverage;
	}

	public void setWeekAverage(Double weekAverage) {
		this.weekAverage = weekAverage;
	}

	public CategoryUnity getUn() {
		return un;
	}

	public void setUn(CategoryUnity un) {
		this.un = un;
	}

}
