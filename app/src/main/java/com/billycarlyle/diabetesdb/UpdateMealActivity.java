package com.billycarlyle.diabetesdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateMealActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatemeal);

        //set up UI elements
        EditText editGlucoseLevel1h = (EditText) findViewById(R.id.editGlucoseLevel1h);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //User must enter a value.
                if(TextUtils.isEmpty(editGlucoseLevel1h.getText())){
                    showToast("Please enter a value");
                }else{
                    //Grab value from UI and update the database.
                    float glucoseLevel1h = Float.valueOf(editGlucoseLevel1h.getText().toString());
                    UpdateAsyncTask updateAsyncTask = new UpdateAsyncTask();
                    updateAsyncTask.execute(glucoseLevel1h);
                    Log.d("DATABASE","Updated latest meal using glucose level:"+glucoseLevel1h);
                    showToast("Meal updated.");
                    finish();
                }
            }
        });
    }

    class UpdateAsyncTask extends AsyncTask<Float, Void, Void> {

        @Override
        protected Void doInBackground(Float... floats) {
            Meal lastMealFromDB = MealDatabase.getDatabase(getApplicationContext()).mealDao().getLastMeal();
            lastMealFromDB.setGlucoseLevel1h(floats[0]);
            MealDatabase.getDatabase(getApplicationContext()).mealDao().update(lastMealFromDB);
            return null;
        }
    }

//    class GetLastMealAsyncTask extends AsyncTask<Void, Void, Meal>{
//        Meal lastMealFromDB = new Meal("Bread",5,5,false,false);
//
//        @Override
//        protected Meal doInBackground(Void... voids) {
//            lastMealFromDB = MealDatabase.getDatabase(getApplicationContext()).mealDao().getLastMeal();
//            Log.d("DATABASE",lastMealFromDB.getcarbType());
//            return lastMealFromDB;
//        }
//
//        protected Meal onPostExecute(Meal result){
//            lastMeal = result;
//            Log.d("DATABASE","Ran postexecute");
//            return lastMeal;
//        }
//
//    }

    public void showToast(String message) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }
}