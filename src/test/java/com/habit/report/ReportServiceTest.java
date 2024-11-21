package com.habit.report;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.habit.repositories.GoalsRepository;
import com.habit.repositories.HabitEntryRepository;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

	@InjectMocks
	private ReportService reportService;

	@Mock
	private GoalsRepository goalsRepository;

	@Mock
	private HabitEntryRepository habitEntryRepository;

	@Test
	void shouldReturnCategoryInUseDTOWhenGoalsExist() {

	}

}
