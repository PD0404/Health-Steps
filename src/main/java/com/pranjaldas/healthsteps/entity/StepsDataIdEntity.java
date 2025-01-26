package com.pranjaldas.healthsteps.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class StepsDataIdEntity implements Serializable {

    private Integer userId;
    private Date stepsAt;

    public StepsDataIdEntity() {
    }

    public StepsDataIdEntity(Integer userId, Date stepsAt) {
        this.userId = userId;
        this.stepsAt = stepsAt;
    }

    // Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getstepsAt() {
        return stepsAt;
    }

    public void setstepsAt(Date stepsAt) {
        this.stepsAt = stepsAt;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepsDataIdEntity stepsDataId = (StepsDataIdEntity) o;
        return Objects.equals(userId, stepsDataId.userId) &&
                Objects.equals(stepsAt, stepsDataId.stepsAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, stepsAt);
    }
}
