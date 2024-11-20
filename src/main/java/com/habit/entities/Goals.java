package com.habit.entities;

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
@Table(name = "goals")
public class Goals {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_frequency")
	@SequenceGenerator(name = "seq_frequency", sequenceName = "seq_frequency", allocationSize = 1)
	private Long id;

	@Column(name = "quantity")
	private Double quantity;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public Goals() {
	}

	public Goals(Long id, Double quantity, Category category) {
		this.id = id;
		this.quantity = quantity;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
