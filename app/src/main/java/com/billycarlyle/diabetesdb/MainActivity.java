package com.billycarlyle.diabetesdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
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

        //This button is for viewing the database in the future.
        Button btnViewDb = (Button) findViewById(R.id.btnViewDb);
        btnViewDb.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("BUTTONS","User tapped btnViewDb");
                Intent openViewMeals = new Intent(MainActivity.this,ViewMealsActivity.class);
                MainActivity.this.startActivity(openViewMeals);
            }

        });

        createNotificationChannel();
    }

    private void createNotificationChannel(){
        //create the notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "DB_Channel";
            String description = "Notification channel for DiabetesDB";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("DB_Channel",name,importance);
            channel.setDescription(description);
            //register channel with the system
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}