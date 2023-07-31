package com.billycarlyle.diabetesdb;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MealRepository {
    private MealDao mealDao;
    private LiveData<List<Meal>> allMeals;

    MealRepository(Application application){
        MealDatabase db = MealDatabase.getDatabase(application);
        mealDao = db.mealDao();
        allMeals = mealDao.getMealsById();
    }

    LiveData<List<Meal>> getAllMeals(){
        return allMeals;
    }

    void insert(Meal meal){
        MealDatabase.databaseWriteExecutor.execute(() -> {mealDao.insert(meal);});
    }

}
