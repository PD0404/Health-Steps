package com.pranjaldas.healthsteps.dto;

public class StepStatisticsDTO {

    private Integer userId;

    private String username;

    private Integer minSteps;

    private Integer meanSteps;

    private Integer maxSteps;
    
    private Integer rank;

    public StepStatisticsDTO(Integer userId, String username, Integer minSteps, Integer meanSteps, Integer maxSteps, Integer rank) {
        this.userId = userId;
        this.username = username;
        this.minSteps = minSteps;
        this.meanSteps = meanSteps;
        this.maxSteps = maxSteps;
        this.rank = rank;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getMinSteps() {
        return minSteps;
    }

    public void setMinSteps(Integer minSteps) {
        this.minSteps = minSteps;
    }

    public Integer getMeanSteps() {
        return meanSteps;
    }

    public void setMeanSteps(Integer meanSteps) {
        this.meanSteps = meanSteps;
    }

    public Integer getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(Integer maxSteps) {
        this.maxSteps = maxSteps;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    
}
