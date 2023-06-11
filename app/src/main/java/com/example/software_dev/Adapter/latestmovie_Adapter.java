package com.example.software_dev.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.software_dev.Movie_description;
import com.example.software_dev.R;
import com.example.software_dev.ViewHolder.latest_ViewHolder;
import com.example.software_dev.dataitem.data_item;

import java.util.List;

public class latestmovie_Adapter extends RecyclerView.Adapter<latest_ViewHolder> {
    Context context;
    List<data_item> item;


    public latestmovie_Adapter(Context context, List<data_item> item) {
        this.context = context;
        this.item = item;
    }

    @Override
    public latest_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new latest_ViewHolder(LayoutInflater.from(context).inflate(R.layout.latest_movie_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull latest_ViewHolder holder,int position) {
        holder.Rating.setText(String.valueOf(item.get(position).getRating()));
        holder.MovieName.setText(String.valueOf(item.get(position).getMoviename()));
        holder.MoviePoster.setImageResource(item.get(position).getMoviePoster());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity= (AppCompatActivity) v.getContext();
                Movie_description movie_description=new Movie_description();
                int clickpopsition=holder.getAdapterPosition();
                String name=String.valueOf(item.get(clickpopsition).getMoviename());
                String rating=String.valueOf(item.get(clickpopsition).getRating());
                int image=item.get(clickpopsition).getMoviePoster();
                Bundle bundle=new Bundle();
                bundle.putString("Moviename",name);
                bundle.putString("Rating",rating);
                bundle.putInt("Poster",image);
                movie_description.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container,movie_description).addToBackStack(null).commit();

            }
       });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
