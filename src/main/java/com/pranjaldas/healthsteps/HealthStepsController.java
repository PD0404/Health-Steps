package com.pranjaldas.healthsteps;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranjaldas.healthsteps.dto.IndividualLeaderboardDTO;
import com.pranjaldas.healthsteps.dto.StepStatisticsDTO;
import com.pranjaldas.healthsteps.dto.TeamLeaderboardDTO;
import com.pranjaldas.healthsteps.dto.UserReportDTO;
import com.pranjaldas.healthsteps.service.IndividualLeaderboardService;
import com.pranjaldas.healthsteps.service.StepStatisticsService;
import com.pranjaldas.healthsteps.service.TeamLeaderboardService;
import com.pranjaldas.healthsteps.service.UserReportService;

@RestController
@RequestMapping("/stepsdata")
public class HealthStepsController {

    private final IndividualLeaderboardService individualLeaderboardService;
    private final TeamLeaderboardService teamLeaderboardService;
    private final StepStatisticsService stepStatisticsService;
    private final UserReportService userReportService;

    public HealthStepsController(IndividualLeaderboardService individualLeaderboardService, TeamLeaderboardService teamLeaderboardService, 
                                StepStatisticsService statisticsService, UserReportService userReportService) {
        this.individualLeaderboardService = individualLeaderboardService;
        this.teamLeaderboardService = teamLeaderboardService;
        this.stepStatisticsService = statisticsService;
        this.userReportService = userReportService;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Welcome to Health Steps Challenge!";
    }

    // Fetch and process individual stepsdata from MySQL
    @GetMapping("/individualranking")
    public List<IndividualLeaderboardDTO> getIndividualRank(@RequestParam("date") Date inputDate) {
        return individualLeaderboardService.getIndividualRankList(inputDate); //// Call the service method to fetch records
    }

    // Fetch and process team stepsdata from MySQL
    @GetMapping("/teamranking")
    public List<TeamLeaderboardDTO> getTeamRank(@RequestParam("date") Date inputDate) {
        return teamLeaderboardService.getTeamRankList(inputDate); //// Call the service method to fetch records
    }

    // Fetch and process step statistics data from MySQL
    @GetMapping("/stepstatistics")
    public List<StepStatisticsDTO> getStepStatistics() {
        return stepStatisticsService.getStepStatisticsList(); //// Call the service method to fetch records
    }

    // Fetch and process daily steps count data from MySQL
    @GetMapping("/userreport")
    public List<UserReportDTO> getUserReport(@RequestParam("dateStart") Date dateRangeStart, @RequestParam("dateEnd") Date dateRangeEnd) {
        return userReportService.getUserReportList(dateRangeStart, dateRangeEnd); //// Call the service method to fetch records
    }
}
