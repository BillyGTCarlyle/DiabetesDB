package com.billycarlyle.diabetesdb;

import android.app.Dialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
                if(TextUtils.isEmpty(editCarbCount.getText()) || TextUtils.isEmpty(editGlucoseLevel.getText())){
                    showDialog("Please enter at least a carb count and glucose level.");
                }else {
                    String carbType = editCarbType.getSelectedItem().toString();
                    float carbCount = Float.valueOf(editCarbCount.getText().toString());
                    float glucoseLevel = Float.valueOf(editGlucoseLevel.getText().toString());
                    InsertAsyncTask insertAsyncTask = new InsertAsyncTask();
                    Meal meal = new Meal(carbType, carbCount, glucoseLevel, false, false);
                    insertAsyncTask.execute(meal);
                    Log.d("DATABASE", "Added new meal to db");
                    showToast("Meal added to database.");
                    finish();
                }
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

    public void showDialog(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(AddMealActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Ok",
            new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.dismiss();
                }
            });
        alertDialog.show();
    }

    public void showToast(String message){
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this,message,duration);
        toast.show();
    }
}