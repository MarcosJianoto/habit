package com.habit.dto;

public class HabitEntryDTO {

	private Long categoryId;
	private Double quantity;
	private String dateHabit;
	private String description;

	public HabitEntryDTO() {
	}

	public HabitEntryDTO(Long categoryId, Double quantity, String dateHabit, String description) {
		this.categoryId = categoryId;
		this.quantity = quantity;
		this.dateHabit = dateHabit;
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public String getDateHabit() {
		return dateHabit;
	}

	public void setDateHabit(String dateHabit) {
		this.dateHabit = dateHabit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
