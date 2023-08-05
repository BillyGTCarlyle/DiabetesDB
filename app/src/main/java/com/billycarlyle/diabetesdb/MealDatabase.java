package com.billycarlyle.diabetesdb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RenameTable;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Meal.class},
        version = 2
        )
public abstract class MealDatabase extends RoomDatabase {
    public abstract MealDao mealDao();

    private static volatile MealDatabase mealDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MealDatabase getDatabase(final Context context){
        if(mealDatabase == null){
            synchronized (MealDatabase.class){
                if(mealDatabase == null){
                    mealDatabase = Room.databaseBuilder(context.getApplicationContext(),MealDatabase.class,"meal_database").addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration().build();
                }
            }
        }
        return mealDatabase;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);

            databaseWriteExecutor.execute(() ->{
                    MealDao dao = mealDatabase.mealDao();
                    dao.deleteAll();
            });
        }
    };

}
