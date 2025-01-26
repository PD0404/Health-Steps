package com.pranjaldas.healthsteps.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(StepsDataIdEntity.class)
@Table(name="daily_steps_count")
public class DailyStepsCountEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "steps_count")
    private Integer stepsCount;

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

    public Integer getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(Integer stepsCount) {
        this.stepsCount = stepsCount;
    }
    
    public Date getStepsAt() {
        return stepsAt;
    }

    public void setStepsAt(Date stepsAt) {
        this.stepsAt = stepsAt;
    }    
}
