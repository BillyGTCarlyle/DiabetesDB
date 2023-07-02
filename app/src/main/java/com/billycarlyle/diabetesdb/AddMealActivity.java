package com.billycarlyle.diabetesdb;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddMealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmeal);

        //setup button variables
        Button btnClose = (Button) findViewById(R.id.btnClose);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        //setup text variables
        EditText editCarbCount = (EditText) findViewById(R.id.editCarbCount);
        EditText editGlucoseLevel = (EditText) findViewById(R.id.editGlucoseLevel);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, CARBS);
        Spinner editCarbType = (Spinner) findViewById(R.id.editCarbType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editCarbType.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String carbType = editCarbType.getSelectedItem().toString();
                float carbCount = Float.valueOf(editCarbCount.getText().toString());
                float glucoseLevel = Float.valueOf(editGlucoseLevel.getText().toString());
                InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
                Meal meal = new Meal(carbType,carbCount,glucoseLevel,false,false);
                insertAsyncTask.execute(meal);
                Log.d("DATABASE","Added new meal to db");
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("BUTTONS","User tapped btnClose");
                finish();
            }
        });
    }

    private static final String[] CARBS = new String[]{
            "White bread", "Brown bread", "Potato", "Sweet potato", "White pasta", "Brown pasta", "Sugar"
    };

    class InsertAsyncTask extends AsyncTask<Meal, Void, Void> {

        @Override
        protected Void doInBackground(Meal... meals) {

            MealDatabase.getDatabase(getApplicationContext()).mealDao().insert(meals[0]);
            return null;
        }
    }
}