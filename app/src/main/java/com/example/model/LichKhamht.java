package com.example.model;

import java.io.Serializable;

public class LichKhamht implements Serializable {
    int id;
    String name;
    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LichKhamht(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public LichKhamht(int id, String name, String date, String time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    String time;


}
