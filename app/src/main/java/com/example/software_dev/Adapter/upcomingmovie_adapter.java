package com.example.software_dev.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.Movie_description;
import com.example.software_dev.R;
import com.example.software_dev.ViewHolder.latest_ViewHolder;
import com.example.software_dev.dataitem.upcomingdataitem;
import com.example.software_dev.upcoming_movie_description;

import java.util.List;

public class upcomingmovie_adapter extends RecyclerView.Adapter<latest_ViewHolder> {
    Context context;
    List<upcomingdataitem> list;

    public upcomingmovie_adapter(Context context, List<upcomingdataitem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public latest_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new latest_ViewHolder(LayoutInflater.from(context).inflate(R.layout.latest_movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull latest_ViewHolder holder, int position) {
        holder.MovieName.setText(String.valueOf(list.get(position).getupcoming_moviename()));
        holder.Rating.setText(String.valueOf(list.get(position).getupcoming_rating()));
        holder.MoviePoster.setImageResource(list.get(position).getMoviePoster());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    AppCompatActivity activity= (AppCompatActivity) v.getContext();
                upcoming_movie_description upcoming_movie_description=new upcoming_movie_description();
                    int clickpopsition=holder.getAdapterPosition();
                    String name=String.valueOf(list.get(clickpopsition).getupcoming_moviename());
                    String rating=String.valueOf(list.get(clickpopsition).getupcoming_rating());
                    int image=list.get(clickpopsition).getMoviePoster();
                    Bundle bundle=new Bundle();
                    bundle.putString("Moviename",name);
                    bundle.putString("Rating",rating);
                    bundle.putInt("Poster",image);
                    upcoming_movie_description.setArguments(bundle);
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,upcoming_movie_description).addToBackStack(null).commit();

                }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
