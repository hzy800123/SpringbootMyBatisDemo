package com.testSpringBootWeb.demo.webObject;

public class WebRequest {
    private String id;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "WebRequest{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
