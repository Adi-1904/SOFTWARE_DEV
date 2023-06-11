package com.example.software_dev.dataitem;

public class data_item {
    String Moviename;
    String rating;
    int MoviePoster;

    public data_item(String moviename, String rating,int MoviePoster) {
        this.Moviename = moviename;
        this.rating = rating;
        this.MoviePoster=MoviePoster;
    }

    public int getMoviePoster() {
        return MoviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        MoviePoster = moviePoster;
    }

    public String getMoviename() {
        return Moviename;
    }

    public void setMoviename(String moviename) {
        Moviename = moviename;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
