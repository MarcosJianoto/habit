package com.habit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habit.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


}
