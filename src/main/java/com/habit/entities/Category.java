package com.habit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

//entity por que vai trabalhar com banco de dados.
//entity se refere a tabela de banco de dados. 
// ---> como mapear a chave estrangeira com o JPA 

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
	@SequenceGenerator(name = "seq_category", sequenceName = "seq_category", allocationSize = 1)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "un")
	@Enumerated(EnumType.STRING)// ja salvamos como String o ENUM aqui <- se não salva como inteiro...
	private CategoryUnity categoryUnity;

	public Long getId() {
		return id;
	}

	public Category() {
	}

	public Category(Long id, String name, CategoryUnity categoryUnity) {
		this.id = id;
		this.name = name;
		this.categoryUnity = categoryUnity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryUnity getUn() {
		return categoryUnity;
	}

	public void setUn(CategoryUnity categoryUnity) {
		this.categoryUnity = categoryUnity;
	}

}
