package com.habit.report;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habit.entities.Goals;
import com.habit.entities.HabitEntry;
import com.habit.repositories.GoalsRepository;
import com.habit.repositories.HabitEntryRepository;

@Service
public class ReportService {

	@Autowired
	private GoalsRepository goalsRepository;

	@Autowired
	private HabitEntryRepository habitEntryRepository;

	// me trás somente as categorias que existem.
	public List<ReportCategoryInUseDTO> reportCategoryInUseDTO() {

		List<Goals> goals = goalsRepository.findAll();
		List<ReportCategoryInUseDTO> reportCategoryInUseDTOs = new ArrayList<>();

		if (!goals.isEmpty()) {
			for (Goals goal : goals) {

				ReportCategoryInUseDTO reportCategoryInUseDTO = new ReportCategoryInUseDTO();

				reportCategoryInUseDTO.setName(goal.getCategory().getName());
				reportCategoryInUseDTO.setUn(goal.getCategory().getUn());
				reportCategoryInUseDTO.setGoalQuantity(goal.getQuantity());

				reportCategoryInUseDTOs.add(reportCategoryInUseDTO);

			}
		}

		return reportCategoryInUseDTOs;
	}

	// Report diary where frequency is complete and view percentage.
	public List<ReportDiaryDTO> reportGoalsDaily(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		LocalDateTime startDate = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
		LocalDateTime finishDate = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59, 0);

		List<ReportDiaryDTO> reportDiaryDTOs = new ArrayList<>();

		List<Goals> goals = goalsRepository.findAll();

		for (Goals goal : goals) {
			ReportDiaryDTO reportDiary = new ReportDiaryDTO();
			reportDiary.setCategory(goal.getCategory().getName());
			reportDiary.setCategoryUnity(goal.getCategory().getUn());
			reportDiary.setQuantity(goal.getQuantity());
			reportDiary.setStatus(Status.UNCOMPLETED);

			List<HabitEntry> habitEntries = habitEntryRepository.findByCategoryAndDateHabitBetween(goal.getCategory(),
					startDate, finishDate);

			Double sum = 0.0;
			for (HabitEntry habEntry : habitEntries) {
				sum += habEntry.getQuantity();
			}
			reportDiary.setEntries(sum);

			reportDiary.setPercentGoalDaily(sum / goal.getQuantity() * 100);

			if (reportDiary.getPercentGoalDaily() >= 100) {
				reportDiary.setStatus(Status.COMPLETED);
			}

			reportDiaryDTOs.add(reportDiary);

		}

