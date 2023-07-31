package com.billycarlyle.diabetesdb;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MealViewModel extends AndroidViewModel {
    private MealRepository mealRepository;

    private final LiveData<List<Meal>> allMeals;

    public MealViewModel (Application application){
        super(application);
        mealRepository = new MealRepository(application);
        allMeals = mealRepository.getAllMeals();
    }

    LiveData<List<Meal>> getAllMeals(){
        return allMeals;
    }

    public void insert(Meal meal){
        mealRepository.insert(meal);
    }
}
