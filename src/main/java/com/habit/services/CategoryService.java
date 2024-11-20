package com.habit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habit.dto.CategoryDTO;
import com.habit.entities.Category;
import com.habit.repositories.CategoryRepository;

@Service

public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void saveCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		category.setUn(categoryDTO.getCategoryUnity());

		categoryRepository.save(category);
	}

	public void updateCategory(CategoryDTO categoryDTO, Long id) {

		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			category.get().setName(categoryDTO.getName());
			category.get().setUn(categoryDTO.getCategoryUnity());
			categoryRepository.save(category.get());
		}
	}

	public CategoryDTO getCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		CategoryDTO dto = new CategoryDTO();
		if (category.isPresent()) {
			dto.setName(category.get().getName());
			dto.setCategoryUnity(category.get().getUn());
		}
		return dto;

	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
