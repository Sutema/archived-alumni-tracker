package com.sutema.apps.alumnitracker;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import static com.sutema.apps.alumnitracker.AppDatabase.MIGRATION_1_2;

/**
 * Created by Febrinanda on 12/15/2017.
 * Hello cruel worlds!
 */

class DbSingleton {
    private static DbSingleton single_instance = null;
    AppDatabase appDatabase;

    private DbSingleton(Context context){
        DBasyncTask dBasyncTask = new DBasyncTask();
        dBasyncTask.execute(context);
    }

    static DbSingleton getInstance(Context context){
        if(single_instance == null){
            synchronized (DbSingleton.class){
                single_instance = new DbSingleton(context);
            }
        }
        return single_instance;
    }

    @SuppressLint("StaticFieldLeak")
    public class DBasyncTask extends AsyncTask<Context, Integer, String>{
        @Override
        protected String doInBackground(Context... contexts) {
            appDatabase = Room.databaseBuilder(contexts[0], AppDatabase.class, "sutema.db").addMigrations(MIGRATION_1_2).build();
            Log.i("DbSingleton","DB Singleton created!");
            return null;
        }
    }
}
