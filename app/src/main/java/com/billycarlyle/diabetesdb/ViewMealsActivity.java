package com.billycarlyle.diabetesdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;

import java.util.List;

public class ViewMealsActivity extends AppCompatActivity {

    private MealViewModel mealViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);

        mealViewModel = new ViewModelProvider(this).get(MealViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MealListAdapter adapter = new MealListAdapter(new MealListAdapter.MealDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mealViewModel.getAllMeals().observe(this,meals -> {
            //Update the cached copy of the meals in the adapter.
            adapter.submitList(meals);
        });
    }



}