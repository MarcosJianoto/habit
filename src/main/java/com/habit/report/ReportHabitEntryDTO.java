package com.habit.report;

public class ReportHabitEntryDTO {

	private String description;
	private String dateHabit;
	private Double quantity;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateHabit() {
		return dateHabit;
	}

	public void setDateHabit(String dateHabit) {
		this.dateHabit = dateHabit;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
