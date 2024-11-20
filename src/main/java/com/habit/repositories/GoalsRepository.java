package com.habit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habit.entities.Goals;

public interface GoalsRepository extends JpaRepository<Goals, Long> {

	List<Goals> findByCategoryId(Long categoryId);

}
