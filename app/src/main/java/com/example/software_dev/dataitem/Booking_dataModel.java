package com.example.software_dev.dataitem;

import java.util.ArrayList;

public class Booking_dataModel {
    String Moviename,seat,date,hallname,row,time,image;

//    public Booking_dataModel(String moviename, String date, String hallname, String row, String time, ArrayList<String> uniqueArrayList) {
//        Moviename = moviename;
//        this.date = date;
//        this.hallname = hallname;
//        this.row = row;
//        this.time = time;
//        this.uniqueArrayList = uniqueArrayList;


//    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMoviename() {
        return Moviename;
    }

    public void setMoviename(String moviename) {
        Moviename = moviename;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHallname() {
        return hallname;
    }

    public void setHallname(String hallname) {
        this.hallname = hallname;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
