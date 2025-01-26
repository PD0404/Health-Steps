package com.pranjaldas.healthsteps.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjaldas.healthsteps.bean.DailyStepsCountBean;
import com.pranjaldas.healthsteps.dto.UserReportDTO;

@Service
public class UserReportService {

    private final DailyStepsCountBean dailyStepsCountBean;

    public UserReportService(DailyStepsCountBean dailyStepsCountBean) {
        this.dailyStepsCountBean = dailyStepsCountBean;
    }

    //To transform the raw query result into the UserReportDTO.
    public List<UserReportDTO> getUserReportList(Date dateRangeStart, Date dateRangeEnd) {
        List<Object[]> rawResults = dailyStepsCountBean.getUserReportRecords(dateRangeStart, dateRangeEnd);
        return rawResults.stream()
                .map(row -> new UserReportDTO(
                        (Integer) row[0],   // userId
                        ((Number) row[1]).intValue(),   // totalDays
                        ((Number) row[2]).intValue(),   // daysInGold
                        ((Number) row[3]).intValue(),   // daysInSilver
                        ((Number) row[4]).intValue(),    // daysInBronze
                        ((Number) row[5]).floatValue(),   // percentageInGold
                        ((Number) row[6]).floatValue(),   // percentageInSilver
                        ((Number) row[7]).floatValue(),   // percentageInBronze
                        (String) row[8]    // primaryLeague
                ))
                .toList();
    }

}
