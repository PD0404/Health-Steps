package com.pranjaldas.healthsteps.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjaldas.healthsteps.bean.StepsDataBean;
import com.pranjaldas.healthsteps.dto.IndividualLeaderboardDTO;

@Service
public class IndividualLeaderboardService {

    private final StepsDataBean stepsDataBean;

    public IndividualLeaderboardService(StepsDataBean stepsDataBean) {
        this.stepsDataBean = stepsDataBean;
    }

    //To transform the raw query result into the IndividualLeaderboardDTO.
    public List<IndividualLeaderboardDTO> getIndividualRankList(Date inputDate) {
        List<Object[]> rawResults = stepsDataBean.getIndividualRankRecords(inputDate);
        return rawResults.stream()
                .map(row -> new IndividualLeaderboardDTO(
                        (Integer) row[0],   // userId
                        (String) row[1],    // username
                        ((BigDecimal) row[2]).intValue(),    // totalScore, Convert BigDecimal to Integer
                        ((Number) row[3]).intValue()    // rank
                ))
                .toList();
    }
}
