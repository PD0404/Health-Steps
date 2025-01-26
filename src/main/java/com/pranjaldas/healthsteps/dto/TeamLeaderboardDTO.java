package com.pranjaldas.healthsteps.dto;

public class TeamLeaderboardDTO {

    private Integer teamId;

    private String teamName;

    private Integer totalTeamScore;
    
    private Integer rank;

    public TeamLeaderboardDTO(Integer teamId, String teamName, Integer totalTeamScore, Integer rank) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.totalTeamScore = totalTeamScore;
        this.rank = rank;
    }

    // Getters and Setters
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTotalTeamScore() {
        return totalTeamScore;
    }

    public void setTotalTeamScore(Integer totalTeamScore) {
        this.totalTeamScore = totalTeamScore;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
    
}
