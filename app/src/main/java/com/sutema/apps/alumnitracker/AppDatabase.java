package com.sutema.apps.alumnitracker;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

/**
 * Created by Febrinanda on 12/13/2017.
 * Hello cruel worlds!
 */
@Database(entities = {Loker.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
    abstract LokerDAO lokerDAO();

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.beginTransaction();
            database.execSQL("ALTER TABLE Loker RENAME TO Loker_orig");
            database.execSQL("CREATE TABLE Loker(id INTEGER NOT NULL, " +
                    "position TEXT, " +
                    "desc TEXT, " +
                    "company TEXT, " +
                    "createdAt TEXT, " +
                    "updatedAt TEXT, " +
                    "deadlineAt TEXT, " +
                    "url TEXT, " +
                    "submitter TEXT," +
                    "PRIMARY KEY(id))");
            database.execSQL("INSERT INTO Loker(id,position,desc,company,createdAt,updatedAt,deadlineAt,url,submitter)" +
                    "SELECT * FROM Loker_orig");
            database.execSQL("DROP TABLE Loker_orig");
            database.endTransaction();
        }
    };
}
