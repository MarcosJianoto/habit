package com.habit.report;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/report/categoryinuse")
	public ResponseEntity<List<ReportCategoryInUseDTO>> reportCategoryInUse() {

		List<ReportCategoryInUseDTO> reportCategoryInUseDTOs = reportService.reportCategoryInUseDTO();
		return ResponseEntity.ok().body(reportCategoryInUseDTOs);

	}

	@GetMapping("/report/diarycomplete/{date}")
	public ResponseEntity<List<ReportDiaryDTO>> reportDiaryComplete(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {

		List<ReportDiaryDTO> reportDiaryDTO = reportService.reportGoalsDaily(date);
		return ResponseEntity.ok().body(reportDiaryDTO);

	}

	@GetMapping("/report/diarydetails/{date}")
	public ResponseEntity<List<ReportCategoryDTO>> reportDiaryDetails(
			@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {

		List<ReportCategoryDTO> reportCategoryDTOs = reportService.reportDetailEntryDailyGoals(date);
		return ResponseEntity.ok().body(reportCategoryDTOs);

	}

	@GetMapping("/report/reportresume")
	public ResponseEntity<List<ReportMonthDTO>> reportGoalsWeekResume() {

		List<ReportMonthDTO> reportMonthDTOs = reportService.reportGoalsWeekResume();
		return ResponseEntity.ok().body(reportMonthDTOs);

	}

	@GetMapping("/report/monthresume")
	public ResponseEntity<List<ReportMonthDTO>> reportGoalsMonthResume() {

		List<ReportMonthDTO> reportMonthDTOs = reportService.reportGoalsMonthResume();
		return ResponseEntity.ok().body(reportMonthDTOs);

	}

	@GetMapping("/report/editmonthresume/{period}")
	public ResponseEntity<List<ReportMonthDTO>> reportGoalsEditMonthResume(@PathVariable Integer period) {

		List<ReportMonthDTO> reportMonthDTOs = reportService.reportGoalsEditMonthResume(period);
		return ResponseEntity.ok().body(reportMonthDTOs);
	}

	@GetMapping("/report/editperiodresume/{period}")
	public ResponseEntity<List<GeneratedGoalsReportByPeriodDTO>> generateGoalsReportByPeriod(
			@PathVariable Integer period) {

		List<GeneratedGoalsReportByPeriodDTO> generatedGoalsReportByPeriodDTOs = reportService
				.generateGoalsReportByPeriod(period);
		return ResponseEntity.ok().body(generatedGoalsReportByPeriodDTOs);
	}

	@GetMapping("/report/comparetecategorys/{period}")
	public ResponseEntity<List<ReportComparateCategorysDTO>> compareteCategorys(@PathVariable Integer period) {

		List<ReportComparateCategorysDTO> reportComparateCategorysDTOs = reportService
				.comparatedCategorysRanking(period);
		return ResponseEntity.ok().body(reportComparateCategorysDTOs);
	}

}
