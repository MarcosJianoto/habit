package com.habit.report;

import java.time.LocalDateTime;

public class ReportDTO {

	private String name;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	private Long habitId;
	private Long categoryId;
	private Double totalQuantity;
	private Double averageQuantityPerDay;

	public ReportDTO() {
	}

	public ReportDTO(String name, LocalDateTime startDate, LocalDateTime finishDate, Long categoryId, Long habitId,
			Double totalQuantity, Double averageQuantityPerDay) {
		this.name = name;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.categoryId = categoryId;
		this.habitId = habitId;
		this.totalQuantity = totalQuantity;
		this.averageQuantityPerDay = averageQuantityPerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getHabitId() {
		return habitId;
	}

	public void setHabitId(Long habitId) {
		this.habitId = habitId;
	}

	public Double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getAverageQuantityPerDay() {
		return averageQuantityPerDay;
	}

	public void setAverageQuantityPerDay(Double averageQuantityPerDay) {
		this.averageQuantityPerDay = averageQuantityPerDay;
	}

}
