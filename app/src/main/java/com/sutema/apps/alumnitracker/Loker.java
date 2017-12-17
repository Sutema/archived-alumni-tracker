package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Febrinanda on 12/13/2017.
 */

@Entity
class Loker {
    @PrimaryKey
    public int id;

    String position;
    String desc;
    String company;
    String created_at;
    String updated_at;
    String deadline_at;
    String url;
    String submitter;

    @Ignore
    public Loker(){

    }

    public Loker(int id, String position,String company){
        this.id = id;
        this.position = position;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDeadline_at() {
        return deadline_at;
    }

    public void setDeadline_at(String deadline_at) {
        this.deadline_at = deadline_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }



}
