package com.habit.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habit.entities.Category;
import com.habit.entities.HabitEntry;

public interface HabitEntryRepository extends JpaRepository<HabitEntry, Long> {

	List<HabitEntry> findByCategoryId(Long categoryId);

	List<HabitEntry> findByCategoryAndDateHabitBetween(Category category, LocalDateTime startDate,
			LocalDateTime finishDate);

	List<HabitEntry> findByDateHabitBetween(LocalDateTime startDate, LocalDateTime finishDate);

}
