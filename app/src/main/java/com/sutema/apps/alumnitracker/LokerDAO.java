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
    public void insert(Loker... lokers);

    @Update
    public void update(Loker... lokers);

    @Delete
    public void delete(Loker... lokers);

    @Query("SELECT * FROM Loker")
    public Loker[] loadAllLokers();

    @Query("SELECT * FROM Loker WHERE id = :idloker")
    public Loker getLokerById(int idloker);

}