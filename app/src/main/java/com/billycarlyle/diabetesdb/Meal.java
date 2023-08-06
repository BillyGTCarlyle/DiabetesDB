package com.billycarlyle.diabetesdb;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "meal_table2")
public class Meal {
    @PrimaryKey(autoGenerate = true)
    int id = 0;
    String carbType;
    float carbCount;
    float glucoseLevelStart;
    float glucoseLevel1h;
    boolean withFat;
    boolean exerciseDay;
    float insulin;
    @TypeConverters({TimestampConverter.class})
    LocalDateTime dateTime;
    String notes;

    public Meal(String carbType, float carbCount, float glucoseLevelStart, boolean withFat, boolean exerciseDay, float insulin){
        this.carbType = carbType;
        this.carbCount = carbCount;
        this.glucoseLevelStart = glucoseLevelStart;
        this.withFat = withFat;
        this.exerciseDay = exerciseDay;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateTime = LocalDateTime.now();
        }

    }

    public List<String> getDetails(){
        List<String> details = new ArrayList<String>();
        details.add(Integer.toString(id));
        details.add(carbType);
        details.add(Float.toString(carbCount));
        details.add(Float.toString(glucoseLevelStart));
        details.add(Boolean.toString(withFat));
        details.add(Boolean.toString(exerciseDay));
        details.add(Float.toString(insulin));
        details.add(Float.toString(glucoseLevel1h));
        details.add(dateTime.toString());
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

    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    public float getInsulin(){
        return insulin;
    }
    public void setInsulin(float insulin){
        this.insulin = insulin;
    }
}
