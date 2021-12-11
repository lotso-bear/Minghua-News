package com.laioffer.tindernews;

import android.app.Application;

import androidx.room.Room;

import com.laioffer.tindernews.database.TinNewsDatabase;

public class TinNewsApplication extends Application {
    private static TinNewsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(this, TinNewsDatabase.class, "tinnews_db").build();
    }

    public static TinNewsDatabase getDatabase() {
        return database;
    }
}
