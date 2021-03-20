package com.daycare.demo.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

    private Long activityId;
    private String activityName;
    private String activityDate;
    private String activityStatus;
    private Long teamId;

    public Activity() {
    }

    public Activity(Long activityId, String activityName, String activityDate,
                    String activityStatus, Long teamId) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityDate = activityDate;
        this.activityStatus = activityStatus;
        this.teamId = teamId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}