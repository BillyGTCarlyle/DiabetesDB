package com.billycarlyle.diabetesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddMeal = (Button) findViewById(R.id.btnAddMeal);
        btnAddMeal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Log.d("BUTTONS","User tapped btnAddMeal");
                Intent openAddMeal = new Intent(MainActivity.this, AddMealActivity.class);
                MainActivity.this.startActivity(openAddMeal);
            }
        });

        //This button is for viewing the database in the future, but here I'm using it to add a test meal to the database.
        Button btnViewDb = (Button) findViewById(R.id.btnViewDb);
        btnViewDb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("BUTTONS","User tapped btnViewDb");
                insertTestMeal(v);
            }
        });
    }

    public void insertTestMeal(View v){
        Meal meal = new Meal("White bread",20,5.6f,false,false);
        InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
        insertAsyncTask.execute(meal);
    }

    //setting up an asynchronous task for inserting meals to the db
    class InsertAsyncTask extends AsyncTask<Meal, Void, Void>{

        @Override
        protected Void doInBackground(Meal... meals) {

            MealDatabase.getDatabase(getApplicationContext()).mealDao().insert(meals[0]);
            return null;
        }
    }
}