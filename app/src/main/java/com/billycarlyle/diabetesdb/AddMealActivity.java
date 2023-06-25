package com.billycarlyle.diabetesdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddMealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmeal);

        Button btnClose = (Button) findViewById(R.id.btnClose);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, CARBS);
        Spinner editCarbType = (Spinner) findViewById(R.id.editCarbType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editCarbType.setAdapter(adapter);
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
}
