package com.sutema.apps.alumnitracker;

/**
 * Created by Febrinanda on 11/9/2017.
 * Happy Coding Worlds!
 */

class User {
    private int ID;
    private String fullName;
    private String address;
    private String email;
    private String phone;

    public int getID() {
        return ID;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    String getFullName() {
        return fullName;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
}
