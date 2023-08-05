package com.billycarlyle.diabetesdb;

import android.provider.SyncStateContract;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimestampConverter {

    @TypeConverter
    public static LocalDateTime toDate(String value){
        if(value != null){
            return LocalDateTime.parse(value);
        }else{
            return null;
        }
    }

    @TypeConverter
    public static String toDateString(LocalDateTime date){
        if(date != null){
            return date.toString();
        }else{
            return null;
        }
    }
}
