package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Febrinanda on 12/13/2017.
 * Hello cruel worlds!
 */
@Database(entities = {Loker.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    abstract LokerDAO lokerDAO();
}
