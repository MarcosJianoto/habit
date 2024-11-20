package com.habit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habit.dto.HabitEntryDTO;
import com.habit.services.HabitEntryService;

@RestController
public class HabitEntryController {

	@Autowired
	private HabitEntryService habitEntryService;

	@PostMapping("/habitentry")
	public ResponseEntity<Void> saveHabit(@RequestBody HabitEntryDTO habit) {

		habitEntryService.saveHabit(habit);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/habitentry/{id}")
	public ResponseEntity<Void> updateHabit(@RequestBody HabitEntryDTO habit, @PathVariable Long id) {

		habitEntryService.updateHabit(habit, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/habitentry/{id}")
	public ResponseEntity<HabitEntryDTO> getHabit(@PathVariable Long id) {

		HabitEntryDTO habitEntryDTO = habitEntryService.getHabit(id);
		return ResponseEntity.ok().body(habitEntryDTO);
	}

	@GetMapping("/habitentry/category/{categoryId}")
	public ResponseEntity<List<HabitEntryDTO>> getHabitCategoryId(@PathVariable Long categoryId) {
		List<HabitEntryDTO> habitEntryDTO = habitEntryService.getByCategory(categoryId);
		return ResponseEntity.ok().body(habitEntryDTO);
	}

	@DeleteMapping("/habitentry/{id}")
	public ResponseEntity<Void> deleteHabit(@PathVariable Long id) {
		habitEntryService.deleteHabit(id);
		return ResponseEntity.ok().build();
	}
}
