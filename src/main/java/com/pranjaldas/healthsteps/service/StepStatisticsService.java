package com.pranjaldas.healthsteps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pranjaldas.healthsteps.bean.StepsDataBean;
import com.pranjaldas.healthsteps.dto.StepStatisticsDTO;

@Service
public class StepStatisticsService {

    private final StepsDataBean stepsDataBean;

    public StepStatisticsService(StepsDataBean stepsDataBean) {
        this.stepsDataBean = stepsDataBean;
    }

    //To transform the raw query result into the StepStatisticsDTO.
    public List<StepStatisticsDTO> getStepStatisticsList() {
        List<Object[]> rawResults = stepsDataBean.getStepStatisticsRecords();
        return rawResults.stream()
                .map(row -> new StepStatisticsDTO(
                        (Integer) row[0],   // userId
                        (String) row[1],    // username
                        ((Number) row[2]).intValue(),    // minSteps
                        ((Number) row[3]).intValue(),    // meanSteps
                        ((Number) row[4]).intValue(),    // maxSteps
                        ((Number) row[5]).intValue()    // rank
                ))
                .toList();
    }
}
