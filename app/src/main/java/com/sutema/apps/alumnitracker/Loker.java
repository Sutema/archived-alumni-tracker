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
    private String createdAt;
    private String updatedAt;
    private String deadlineAt;
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

    String getCreatedAt() {
        return createdAt;
    }

    void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    String getUpdatedAt() {
        return updatedAt;
    }

    void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    String getDeadlineAt() {
        return deadlineAt;
    }

    void setDeadlineAt(String deadlineAt) {
        this.deadlineAt = deadlineAt;
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
