package com.habit.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habit.dto.HabitEntryDTO;
import com.habit.entities.Category;
import com.habit.entities.HabitEntry;
import com.habit.repositories.CategoryRepository;
import com.habit.repositories.HabitEntryRepository;

@Service
public class HabitEntryService {

	@Autowired
	private HabitEntryRepository habitEntryRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public void saveHabit(HabitEntryDTO habitEntryDTO) {

		HabitEntry habitEntry = new HabitEntry();
		Optional<Category> category = categoryRepository.findById(habitEntryDTO.getCategoryId());

		if (category.isPresent()) {
			habitEntry.setCategory(category.get());
			habitEntry.setQuantity(habitEntryDTO.getQuantity());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(habitEntryDTO.getDateHabit(), formatter);

			habitEntry.setDate_habit(dateTime);
			habitEntry.setDescription(habitEntryDTO.getDescription());

			habitEntryRepository.save(habitEntry);
		} else {
			throw new RuntimeException("Category is not found" + habitEntryDTO.getCategoryId());
		}

	}

	public void updateHabit(HabitEntryDTO habitEntryDTO, Long id) {

		Optional<HabitEntry> habitEntry = habitEntryRepository.findById(id);
		Optional<Category> category = categoryRepository.findById(habitEntryDTO.getCategoryId());
		if (category.isPresent() && habitEntry.isPresent()) {
			HabitEntry hab = habitEntry.get();
			hab.setCategory(category.get());
			hab.setQuantity(habitEntryDTO.getQuantity());

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			LocalDateTime dateTime = LocalDateTime.parse(habitEntryDTO.getDateHabit(), formatter);

			hab.setDate_habit(dateTime);
			hab.setDescription(habitEntryDTO.getDescription());

			habitEntryRepository.save(hab);

		} else {
			throw new RuntimeException(
					"Category is not found or habit is not found" + " Habit: " + habitEntry + "Category: " + category);
		}
	}

	public HabitEntryDTO getHabit(Long id) {
		Optional<HabitEntry> habitEntry = habitEntryRepository.findById(id);
		HabitEntryDTO habitEntryDTO = new HabitEntryDTO();
		if (habitEntry.isPresent()) {
			HabitEntry hab = habitEntry.get();
			habitEntryDTO.setCategoryId(hab.getId());
			habitEntryDTO.setDescription(hab.getDescription());
			habitEntryDTO.setQuantity(hab.getQuantity());

			DateTimeFormatter dts1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			habitEntryDTO.setDateHabit(hab.getDate_habit().format(dts1));
		}

		return habitEntryDTO;
	}

	public List<HabitEntryDTO> getByCategory(Long categoryId) {
		List<HabitEntry> habitEntries = habitEntryRepository.findByCategoryId(categoryId);
		List<HabitEntryDTO> habitEntryDTOs = new ArrayList<>();
		for (HabitEntry habitEntry : habitEntries) {
			HabitEntryDTO hab = new HabitEntryDTO();
			hab.setCategoryId(habitEntry.getCategory().getId());
			hab.setDateHabit(habitEntry.getDate_habit().toString());
			hab.setDescription(habitEntry.getDescription());
			hab.setQuantity(habitEntry.getQuantity());

			habitEntryDTOs.add(hab);
		}
		return habitEntryDTOs;
	}

	public void deleteHabit(Long id) {
		habitEntryRepository.deleteById(id);
	}
	
	

}
