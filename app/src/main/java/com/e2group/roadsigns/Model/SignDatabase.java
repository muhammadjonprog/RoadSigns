package com.e2group.roadsigns.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CategoriesSign.class},version = 1,exportSchema = false)
public abstract class SignDatabase extends RoomDatabase {
    public static SignDatabase signDatabase;
    public synchronized static SignDatabase getInstance(Context context){
        if (signDatabase != null){
            return signDatabase;
        }
        signDatabase = Room.databaseBuilder(
                context.getApplicationContext(),
                SignDatabase.class,
                "ar")
                .createFromAsset("alomati_roh.db")
                .fallbackToDestructiveMigration()
                .build();
        return signDatabase;
    }
    public abstract SignDao signDao();
}
