package com.example.software_dev.dataitem;

public class upcomingdataitem {
    String Upcoming_moviename;
    String Upcoming_rating;

    public upcomingdataitem(String upcoming_moviename, String upcoming_rating) {
        Upcoming_moviename = upcoming_moviename;
        this.Upcoming_rating = upcoming_rating;
    }

    public String getupcoming_moviename() {
        return Upcoming_moviename;
    }

    public void setupcoming_moviename(String upcoming_moviename) {
        Upcoming_moviename = upcoming_moviename;
    }

    public String getupcoming_rating() {
        return Upcoming_rating;
    }

    public void setupcoming_rating(String upcoming_rating) {
        this.Upcoming_rating = upcoming_rating;
    }
}