		return reportDiaryDTOs;

	}

	public List<ReportCategoryDTO> reportDetailEntryDailyGoals(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		LocalDateTime startDate = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0, 0);
		LocalDateTime finishDate = LocalDateTime.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59, 0);

		List<ReportCategoryDTO> listReportCategoryDTOs = new ArrayList<>();

		List<Goals> goals = goalsRepository.findAll();

		for (Goals goal : goals) {

			List<ReportHabitEntryDTO> listReportHabitEntryDTOs = new ArrayList<>();

			ReportCategoryDTO reportCategoryDTO = new ReportCategoryDTO();

			reportCategoryDTO.setName(goal.getCategory().getName());
			reportCategoryDTO.setGoalQuantity(goal.getQuantity());
			reportCategoryDTO.setUn(goal.getCategory().getUn());

			List<HabitEntry> habitEntries = habitEntryRepository.findByCategoryAndDateHabitBetween(goal.getCategory(),
					startDate, finishDate);

			for (HabitEntry hab : habitEntries) {

				ReportHabitEntryDTO reportHabitEntryDTO = new ReportHabitEntryDTO();
				reportHabitEntryDTO.setDescription(hab.getDescription());
				reportHabitEntryDTO.setQuantity(hab.getQuantity());
				reportHabitEntryDTO.setDateHabit(hab.getDate_habit().toString());

				listReportHabitEntryDTOs.add(reportHabitEntryDTO);

				reportCategoryDTO.setReportHabitEntryDTOs(listReportHabitEntryDTOs);
			}

			listReportCategoryDTOs.add(reportCategoryDTO);

		}

		return listReportCategoryDTOs;
	}

	private List<ReportMonthDTO> baseReportMonth(LocalDateTime startDate, LocalDateTime finishDate, Integer period) {

		List<ReportMonthDTO> reportMonthDTOs = new ArrayList<>();

		List<Goals> goals = goalsRepository.findAll();

		if (!goals.isEmpty()) {

			for (Goals goal : goals) {
				List<HabitEntry> habitEntries = habitEntryRepository
						.findByCategoryAndDateHabitBetween(goal.getCategory(), startDate, finishDate);

				ReportMonthDTO reportMonthDTO = new ReportMonthDTO();
				reportMonthDTO.setName(goal.getCategory().getName());
				reportMonthDTO.setUn(goal.getCategory().getUn());

				Double maxActivity = 0.0;
				for (HabitEntry hab : habitEntries) {
					if (hab.getQuantity() > maxActivity) {
						maxActivity = hab.getQuantity();
					}
				}
				reportMonthDTO.setMaxActivityDay(maxActivity);

				Double minActivity = maxActivity;
				for (HabitEntry hab : habitEntries) {
					if (hab.getQuantity() < minActivity) {
						minActivity = hab.getQuantity();
					}
				}

				Double weekAverageSum = 0.0;
				for (HabitEntry hab : habitEntries) {
					weekAverageSum += hab.getQuantity();
				}
				Double weekAverage = weekAverageSum / period;

				reportMonthDTO.setMinActivityDay(minActivity);
				reportMonthDTO.setMonthAverage(weekAverage);

				reportMonthDTOs.add(reportMonthDTO);
			}
		}
		return reportMonthDTOs;

	}

	public List<ReportMonthDTO> reportGoalsWeekResume() {

		Integer period = 7;
		LocalDateTime finishDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).minusNanos(1);
		LocalDateTime startDate = finishDate.minusDays(period).truncatedTo(ChronoUnit.DAYS);

		return baseReportMonth(startDate, finishDate, period);
	}

	public List<ReportMonthDTO> reportGoalsMonthResume() {

		Integer period = 30;
		LocalDateTime finishDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).minusNanos(1);
		LocalDateTime startDate = finishDate.minusDays(period).truncatedTo(ChronoUnit.DAYS);

		return baseReportMonth(startDate, finishDate, period);
	}

	public List<ReportMonthDTO> reportGoalsEditMonthResume(Integer period) {

		Integer periodInteger = period * 30;
		LocalDateTime finishDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).minusNanos(1);
		LocalDateTime startDate = finishDate.minusDays(periodInteger).truncatedTo(ChronoUnit.DAYS);

		return baseReportMonth(startDate, finishDate, periodInteger);

	}

	public List<GeneratedGoalsReportByPeriodDTO> generateGoalsReportByPeriod(Integer period) {

		LocalDateTime finishDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).minusNanos(1);
		LocalDateTime startDate = finishDate.minusDays(period).truncatedTo(ChronoUnit.DAYS);

		List<GeneratedGoalsReportByPeriodDTO> generatedGoalsReportByPeriodDTOs = new ArrayList<>();

		List<Goals> goals = goalsRepository.findAll();

		if (!goals.isEmpty()) {

			for (Goals goal : goals) {
				List<HabitEntry> habitEntries = habitEntryRepository
						.findByCategoryAndDateHabitBetween(goal.getCategory(), startDate, finishDate);

				GeneratedGoalsReportByPeriodDTO generatedGoalsReportByPeriodDTO = new GeneratedGoalsReportByPeriodDTO();
				generatedGoalsReportByPeriodDTO.setName(goal.getCategory().getName());
				generatedGoalsReportByPeriodDTO.setUn(goal.getCategory().getUn());

				Double maxActivity = 0.0;
				for (HabitEntry hab : habitEntries) {
					if (hab.getQuantity() > maxActivity) {
						maxActivity = hab.getQuantity();
					}
				}
				generatedGoalsReportByPeriodDTO.setMaxActivityDay(maxActivity);

				Double minActivity = maxActivity;
				for (HabitEntry hab : habitEntries) {
					if (hab.getQuantity() < minActivity) {
						minActivity = hab.getQuantity();
					}
				}

				Double goalsReportByPeriod = 0.0;
				for (HabitEntry hab : habitEntries) {
					goalsReportByPeriod += hab.getQuantity();
				}
				Double goalsReportByPeriodAverage = goalsReportByPeriod / period;

				generatedGoalsReportByPeriodDTO.setMinActivityDay(minActivity);
				generatedGoalsReportByPeriodDTO.setDaysAverage(goalsReportByPeriodAverage);

				generatedGoalsReportByPeriodDTOs.add(generatedGoalsReportByPeriodDTO);
			}

		}
		return generatedGoalsReportByPeriodDTOs;
	}

	public List<ReportComparateCategorysDTO> comparatedCategorysRanking(Integer period) {

		LocalDateTime finishDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS).minusNanos(1);
		LocalDateTime startDate = finishDate.minusDays(period).truncatedTo(ChronoUnit.DAYS);

		List<ReportComparateCategorysDTO> reportComparateCategorysDTOs = new ArrayList<>();

		List<Goals> goals = goalsRepository.findAll();

		if (!goals.isEmpty()) {

			for (Goals goal : goals) {
				List<HabitEntry> habitEntries = habitEntryRepository
						.findByCategoryAndDateHabitBetween(goal.getCategory(), startDate, finishDate);

				ReportComparateCategorysDTO reportComparateCategorysDTO = new ReportComparateCategorysDTO();
				reportComparateCategorysDTO.setName(goal.getCategory().getName());
				reportComparateCategorysDTO.setUn(goal.getCategory().getUn());
				reportComparateCategorysDTO.setDays(period);

				Double daysComplete = 0.0;

				Map<LocalDate, Double> dailyQuantities = new HashMap<>();
				for (HabitEntry habitEntry : habitEntries) {
					LocalDate entryDate = habitEntry.getDate_habit().toLocalDate();
					dailyQuantities.put(entryDate,
							dailyQuantities.getOrDefault(entryDate, 0.0) + habitEntry.getQuantity());
				}

				for (Double dailyTotal : dailyQuantities.values()) {
					if (dailyTotal >= goal.getQuantity()) {
						daysComplete++;
					}
				}

				System.out.println(daysComplete);
				reportComparateCategorysDTO.setDaysCompleted(daysComplete);

				reportComparateCategorysDTO.setPercentageComplete(daysComplete / period.doubleValue() * 100);
				reportComparateCategorysDTOs.add(reportComparateCategorysDTO);

			}

		}
		return reportComparateCategorysDTOs;
	}

}
