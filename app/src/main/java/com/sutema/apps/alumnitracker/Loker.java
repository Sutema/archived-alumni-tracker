package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by Febrinanda on 12/13/2017.
 */

@Entity
class Loker {
    @PrimaryKey
    public int id;

    public String position;
    public String desc;
    public String company;
    public String created_at;
    public String updated_at;
    public String deadline_at;
    public String url;
    public String submitter;

}
