package com.example.middleman.model;

public class Rider {
    String rider_name;
    String rider_Id;
    String mobile;

    public Rider(String rider_name, String rider_Id, String mobile) {
        this.rider_name = rider_name;
        this.rider_Id = rider_Id;
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRider_name() {
        return rider_name;
    }

    public void setRider_name(String rider_name) {
        this.rider_name = rider_name;
    }

    public String getRider_Id() {
        return rider_Id;
    }

    public void setRider_Id(String rider_Id) {
        this.rider_Id = rider_Id;
    }
}
