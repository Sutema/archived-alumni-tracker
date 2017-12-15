package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Febrinanda on 12/15/2017.
 */

public class DbSingleton {
    private static DbSingleton single_instance = null;
    AppDatabase appDatabase;

    private DbSingleton(Context context){
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "sutema.db").build();
    }

    public static DbSingleton getInstance(Context context){
        if(single_instance == null){
            single_instance = new DbSingleton(context);
        }
        return single_instance;
    }
}
