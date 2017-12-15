package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface LokerDAO{
    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Loker... lokers);

    @Update
    void update(Loker... lokers);

    @Delete
    void delete(Loker... lokers);

    @Query("SELECT * FROM Loker")
    Loker[] loadAllLokers();

    @Query("SELECT * FROM Loker WHERE id = :idloker")
    Loker getLokerById(int idloker);

}