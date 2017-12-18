package com.sutema.apps.alumnitracker;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Febrinanda on Mon,18 December 2017.
 * Happy Coding Worlds!
 */

@Entity
class Loker {
    @PrimaryKey
    private int id;

    private String position;
    private String desc;
    private String company;
    private String created_at;
    private String updated_at;
    private String deadline_at;
    private String url;
    private String submitter;

    @Ignore
    Loker(){

    }

    Loker(int id, String position, String company){
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

    String getPosition() {
        return position;
    }

    void setPosition(String position) {
        this.position = position;
    }

    String getDesc() {
        return desc;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getCreated_at() {
        return created_at;
    }

    void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    String getUpdated_at() {
        return updated_at;
    }

    void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    String getDeadline_at() {
        return deadline_at;
    }

    void setDeadline_at(String deadline_at) {
        this.deadline_at = deadline_at;
    }

    String getUrl() {
        return url;
    }

    void setUrl(String url) {
        this.url = url;
    }

    String getSubmitter() {
        return submitter;
    }

    void setSubmitter(String submitter) {
        this.submitter = submitter;
    }



}
