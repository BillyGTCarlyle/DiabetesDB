package com.billycarlyle.diabetesdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MealRepository {
    private MealDao mealDao;

    MealRepository(Application application){
        MealDatabase db = MealDatabase.getDatabase(application);
        mealDao = db.mealDao();
    }

    void insert(Meal meal){
        MealDatabase.databaseWriteExecutor.execute(() -> {mealDao.insert(meal);});
    }

}
