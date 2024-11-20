package com.habit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habit.dto.CategoryDTO;
import com.habit.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/category")
	public ResponseEntity<Void> saveCategory(@RequestBody CategoryDTO category) {

		categoryService.saveCategory(category);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO category, @PathVariable Long id) {

		categoryService.updateCategory(category, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
		CategoryDTO categoryDTO = categoryService.getCategory(id);
		return ResponseEntity.ok().body(categoryDTO);
	}

	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}

}
