package com.example.model;

import java.util.Date;

public class Postdiendan {
    int id;
    String name;
    String time;
    String content;

    public Postdiendan(int id, String name, String time, String content) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.content = content;
    }

    public Postdiendan(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
