package com.habit.dto;

public class GoalsDTO {

	private Double quantity;
	private Long categoryId;

	public GoalsDTO() {
	}

	public GoalsDTO(Double quantity, Long categoryId) {
		this.quantity = quantity;
		this.categoryId = categoryId;

	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
