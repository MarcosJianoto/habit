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

import com.habit.dto.GoalsDTO;
import com.habit.services.GoalsService;

@RestController
public class GoalsController {

	@Autowired
	private GoalsService goalsService;

	@PostMapping("/goals")
	public ResponseEntity<Void> saveFrequency(@RequestBody GoalsDTO frequency) {

		goalsService.saveFrequency(frequency);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/goals/{id}")
	public ResponseEntity<Void> updateFrequency(@RequestBody GoalsDTO frequency, @PathVariable Long id) {

		goalsService.updateFrequency(frequency, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/goals/{id}")
	public ResponseEntity<GoalsDTO> getFrequency(@PathVariable Long id) {
		GoalsDTO goalsDTO = goalsService.getFrequency(id);
		return ResponseEntity.ok().body(goalsDTO);
	}

	@GetMapping("/goals/category/{categoryId}")
	public ResponseEntity<List<GoalsDTO>> getFrequencyByCategoryId(@PathVariable Long categoryId) {
		List<GoalsDTO> goalsDTO = goalsService.getFrequencyByCategoryId(categoryId);
		return ResponseEntity.ok().body(goalsDTO);
	}

	@DeleteMapping("/goals/{id}")
	public void deleteFrequency(@PathVariable Long id) {

		goalsService.deleteFrequency(id);
	}

}
