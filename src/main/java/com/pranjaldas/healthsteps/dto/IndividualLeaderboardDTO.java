package com.pranjaldas.healthsteps.dto;

//A Data Transfer Object (DTO) class to encapsulate the output fields
public class IndividualLeaderboardDTO {
    
    private Integer userId;

    private String username;

    private Integer totalScore;
    
    private Integer rank;

    public IndividualLeaderboardDTO(Integer userId, String username, Integer totalScore, Integer rank) {
        this.userId = userId;
        this.username = username;
        this.totalScore = totalScore;
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

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    
}
