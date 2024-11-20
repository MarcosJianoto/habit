package com.habit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habit.dto.GoalsDTO;
import com.habit.entities.Category;
import com.habit.entities.Goals;
import com.habit.repositories.CategoryRepository;
import com.habit.repositories.GoalsRepository;

@Service
public class GoalsService {

	@Autowired
	private GoalsRepository goalsRepository;
	@Autowired
	private CategoryRepository categoryRepository;


	public void saveFrequency(GoalsDTO goalsDTO) {
		Goals freq = new Goals();
		Optional<Category> category = categoryRepository.findById(goalsDTO.getCategoryId());

		if (category.isPresent()) {

			freq.setCategory(category.get());
			freq.setQuantity(goalsDTO.getQuantity());

			goalsRepository.save(freq);
		} else {
			throw new IllegalArgumentException("Category not found with ID: " + goalsDTO.getCategoryId());
		}

	}

	public void updateFrequency(GoalsDTO goalsDTO, Long id) {

		Optional<Goals> goals = goalsRepository.findById(id);
		Optional<Category> category = categoryRepository.findById(goalsDTO.getCategoryId());
		if (goals.isPresent() && category.isPresent()) {
			Goals freq = goals.get();
			freq.setCategory(category.get());
			freq.setQuantity(goalsDTO.getQuantity());

			goalsRepository.save(freq);
		} else {
			throw new NoSuchElementException("Frequency or category not found for given Ids");
		}
	}

	public GoalsDTO getFrequency(Long id) {
		Optional<Goals> goals = goalsRepository.findById(id);
		GoalsDTO goalsDTO = new GoalsDTO();
		if (goals.isPresent()) {
			Goals freq = goals.get();
			goalsDTO.setCategoryId(freq.getCategory().getId());
			goalsDTO.setQuantity(freq.getQuantity());

		} else {
			throw new NoSuchElementException("Frequency or category not found for given Ids");
		}
		return goalsDTO;

	}

	public List<GoalsDTO> getFrequencyByCategoryId(Long categoryId) {
		List<Goals> frequencys = goalsRepository.findByCategoryId(categoryId);
		List<GoalsDTO> goalsDTOs = new ArrayList<>();
		for (Goals freq : frequencys) {
			GoalsDTO dto = new GoalsDTO();
			dto.setQuantity(freq.getQuantity());
			dto.setCategoryId(freq.getCategory().getId());

			goalsDTOs.add(dto);
		}
		if (goalsDTOs.isEmpty()) {
			throw new NoSuchElementException("Frequency not found for given Ids");
		} else {
			return goalsDTOs;
		}
	}

	public void deleteFrequency(Long id) {
		goalsRepository.deleteById(id);
	}

}
