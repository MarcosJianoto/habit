package com.habit.report;

import java.util.List;

import com.habit.entities.CategoryUnity;

public class ReportCategoryDTO {

	private String name;
	private Double goalQuantity;
	private CategoryUnity un;
	private List<ReportHabitEntryDTO> reportHabitEntryDTOs;

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

	public List<ReportHabitEntryDTO> getReportHabitEntryDTOs() {
		return reportHabitEntryDTOs;
	}

	public void setReportHabitEntryDTOs(List<ReportHabitEntryDTO> reportHabitEntryDTOs) {
		this.reportHabitEntryDTOs = reportHabitEntryDTOs;
	}

}
