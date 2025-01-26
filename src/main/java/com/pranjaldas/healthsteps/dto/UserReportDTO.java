package com.pranjaldas.healthsteps.dto;

public class UserReportDTO {

    private Integer userId;
    
    private Integer totalDays;
    
    private Integer daysInGold;

    private Integer daysInSilver;

    private Integer daysInBronze;

    private Float percentageInGold;

    private Float percentageInSilver;

    private Float percentageInBronze;

    private String primaryLeague;

    public UserReportDTO(Integer userId, Integer totalDays, Integer daysInGold, Integer daysInSilver,
            Integer daysInBronze, Float percentageInGold, Float percentageInSilver, Float percentageInBronze, String primaryLeague) {
        this.userId = userId;
        this.totalDays = totalDays;
        this.daysInGold = daysInGold;
        this.daysInSilver = daysInSilver;
        this.daysInBronze = daysInBronze;
        this.percentageInGold = percentageInGold;
        this.percentageInSilver = percentageInSilver;
        this.percentageInBronze = percentageInBronze;
        this.primaryLeague = primaryLeague;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getDaysInGold() {
        return daysInGold;
    }

    public void setDaysInGold(Integer daysInGold) {
        this.daysInGold = daysInGold;
    }

    public Integer getDaysInSilver() {
        return daysInSilver;
    }

    public void setDaysInSilver(Integer daysInSilver) {
        this.daysInSilver = daysInSilver;
    }

    public Integer getDaysInBronze() {
        return daysInBronze;
    }

    public void setDaysInBronze(Integer daysInBronze) {
        this.daysInBronze = daysInBronze;
    }  
    
    public Float getPercentageInGold() {
        return percentageInGold;
    }

    public void setPercentageInGold(Float percentageInGold) {
        this.percentageInGold = percentageInGold;
    }

    public Float getPercentageInSilver() {
        return percentageInSilver;
    }

    public void setPercentageInSilver(Float percentageInSilver) {
        this.percentageInSilver = percentageInSilver;
    }

    public Float getPercentageInBronze() {
        return percentageInBronze;
    }

    public void setPercentageInBronze(Float percentageInBronze) {
        this.percentageInBronze = percentageInBronze;
    }

    public String getPrimaryLeague() {
        return primaryLeague;
    }

    public void setPrimaryLeague(String primaryLeague) {
        this.primaryLeague = primaryLeague;
    }
    
}
