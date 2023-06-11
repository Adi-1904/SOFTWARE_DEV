package com.example.software_dev;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Movie_description extends Fragment {

TextView moviename,Rating,Movie_description;
Button book;
ImageView Movie_Poster;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_movie_description, container, false);
        moviename=view.findViewById(R.id.name);
        Rating=view.findViewById(R.id.rating);
        book=view.findViewById(R.id.Bookticket_btn);
        Movie_Poster=view.findViewById(R.id.movie_poster);
        Movie_description=view.findViewById(R.id.description);


        String name=getArguments().getString("Moviename");
        String rating=getArguments().getString("Rating");
        int moviePoster=getArguments().getInt("Poster");

        moviename.setText(String.valueOf(name));
        Rating.setText(String.valueOf(rating));
        Movie_Poster.setImageResource(moviePoster);

        if(name=="Avenger Endgame")
            Movie_description.setText("The grave course of events set in motion by Thanos that wiped out half the universe and fractured the Avengers ranks compels the remaining Avengers to take one final stand in Marvel Studios' grand conclusion to twenty-two films,\n Avengers Endgame");
        else if (name=="john wick") {
            Movie_description.setText("With the price on his head ever increasing, legendary hit man John Wick takes his fight against the High Table global as he seeks out the most powerful players in the underworld, from New York to Paris to Japan to Berlin.\n John Wick");
        }
        else if (name=="Fast x") {
            Movie_description.setText("Over many missions and against impossible odds, Dom Toretto and his family have outsmarted and outdriven every foe in their path. Now, they must confront the most lethal opponent they've ever faced. Fueled by revenge, a terrifying threat emerges from the shadows of the past to shatter Dom's world and destroy everything -- and everyone -- he loves.");
        }
        else if (name=="suzume") {
            Movie_description.setText("As the skies turn red and the planet trembles, Japan stands on the brink of disaster. However, a determined teenager named Suzume sets out on a mission to save her country. Able to see supernatural forces that others cannot, it's up to her to close the mysterious doors that are spreading chaos across the land. A perilous journey awaits as the fate of Japan rests on her shoulders.");
        }
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity= (AppCompatActivity) v.getContext();
                Bundle data=new Bundle();
                data.putString("Moviename",name);
                Hall_select hall_select=new Hall_select();
                hall_select.setArguments(data);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,hall_select).addToBackStack(null).commit();

            }
        });


        return view;
    }
}