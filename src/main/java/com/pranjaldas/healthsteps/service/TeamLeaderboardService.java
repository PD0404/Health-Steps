package com.pranjaldas.healthsteps.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjaldas.healthsteps.bean.StepsDataBean;
import com.pranjaldas.healthsteps.dto.TeamLeaderboardDTO;

@Service
public class TeamLeaderboardService {
    
    private final StepsDataBean stepsDataBean;

    public TeamLeaderboardService(StepsDataBean stepsDataBean) {
        this.stepsDataBean = stepsDataBean;
    }

    //To transform the raw query result into the TeamLeaderboardDTO.
    public List<TeamLeaderboardDTO> getTeamRankList(Date inputDate) {
        List<Object[]> rawResults = stepsDataBean.getTeamRankRecords(inputDate);
        return rawResults.stream()
                .map(row -> new TeamLeaderboardDTO(
                        (Integer) row[0],   // teamId
                        (String) row[1],    // teamName
                        ((BigDecimal) row[2]).intValue(),    // totalTeamScore, Convert BigDecimal to Integer
                        ((Number) row[3]).intValue()    // rank
                ))
                .toList();
    }
}
