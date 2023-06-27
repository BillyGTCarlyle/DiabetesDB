package com.billycarlyle.diabetesdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MealDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Meal meal);

    @Update
    void update(Meal meal);

    @Query("DELETE from meal_table")
    void deleteAll();
}
