package com.billycarlyle.diabetesdb;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MealDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    @Update
    void update(Meal meal);

    @Query("DELETE from meal_table")
    void deleteAll();

    @Query("SELECT * FROM meal_table ORDER BY carbType ASC")
    LiveData<List<Meal>> getAlphabetizedMeals();
}
