package com.billycarlyle.diabetesdb;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "meal_table")
public class Meal {
    @PrimaryKey(autoGenerate = true)
    int id = 0;
    String carbType;
    float carbCount;
    float glucoseLevelStart;
    float glucoseLevel1h;
    boolean withFat;
    boolean exerciseDay;
    public Meal(String carbType, float carbCount, float glucoseLevelStart, boolean withFat, boolean exerciseDay){
        this.carbType = carbType;
        this.carbCount = carbCount;
        this.glucoseLevelStart = glucoseLevelStart;
        this.withFat = withFat;
        this.exerciseDay = exerciseDay;
    }

    public List<String> getDetails(){
        List<String> details = new ArrayList<String>();
        details.add(Integer.toString(id));
        details.add(carbType);
        details.add(Float.toString(carbCount));
        details.add(Float.toString(glucoseLevelStart));
        details.add(Boolean.toString(withFat));
        details.add(Boolean.toString(exerciseDay));
        details.add(Float.toString(glucoseLevel1h));
        return details;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getcarbType(){
        return carbType;
    }
    public void setCarbType(String carbType){
        this.carbType = carbType;
    }

    public float getCarbCount(){
        return carbCount;
    }
    public void setCarbCount(float carbCount){
        this.carbCount = carbCount;
    }

    public float getGlucoseLevelStart(){
        return glucoseLevelStart;
    }
    public void setGlucoseLevelStart(float glucoseLevelStart){
        this.glucoseLevelStart = glucoseLevelStart;
    }

    public float getGlucoseLevel1h(){
        return glucoseLevel1h;
    }
    public void setGlucoseLevel1h(float glucoseLevel1h){
        this.glucoseLevel1h = glucoseLevel1h;
    }

    public boolean isWithFat(){
        return withFat;
    }
    public void setWithFat(boolean withFat){
        this.withFat = withFat;
    }

    public boolean isExerciseDay(){
        return exerciseDay;
    }
    public void setExerciseDay(boolean exerciseDay){
        this.exerciseDay = exerciseDay;
    }
}
