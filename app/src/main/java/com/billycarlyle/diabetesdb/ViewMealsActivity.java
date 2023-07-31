package com.billycarlyle.diabetesdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ViewMealsActivity extends AppCompatActivity {

    private MealViewModel mealViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_meals);

        Button btnCloseDB = (Button) findViewById(R.id.btnCloseDB);

        btnCloseDB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("BUTTONS","User tapped btnCloseDB");
                finish();
            }
        });

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