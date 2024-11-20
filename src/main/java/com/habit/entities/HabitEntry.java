package com.habit.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="habitentry")
public class HabitEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habit")
	@SequenceGenerator(name = "seq_habit", sequenceName = "seq_habit", allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(name = "quantity")
	private Double quantity;

	@Column(name = "date_habit")
	private LocalDateTime dateHabit;

	@Column(name = "description")
	private String description;

	public HabitEntry() {
	}

	public HabitEntry(Long id, Category category, Double quantity, LocalDateTime dateHabit, String description) {
		this.id = id;
		this.category = category;
		this.quantity = quantity;
		this.dateHabit = dateHabit;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getDate_habit() {
		return dateHabit;
	}

	public void setDate_habit(LocalDateTime dateHabit) {
		this.dateHabit = dateHabit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
