package com.habit.report;

import com.habit.entities.CategoryUnity;

public class ReportDiaryDTO {

	private String category;
	private Double quantity;
	private CategoryUnity categoryUnity;
	private Double entries;
	private Status status;
	private Double percentGoalDaily;

	public ReportDiaryDTO() {
	}

	public ReportDiaryDTO(String category, Double quantity, CategoryUnity categoryUnity, Double entries, Status status,
			Double percentGoalDaily) {
		this.category = category;
		this.quantity = quantity;
		this.categoryUnity = categoryUnity;
		this.entries = entries;
		this.status = status;
		this.percentGoalDaily = percentGoalDaily;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public CategoryUnity getCategoryUnity() {
		return categoryUnity;
	}

	public void setCategoryUnity(CategoryUnity categoryUnity) {
		this.categoryUnity = categoryUnity;
	}

	public Double getEntries() {
		return entries;
	}

	public void setEntries(Double entries) {
		this.entries = entries;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getPercentGoalDaily() {
		return percentGoalDaily;
	}

	public void setPercentGoalDaily(Double percentage) {
		this.percentGoalDaily = percentage;
	}

}
