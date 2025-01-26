package com.pranjaldas.healthsteps.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(StepsDataIdEntity.class)
@Table(name="stepsdata")
public class StepsDataEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "team_id")
    private Integer teamId;

    @Column(name = "steps_count")
    private Integer stepsCount;

    @Column(name = "username")
    private String username;

    @Column(name = "team_name")
    private String teamName;

    @Id
    @Column(name = "steps_at", nullable = false)
    private Date stepsAt;

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getStepsAt() {
        return stepsAt;
    }

    public void setStepsAt(Date stepsAt) {
        this.stepsAt = stepsAt;
    }    
}
