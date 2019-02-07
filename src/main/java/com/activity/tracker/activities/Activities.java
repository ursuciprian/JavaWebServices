package com.activity.tracker.activities;

import com.activity.tracker.services.ServiceActivity;
import com.activity.tracker.ws.ActivityInterface;
import javafx.util.Duration;

import javax.jws.WebService;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity (name = "ACTIVITIES")
public class Activities{
    @Id
    private int activityId;
    @Column
    private String activityName;
    @Column
    private String difficulty;
    @Column
    private boolean trainingRequired;

    public Activities(int activityId,String activityName, String difficulty, boolean trainingRequired) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.difficulty = difficulty;
        this.trainingRequired = trainingRequired;
    }

    public Activities(){}

    public int getActivityId(){
        return  activityId;
    }

    public void setActivityId(int activityId){

        this.activityId=activityId;
    }
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isTrainingRequired() {
        return trainingRequired;
    }

    public void setTrainingRequired(boolean trainingRequired) {
        this.trainingRequired = trainingRequired;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", trainingRequired=" + trainingRequired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Activities that = (Activities) o;
        return activityId == that.activityId &&
                trainingRequired == that.trainingRequired &&
                activityName.equals (that.activityName) &&
                difficulty.equals (that.difficulty);
    }

    @Override
    public int hashCode() {
        return Objects.hash (activityId, activityName, difficulty, trainingRequired);
    }
}
