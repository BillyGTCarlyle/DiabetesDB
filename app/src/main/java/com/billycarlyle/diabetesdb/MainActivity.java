package com.billycarlyle.diabetesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    }
}